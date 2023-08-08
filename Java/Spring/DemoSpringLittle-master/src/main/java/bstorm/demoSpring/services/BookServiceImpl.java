package bstorm.demoSpring.services;

import bstorm.demoSpring.dto.BookAddDTO;
import bstorm.demoSpring.dto.BookSimpleDTO;
import bstorm.demoSpring.dto.BookWithAuthorDTO;
import bstorm.demoSpring.entities.Book;
import bstorm.demoSpring.exceptions.NotFoundException;
import bstorm.demoSpring.exceptions.UniqueException;
import bstorm.demoSpring.repositories.BookRepository;
import bstorm.demoSpring.utils.FileUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final FileUtils fileUtils;

    public BookServiceImpl(BookRepository bookRepository, FileUtils fileUtils) {
        this.bookRepository = bookRepository;
        this.fileUtils = fileUtils;
    }

    @Override
    public String getHello() {
        return "42";
    }

    @Override
    public Iterable<BookSimpleDTO> getAll(Pageable pageable) {
        return bookRepository.findAll(pageable)
                .stream()
                .map(BookSimpleDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public BookWithAuthorDTO getById(Long id) throws NotFoundException {
        return new BookWithAuthorDTO(bookRepository.findWithAuthorById(id).orElseThrow(NotFoundException::new));
    }

    @Override
    public BookSimpleDTO add(BookAddDTO dto) throws UniqueException, IOException {

        if(bookRepository.countByIsbn(dto.getIsbn()) != 0) {
            throw new UniqueException();
        }

        String fileName = null;
        if(dto.getImageBlob() != null) {
            fileName = fileUtils.save(dto.getImageBlob(), dto.getImageExt());
        }

        Book book = Book.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .isbn(dto.getIsbn())
                .releaseDate(dto.getRealeaseDate())
                .image(fileName)
                .isAvailable(true)
                .build();
        try {
            bookRepository.save(book);
        } catch (Exception exception) {
            fileUtils.remove(fileName);
        }

        return new BookSimpleDTO(book);
    }
}
