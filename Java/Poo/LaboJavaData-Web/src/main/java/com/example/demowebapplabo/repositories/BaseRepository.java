package com.example.demowebapplabo.repositories;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<TKey,TEntity> {

    TEntity add(TEntity entity);

    Optional<TEntity> getOne(TKey id);

    List<TEntity> getAll();

    void update(TEntity entity);

    void delete(TKey id);
}
