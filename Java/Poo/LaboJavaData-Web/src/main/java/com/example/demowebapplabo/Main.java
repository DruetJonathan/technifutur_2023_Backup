package com.example.demowebapplabo;

import com.example.demowebapplabo.models.entities.Utilisateur;
import com.example.demowebapplabo.models.forms.UtilisateurForm;
import com.example.demowebapplabo.services.UtilisateurService;
import com.example.demowebapplabo.services.impl.UtilisateurServiceImpl;

public class Main {
    public static void main(String[] args) {
        UtilisateurForm utilisateur = UtilisateurForm.builder()
                .nom("Kevin")
                .second_nom("Babiarz")
                .email("kevin.babiarz@gmail.com")
                .mot_de_passe("dundalk")
                .build();
        UtilisateurForm utilisateur2 = UtilisateurForm.builder()
                .nom("Eden")
                .second_nom("Gosset")
                .email("eden.gosset@gmail.com")
                .mot_de_passe("realmadrid")
                .build();
        UtilisateurForm utilisateurForm = new UtilisateurForm();
        UtilisateurService utilisateurService = new UtilisateurServiceImpl();
        utilisateurService.add(utilisateur);
        utilisateurService.add(utilisateur2);
        utilisateur2.setEmail("test@gmail.com");
        utilisateurService.update(6L,utilisateur2);
//        utilisateurService.getAll().forEach(System.out::println);
    }
}
