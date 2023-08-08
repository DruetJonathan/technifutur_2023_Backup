package com.example.demotricky.controllers;

import com.example.demotricky.annotations.Controller;
import com.example.demotricky.annotations.GetMapping;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

@Controller(path="/home")
public class HomeController {
//    public HomeController(HomeService homeService) {
//    }

    @GetMapping
    public Object getAll(){
        return new ArrayList<>(Arrays.asList("Toto","Philou"));
    }
}
