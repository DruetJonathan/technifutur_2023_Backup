package bstorm.demoSpring.services;

import bstorm.demoSpring.dto.AuthorDTO;
import org.springframework.stereotype.Service;

@Service
public interface AuthorService {
    Iterable<AuthorDTO> getByKeyword(String keyword);
}
