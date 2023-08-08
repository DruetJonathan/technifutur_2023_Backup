package com.example.demowebapplabo.repositories.impl;

import com.example.demowebapplabo.repositories.BaseRepository;
import jakarta.persistence.*;

import java.util.List;
import java.util.Optional;


public class BaseRepositoryImpl<TKey,TEntity> implements BaseRepository<TKey,TEntity> {

    protected EntityManagerFactory emf;
    protected EntityManager em;

    public BaseRepositoryImpl() {

        this.emf = Persistence.createEntityManagerFactory("LaboJavaData-Web");
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
    public Optional<TEntity> getOne(TKey id) {
        Optional optional = em.find(Optional.class, id);
        return (Optional<TEntity>) Optional.ofNullable(optional);
    }

    @Override
    public List<TEntity> getAll() {
        return null;
    }

    @Override
    public void update(TEntity entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    @Override
    public void delete(TKey id) {
        em.getTransaction().begin();
        em.remove(em.merge(id));
        em.getTransaction().commit();
    }
}
