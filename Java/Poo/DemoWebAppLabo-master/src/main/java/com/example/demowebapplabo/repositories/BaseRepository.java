package com.example.demowebapplabo.repositories;

import com.example.demowebapplabo.models.entities.Animal;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<TKey,TEntity> {

    TEntity add(TEntity entity);

    Optional<TEntity> getOne(TKey id);

    List<TEntity> getAll();

    TEntity update(TEntity entity);

    TEntity delete(TKey id);
}
