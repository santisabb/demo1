package com.example.demo1.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorUsuario {
    @GetMapping("prueba")
    public String prueba(){
        return "Esto es una prueba, gato. Nos vimooooo";
    }
}
