package bstorm.demoSpring.dto;

import bstorm.demoSpring.entities.Author;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AuthorDTO {
    private Long id;
    private String name;

    public AuthorDTO(Author a) {
        id = a.getId();
        name = a.getName();
    }
}
