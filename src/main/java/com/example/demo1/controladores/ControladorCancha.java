package com.example.demo1.controladores;


import com.example.demo1.entidades.Cancha;
import com.example.demo1.repositorios.CanchaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ControladorCancha {
    private CanchaRepository canchaRepo;
    private final Logger log = LoggerFactory.getLogger(ControladorCancha.class);

    public ControladorCancha(CanchaRepository canchaRepo) {
        this.canchaRepo = canchaRepo;
    }

    @GetMapping("/api/canchas")
    public List<Cancha> buscarTodos(){
        return canchaRepo.findAll();
    }

    @GetMapping("/api/canchas/{id}")
    public ResponseEntity<Cancha>findOne(@PathVariable int id){
        Optional<Cancha> opcCancha = canchaRepo.findById(id);

        return opcCancha.map(ResponseEntity ::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/api/canchas")
    public ResponseEntity<Cancha>create(@RequestBody Cancha cancha, @RequestHeader HttpHeaders headers){
        Cancha resultado = canchaRepo.save(cancha);
        return ResponseEntity.ok(resultado);
    }

    @PatchMapping("/api/canchas/{id}")
    public ResponseEntity<Cancha> update(@PathVariable int id, @RequestBody Cancha cancha){
        if (!canchaRepo.existsById(id)){
            log.warn("intentando actualizar una cancha inexistente");
            return ResponseEntity.badRequest().build();
        }

        Cancha resultado = canchaRepo.save(cancha);
        return ResponseEntity.ok(resultado);
    }

    @DeleteMapping("/api/canchas/{id}")
    public ResponseEntity<Cancha> delete(@PathVariable int id){
        Cancha cancha = canchaRepo.findById(id)
              .orElseThrow(() -> new OpenApiResourceNotFoundException("Cancha not found"));

        canchaRepo.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
