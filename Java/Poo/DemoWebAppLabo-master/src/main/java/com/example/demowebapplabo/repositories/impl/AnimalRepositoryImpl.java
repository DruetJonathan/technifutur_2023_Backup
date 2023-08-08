package com.example.demowebapplabo.repositories.impl;

import com.example.demowebapplabo.models.entities.Animal;
import com.example.demowebapplabo.repositories.AnimalRepository;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@SessionScoped
public class AnimalRepositoryImpl extends BaseRepositoryImpl<Long, Animal> implements AnimalRepository, Serializable {
}
