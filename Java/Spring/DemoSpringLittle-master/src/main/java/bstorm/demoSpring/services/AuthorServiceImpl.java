package bstorm.demoSpring.services;

import bstorm.demoSpring.dto.AuthorDTO;
import bstorm.demoSpring.repositories.AuthorRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<AuthorDTO> getByKeyword(String keyword) {
        return authorRepository.findByKeyword(keyword.toLowerCase(), PageRequest.of(0, 10)).stream()
                .map(AuthorDTO::new).collect(Collectors.toList());
    }
}
