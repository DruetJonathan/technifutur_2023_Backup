package com.example.demowebapplabo.models.entities;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity @Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Utilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String nom;
    @Column(length = 50)
    private String second_nom;

    @Column(length = 255)
    private String mot_de_passe;
    @Column(length = 255)
    private String email;
}
