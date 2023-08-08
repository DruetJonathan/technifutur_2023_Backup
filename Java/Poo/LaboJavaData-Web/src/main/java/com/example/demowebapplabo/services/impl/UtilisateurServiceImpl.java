package com.example.demowebapplabo.services.impl;

import com.example.demowebapplabo.models.entities.Utilisateur;
import com.example.demowebapplabo.models.forms.UtilisateurForm;
import com.example.demowebapplabo.repositories.UtilisateurRepository;
import com.example.demowebapplabo.repositories.impl.UtilisateurRepositoryImpl;
import com.example.demowebapplabo.utils.Cryptage;
import com.example.demowebapplabo.services.UtilisateurService;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class UtilisateurServiceImpl extends Cryptage implements UtilisateurService, Serializable {
    @Inject
    UtilisateurRepository utilisateurRepository;
    @Override
    public Utilisateur add(UtilisateurForm a) {
        // crypte le mdp
        utilisateurRepository = new UtilisateurRepositoryImpl();
        a.setMot_de_passe(Cryptage.cryptageMotDePasse(a.getMot_de_passe()));
        return utilisateurRepository.add(a.toEntity());
    }

    @Override
    public Utilisateur getOne(Long id) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.getOne(id);
        if (utilisateur.isEmpty()) {
            //TODO FAIRE EXCEPTION
            throw new RuntimeException();
        }
        return utilisateur.get();
    }

    @Override
    public List<Utilisateur> getAll() {
//        TypedQuery<Utilisateur> query = em.createQuery("SELECT u FROM Utilisateur u", Utilisateur.class);
//        List<Utilisateur> utilisateurs = query.getResultList();
//        em.clear();
//        return utilisateurs;
        return null;
    }

    @Override
    public void update(Long id, UtilisateurForm utilisateur) {
        utilisateurRepository = new UtilisateurRepositoryImpl();
        Utilisateur u = utilisateur.toEntity();
        u.setId(id);
        utilisateurRepository.update(u);
    }

    @Override
    public void delete(Long id) {
        utilisateurRepository.delete(id);
    }
}
