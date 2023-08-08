package bstorm.demoSpring.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = true, length = 65535)
    private String description;

    @Column(nullable = true)
    private Date releaseDate;

    @Column(nullable = false, unique = true)
    private String isbn;

    @Column(nullable = false)
    private Boolean isAvailable = true;

    @Column(name = "author_id", insertable = false, updatable = false)
    private Long authorId;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;


    @Column(nullable = true)
    private String image;

}
