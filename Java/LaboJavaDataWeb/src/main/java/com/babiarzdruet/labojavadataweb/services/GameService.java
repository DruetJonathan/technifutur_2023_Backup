package com.babiarzdruet.labojavadataweb.services;

import com.babiarzdruet.labojavadataweb.models.entities.Game;
import com.babiarzdruet.labojavadataweb.models.entities.User;

import java.util.List;

public interface GameService {

    Game add(Game game);
    Game getOne(Long id);
    List<Game> getAll();
    Game update(Game game);
    Game delete(Long id);
}
