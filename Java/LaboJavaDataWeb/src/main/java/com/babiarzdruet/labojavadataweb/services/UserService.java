package com.babiarzdruet.labojavadataweb.services;


import com.babiarzdruet.labojavadataweb.models.entities.User;

import java.util.List;

public interface UserService {
    User add(User user);
    User getOne(Long id);
    List<User> getAll();
    User update(User user);
    User delete(Long id);

    User login(String email, String password);
}
