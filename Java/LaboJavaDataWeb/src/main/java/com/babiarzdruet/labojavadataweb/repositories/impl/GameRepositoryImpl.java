package com.babiarzdruet.labojavadataweb.repositories.impl;

import com.babiarzdruet.labojavadataweb.models.entities.Game;
import com.babiarzdruet.labojavadataweb.repositories.GameRepository;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.persistence.Query;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Named
@SessionScoped

public class GameRepositoryImpl extends BaseRepositoryImpl<Long, Game> implements GameRepository, Serializable {
    @Override
    public List<Game> getAll() {
        Query query = em.createQuery("SELECT g FROM Game g");
        return (List<Game>) query.getResultList();
    }
    @Override
    public Optional<Game> getOne(Long id){
        Game game = em.find(Game.class, id);
//        Optional optional = em.getReference(Optional.class, id);
        return Optional.ofNullable(game);
    }
    @Override
    public Game delete(Long id){
        em.getTransaction().begin();
        Optional<Game> game = this.getOne(id);
        if (game.isPresent())
            em.remove(game.get());
        em.getTransaction().commit();
        return game.get();
    }
}

