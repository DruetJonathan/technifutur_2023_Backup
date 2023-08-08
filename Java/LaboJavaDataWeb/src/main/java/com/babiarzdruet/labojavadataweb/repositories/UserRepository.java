package com.babiarzdruet.labojavadataweb.repositories;

import com.babiarzdruet.labojavadataweb.models.entities.User;


public interface UserRepository extends BaseRepository<Long,User>{
    User login(String email);
}
