package com.example.demowebapplabo.models.forms;

import com.example.demowebapplabo.models.entities.Utilisateur;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UtilisateurForm {

    @NotBlank(message = "Le nom est obligatoire")
    @Size(max = 50, message = "Taille max fixée à 50")
    private String nom;

    @NotBlank(message = "Le deuxième nom est obligatoire")
    @Size(max = 50, message = "Taille max fixée à 50")
    private String second_nom;

    @NotBlank(message = "Le mot de passe est obligatoire")
    @Size(max = 50, message = "Taille max fixée à 50")
    private String mot_de_passe;

    @NotBlank(message = "L'email est obligatoire")
    @Size(max = 50, message = "Taille max fixée à 50")
    private String email;

    public Utilisateur toEntity() {
        return Utilisateur.builder()
                .nom(getNom())
                .second_nom(getSecond_nom())
                .mot_de_passe(getMot_de_passe())
                .email(getEmail())
                .build();
    }
}


