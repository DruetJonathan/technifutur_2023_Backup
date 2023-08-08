package bstorm.demoSpring.dto;

import bstorm.demoSpring.entities.Book;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class BookWithAuthorDTO extends BookSimpleDTO {

    private String authorName;
    public BookWithAuthorDTO(Book book) {
        super(book);
        if(book.getAuthor() != null) {
            this.authorName = book.getAuthor().getName();
        }
    }
}
