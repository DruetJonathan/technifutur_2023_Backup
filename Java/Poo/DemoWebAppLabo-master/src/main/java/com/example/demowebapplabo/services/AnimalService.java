package com.example.demowebapplabo.services;

import com.example.demowebapplabo.models.entities.Animal;
import com.example.demowebapplabo.models.forms.AnimalForm;

import java.util.List;

public interface AnimalService {

    Animal add(AnimalForm a);

    Animal getOne(Long id);

    List<Animal> getAll();

    Animal update(Long id, AnimalForm a);

    Animal delete(Long id);
}
