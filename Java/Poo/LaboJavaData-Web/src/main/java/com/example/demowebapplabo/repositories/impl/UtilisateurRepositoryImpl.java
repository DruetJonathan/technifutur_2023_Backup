package com.example.demowebapplabo.repositories.impl;

import com.example.demowebapplabo.models.entities.Utilisateur;
import com.example.demowebapplabo.models.forms.UtilisateurForm;
import com.example.demowebapplabo.repositories.UtilisateurRepository;
import com.example.demowebapplabo.utils.Cryptage;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.persistence.TypedQuery;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class UtilisateurRepositoryImpl extends  BaseRepositoryImpl<Long, Utilisateur> implements UtilisateurRepository, Serializable {
    @Override
    public List<Utilisateur> getAll() {
        TypedQuery<Utilisateur> query = em.createQuery("SELECT u FROM Utilisateur u", Utilisateur.class);
        List<Utilisateur> utilisateurs = query.getResultList();
        em.clear();
        return utilisateurs;
    }
}
