package bstorm.demoSpring.dto;

import bstorm.demoSpring.entities.Book;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookSimpleDTO {
    private Long id;
    private String title;
    private String description;
    private Boolean isAvailable;
    private Long authorId;
    private String image;

    public BookSimpleDTO(Book book) {
        id = book.getId();
        title = book.getTitle();
        description = book.getDescription();
        isAvailable = book.getIsAvailable();
        authorId = book.getAuthorId();
        image = book.getImage();;
    }
}
