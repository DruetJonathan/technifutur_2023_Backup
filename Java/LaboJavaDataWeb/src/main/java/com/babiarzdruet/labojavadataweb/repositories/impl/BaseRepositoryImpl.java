package com.babiarzdruet.labojavadataweb.repositories.impl;

import com.babiarzdruet.labojavadataweb.repositories.BaseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Optional;

public abstract class BaseRepositoryImpl<TKey, TEntity> implements BaseRepository<TKey, TEntity> {
    protected EntityManagerFactory emf;
    protected EntityManager em;

    public BaseRepositoryImpl() {

        this.emf = Persistence.createEntityManagerFactory("gameprodigy");
        this.em = emf.createEntityManager();
    }

    @Override
    public TEntity add(TEntity entity) {

        em.getTransaction().begin();

        em.persist(entity);

        em.getTransaction().commit();

        return entity;
    }

    @Override
    public abstract Optional<TEntity> getOne(TKey id);

    @Override
    public abstract List<TEntity> getAll();

    @Override
    public TEntity update(TEntity entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        return entity;
    }

    @Override
    public abstract TEntity delete(TKey id);
}
