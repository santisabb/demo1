package com.example.demo1.controladores;


import com.example.demo1.entidades.Empleado;
import com.example.demo1.entidades.Usuario;
import com.example.demo1.repositorios.EmpleadoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ControladorEmpleado {
    private EmpleadoRepository empleadoRepo;
    private final Logger log = LoggerFactory.getLogger(ControladorEmpleado.class);
    public ControladorEmpleado(EmpleadoRepository empleadoRepo) {
        this.empleadoRepo = empleadoRepo;
    }

    @PostMapping("/api/empleados")
    public ResponseEntity<Empleado> crear (@RequestBody Empleado empleado , @RequestHeader HttpHeaders headers){
        if (empleado.getIdEmpleado() != null){
            log.warn("intentando crear usuario con ID existente");
            System.out.println("intentando crear usuario con ID existente");
            return ResponseEntity.badRequest().build();
        }
        Empleado result = empleadoRepo.save(empleado);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/api/empleados")
    public List<Empleado> buscarTodos() {return empleadoRepo.findAll();}

    @GetMapping("/api/empleados/{id}")
    public ResponseEntity<Empleado> buscarId(@PathVariable Long id){
        Optional<Empleado> opcEmpleado = empleadoRepo.findById(id);

        return opcEmpleado.map(ResponseEntity ::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/api/empleados/{id}")
    public ResponseEntity<Empleado> borrarEmplado(@PathVariable Long id){
        if(empleadoRepo.existsById(id)){
            return ResponseEntity.notFound().build();
        }

        empleadoRepo.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/api/empleados/{id}")
    public ResponseEntity<Empleado> modEmpleado(@RequestBody Empleado empleado){
        if(empleado.getIdEmpleado() == null){
            log.warn("intentando modificar un empleado inexistente");
            System.out.println("intentando modificar un empleado inexistente");
            return ResponseEntity.notFound().build();
        }

        if (!empleadoRepo.existsById(empleado.getIdEmpleado())) {
            log.warn("intentando actualizar un usuario inexistente");
            return ResponseEntity.badRequest().build();
        }
        Empleado resultado = empleadoRepo.save(empleado);
        return ResponseEntity.ok(resultado);
    }
}
