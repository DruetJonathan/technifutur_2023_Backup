package bstorm.demoSpring.services;

import bstorm.demoSpring.dto.BookAddDTO;
import bstorm.demoSpring.dto.BookSimpleDTO;
import bstorm.demoSpring.dto.BookWithAuthorDTO;
import bstorm.demoSpring.exceptions.NotFoundException;
import bstorm.demoSpring.exceptions.UniqueException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface BookService {
    String getHello();

    Iterable<BookSimpleDTO> getAll(Pageable pageable);

    BookWithAuthorDTO getById(Long id) throws NotFoundException;

    BookSimpleDTO add(BookAddDTO dto) throws UniqueException, IOException;
}
