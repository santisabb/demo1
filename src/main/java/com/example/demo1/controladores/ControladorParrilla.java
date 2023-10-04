package com.example.demo1.controladores;


import com.example.demo1.entidades.Parrilla;
import com.example.demo1.repositorios.ParrillaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ControladorParrilla {
    private ParrillaRepository parrillaRepo;
    private final Logger log = LoggerFactory.getLogger(ControladorParrilla.class);
    public ControladorParrilla(ParrillaRepository parrillaRepo) {
        this.parrillaRepo = parrillaRepo;
    }

    @GetMapping("/api/parrillas")
    public List<Parrilla> buscarTodos(){
        return parrillaRepo.findAll();
    }

    @GetMapping("/api/parrillas/{id}")
    public ResponseEntity<Parrilla> findOne(@PathVariable Long id){
        Optional<Parrilla> opcParrilla = parrillaRepo.findById(id);

        return opcParrilla.map(ResponseEntity ::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/api/parrillas")
    public ResponseEntity<Parrilla> create(@RequestBody Parrilla parrilla, @RequestHeader HttpHeaders headers){
        Parrilla resultado = parrillaRepo.save(parrilla);
        return ResponseEntity.ok(resultado);
    }

    @PutMapping("/api/parrillas/{id}")
    public ResponseEntity<Parrilla> update(@PathVariable Long id, @RequestBody Parrilla parrilla){
        if (!parrillaRepo.existsById(parrilla.getIdParrilla())) {
            log.warn("intentando actualizar un parrilla inexistente");
            return ResponseEntity.badRequest().build();
        }
        Parrilla resultado = parrillaRepo.save(parrilla);
        return ResponseEntity.ok(resultado);
    }

    @DeleteMapping("/api/parrillas/{id}")
    public ResponseEntity<Parrilla> delete(@PathVariable Long id){
        Parrilla parrilla = parrillaRepo.findById(id)
              .orElseThrow(() -> new OpenApiResourceNotFoundException("Parrilla not found"));

        parrillaRepo.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
