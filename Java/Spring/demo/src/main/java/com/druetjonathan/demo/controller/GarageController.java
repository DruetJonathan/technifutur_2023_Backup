package com.druetjonathan.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Pour dire que c'est un controller
@RestController
public class GarageController {

    // mappage de la route avec le path dans les ()
    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello world";
    }
}
