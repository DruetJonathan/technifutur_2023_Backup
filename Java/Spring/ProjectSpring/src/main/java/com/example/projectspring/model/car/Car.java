package com.example.projectspring.model.car;


import jakarta.persistence.*;

@Entity

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Color color;
    private String model;

    // One to many
    // eager a chaque fois je recup
    // lazy seulement si je demande


    public Car(Color color, String model, Brand brand, int year) {
        this.color = color;
        this.model = model;
        this.brand = brand;
        this.year = year;
    }

    @ManyToOne
    private Brand brand;
    private int year;

    public Car() {

    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
