package com.example.projectspring.controller;

import com.example.projectspring.model.car.Car;
import com.example.projectspring.service.CarServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    CarServiceImpl carService;


    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<List<Car>> getCars(){
        return ResponseEntity.ok(carService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Car> getCars(@PathVariable Long id){
        return ResponseEntity.ok(carService.getById(id));
    }
    @PostMapping
    public ResponseEntity<Car> addCar(@RequestBody Car car){
        return ResponseEntity.ok(carService.add(car));
    }


}
