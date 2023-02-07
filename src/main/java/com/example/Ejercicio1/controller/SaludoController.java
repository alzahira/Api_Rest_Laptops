package com.example.Ejercicio1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {


    @Value("${app.message}")
    String message;

    @GetMapping("/saludo")

    public String holaMundo() {
        System.out.println(message);
        return "Hola, que tal estás ";
    }
}




