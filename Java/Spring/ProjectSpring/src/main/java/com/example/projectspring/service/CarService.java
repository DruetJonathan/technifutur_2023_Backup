package com.example.projectspring.service;


import com.example.projectspring.model.car.Car;
import org.springframework.stereotype.Service;

@Service
public interface CarService {
    Iterable<Car> getAll();
    Car getById(Long id);
    Car add(Car car);

}
