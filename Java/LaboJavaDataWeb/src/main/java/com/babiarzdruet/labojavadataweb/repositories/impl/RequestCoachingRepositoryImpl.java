package com.babiarzdruet.labojavadataweb.repositories.impl;

import com.babiarzdruet.labojavadataweb.models.entities.Game;
import com.babiarzdruet.labojavadataweb.models.entities.RequestCoaching;
import com.babiarzdruet.labojavadataweb.repositories.RequestCoachingRepository;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.persistence.Query;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Named
@SessionScoped

public class RequestCoachingRepositoryImpl extends BaseRepositoryImpl<Long, RequestCoaching> implements RequestCoachingRepository, Serializable {


    @Override
    public Optional<RequestCoaching> getOne(Long id) {
        RequestCoaching requestCoaching = em.find(RequestCoaching.class, id);
        return Optional.ofNullable(requestCoaching);
    }

    @Override
    public List<RequestCoaching> getAll() {
        Query query = em.createQuery("SELECT r FROM RequestCoaching r");
        return (List<RequestCoaching>) query.getResultList();
    }

    @Override
    public RequestCoaching delete(Long id) {
        em.getTransaction().begin();
        Optional<RequestCoaching> game = this.getOne(id);
        if (game.isPresent())
            em.remove(game.get());
        em.getTransaction().commit();
        return game.get();
    }
}
