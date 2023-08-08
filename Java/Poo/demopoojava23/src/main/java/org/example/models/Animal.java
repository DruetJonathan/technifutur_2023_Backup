package org.example.models;


import java.util.Date;

public abstract class Animal {
    private String name;
    private Date birthdate;

    public Animal(String birdy, Date date) {
    }

    public abstract void move();
}
