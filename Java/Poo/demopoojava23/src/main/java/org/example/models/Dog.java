package org.example.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


public class Dog extends Animal {

    public Dog(String doggo, Date date) {
        super(doggo,date);
    }

    @Override
    public void move() {
        System.out.println("I'm a dog and i run");
    }
    public void bark(){
        System.out.println("Wouf");
    }
}
