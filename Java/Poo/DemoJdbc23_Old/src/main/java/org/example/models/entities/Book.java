package org.example.models.entities;


import lombok.*;

@Builder @AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Book {
    private Integer id;
    private String title,description;

    public Book(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
