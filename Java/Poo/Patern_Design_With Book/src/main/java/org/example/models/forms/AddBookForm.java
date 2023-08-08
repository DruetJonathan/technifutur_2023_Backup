package org.example.models.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
public class AddBookForm {
    @Getter @Setter
    private String title,description,author;
}
