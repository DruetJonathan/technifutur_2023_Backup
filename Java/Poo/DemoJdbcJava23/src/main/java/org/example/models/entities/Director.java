package org.example.models.entities;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode
public class Director {
    private Integer id;
    private String firstname;
    private String pseudo;
    private String lastname;

    public Director(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
