package com.babiarzdruet.labojavadataweb.services.impl;

import com.babiarzdruet.labojavadataweb.exceptions.LoginException;
import com.babiarzdruet.labojavadataweb.exceptions.PasswordException;
import com.babiarzdruet.labojavadataweb.exceptions.UserNotFoundException;
import com.babiarzdruet.labojavadataweb.models.entities.Role;
import com.babiarzdruet.labojavadataweb.models.entities.User;
import com.babiarzdruet.labojavadataweb.repositories.UserRepository;
import com.babiarzdruet.labojavadataweb.repositories.impl.RequestCoachingRepositoryImpl;
import com.babiarzdruet.labojavadataweb.repositories.impl.UserRepositoryImpl;
import com.babiarzdruet.labojavadataweb.services.UserService;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.NoResultException;
import org.mindrot.jbcrypt.BCrypt;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Named
@SessionScoped
public class UserServiceImpl implements UserService, Serializable {
    @Inject
    UserRepositoryImpl userRepository;
    public UserServiceImpl() {
        this.userRepository = new UserRepositoryImpl();
    }
    @Override
    public User add(User user) {
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        user.addRole(new Role(1L,"User"));


        return this.userRepository.add(user);
    }

    @Override
    public User getOne(Long id) {
        Optional<User> user = userRepository.getOne(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("No user with id : " + id);
        }
        return user.get();
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public User update(User user) {
        return userRepository.update(user);
    }

    @Override
    public User delete(Long id) {
        return userRepository.delete(id);
    }

    public User login(String email, String password) {
        try {
            User login = userRepository.login(email);
            if (login == null) {
                throw new LoginException();
            }
            if (!BCrypt.checkpw(password, login.getPassword())) {
                throw new PasswordException();
            }
            return login;
        }catch (NoResultException e){
            throw new LoginException();
        }

    }
}
