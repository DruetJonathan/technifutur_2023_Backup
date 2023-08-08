package com.example.demowebapplabo.models.forms;

import com.example.demowebapplabo.models.entities.Animal;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor @ToString
public class AnimalForm {

    @NotBlank(message = "Champ obligatoire")
    @Size(max = 50, message = "Taille max fixée à 50")
    private String name;

    public Animal toEntity(){

        return Animal.builder()
                .name(getName())
                .build();
    }
}
