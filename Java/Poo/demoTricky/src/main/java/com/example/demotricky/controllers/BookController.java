package com.example.demotricky.controllers;

import com.example.demotricky.annotations.Controller;
import com.example.demotricky.annotations.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;

@Controller(path="/book")

public class BookController {
    @GetMapping
    public Object getAll(){
        return new ArrayList<>(Arrays.asList("Toto","Philou"));
    }
}
