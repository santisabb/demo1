package com.example.demo1.controladores;

import com.example.demo1.entidades.Factura;
import com.example.demo1.repositorios.FacturaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class ControladorFactura {
    private   FacturaRepository facturaRepo;

    private final Logger log = LoggerFactory.getLogger(ControladorFactura.class);

    public ControladorFactura(FacturaRepository facturaRepo) {
        this.facturaRepo = facturaRepo;
    }

    @GetMapping("/api/factura")
    public List<Factura> getAll() {
        return facturaRepo.findAll();
    }

    @PostMapping("/api/factura")
    public ResponseEntity<Factura>add(@RequestBody Factura factura, @RequestHeader HttpHeaders headers) {
        Factura result = facturaRepo.save(factura);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/api/factura/{nroFactura}")
    public ResponseEntity<Factura>findOne(@PathVariable Long nroFactura) {
        Optional<Factura> result = facturaRepo.findById(nroFactura);

        return result.map(ResponseEntity ::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/api/factura/{nroFactura}")
    public ResponseEntity<Factura>update(@PathVariable Long nroFactura, @RequestBody Factura factura) {
        if (factura.getNroFactura() == null) {
            log.warn("intentando actualizar una factura inexistente");
            return ResponseEntity.badRequest().build();
        }

        if(!facturaRepo.existsById(factura.getNroFactura())){
            log.warn("intentando actualizar una factura inexistente");
            return ResponseEntity.notFound().build();
        }

        Factura result = facturaRepo.save(factura);
        return ResponseEntity.ok(result);

    }

    @DeleteMapping("/api/factura/{nroFactura}")
    public ResponseEntity<Factura> delete(@PathVariable Long nroFactura) {
        Factura factura = facturaRepo.findById(nroFactura)
              .orElseThrow(() -> new OpenApiResourceNotFoundException("Resource not found"));

        facturaRepo.deleteById(nroFactura);

        return ResponseEntity.ok().build();
    }

}
