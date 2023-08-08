package com.example.demowebapplabo.services;


import com.example.demowebapplabo.models.entities.Utilisateur;
import com.example.demowebapplabo.models.forms.UtilisateurForm;

import java.util.List;

public interface UtilisateurService {
    Utilisateur add(UtilisateurForm a);

    Utilisateur getOne(Long id);

    List<Utilisateur> getAll();

    void update(Long id, UtilisateurForm a);

    void delete(Long id);
}
