package org.example.models;

import java.util.Date;

public class Bird extends Animal{

    public Bird(String birdy, Date date) {
        super(birdy,date);
    }

    @Override
    public void move() {
        System.out.println("I'm a bird and i fly");
    }
    public void shit(){
        System.out.println("Take that");
    }
}
