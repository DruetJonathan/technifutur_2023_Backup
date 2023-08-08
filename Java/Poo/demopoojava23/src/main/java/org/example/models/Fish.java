package org.example.models;

import java.util.Date;

public class Fish extends Animal{
    public Fish(String fishy, Date date) {
        super(fishy,date);
    }

    @Override
    public void move() {
        System.out.println("I'm a fish and i swim");
    }
    public void gloups(){
        System.out.println("gloups");
    }
}
