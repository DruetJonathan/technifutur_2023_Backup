package com.example.projectspring.service;

import com.example.projectspring.model.car.Car;
import com.example.projectspring.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public Car getById(Long id) {
        return carRepository.findById(id).get();
    }

    @Override
    public Car add(Car car) {
        return carRepository.save(car);
    }
}
