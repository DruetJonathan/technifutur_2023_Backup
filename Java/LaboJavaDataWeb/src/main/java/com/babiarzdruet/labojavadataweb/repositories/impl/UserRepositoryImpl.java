package com.babiarzdruet.labojavadataweb.repositories.impl;

import com.babiarzdruet.labojavadataweb.models.entities.RequestCoaching;
import com.babiarzdruet.labojavadataweb.models.entities.User;
import com.babiarzdruet.labojavadataweb.repositories.UserRepository;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Named @SessionScoped
public class UserRepositoryImpl extends BaseRepositoryImpl<Long, User> implements UserRepository, Serializable {
    @Override
    public User login(String email) {
        TypedQuery<User> query = this.em.createQuery(
                "SELECT u FROM User u WHERE u.email = :email", User.class);
        query.setParameter("email", email);
        User user = query.getSingleResult();
        return user;
    }

    @Override
    public Optional<User> getOne(Long id) {
        User user = em.find(User.class, id);
        return Optional.ofNullable(user);
    }

    @Override
    public List<User> getAll() {
        Query query = em.createQuery("SELECT u FROM User u");
        return (List<User>) query.getResultList();
    }

    @Override
    public User delete(Long id) {
        em.getTransaction().begin();
        Optional<User> user = this.getOne(id);
        if (user.isPresent())
            em.remove(user.get());
        em.getTransaction().commit();
        return user.get();
    }
}
