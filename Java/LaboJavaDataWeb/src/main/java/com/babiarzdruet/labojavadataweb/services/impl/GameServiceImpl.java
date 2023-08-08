package com.babiarzdruet.labojavadataweb.services.impl;

import com.babiarzdruet.labojavadataweb.exceptions.UserNotFoundException;
import com.babiarzdruet.labojavadataweb.models.entities.Game;
import com.babiarzdruet.labojavadataweb.repositories.GameRepository;
import com.babiarzdruet.labojavadataweb.services.GameService;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Named
@SessionScoped

public class GameServiceImpl implements GameService, Serializable {

    @Inject
    GameRepository gameRepository;
    @Override
    public Game add(Game game) {

        return this.gameRepository.add(game);
    }

    @Override
    public Game getOne(Long id) {
        Optional<Game> game = gameRepository.getOne(id);
        if (game.isEmpty()) {
            throw new UserNotFoundException("No game with id : " + id);
        }
        return game.get();
    }

    @Override
    public List<Game> getAll() {
        return gameRepository.getAll();
    }

    @Override
    public Game update(Game game) {
       return gameRepository.update(game);
    }

    @Override
    public Game delete(Long id) {
        return gameRepository.delete(id);
    }
}
