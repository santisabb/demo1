package com.example.demo1.controladores;

import com.example.demo1.entidades.Usuario;
import com.example.demo1.repositorios.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ControladorUsuario {
    private UsuarioRepository usuarioRepo;
    private final Logger log = LoggerFactory.getLogger(ControladorUsuario.class);

    public ControladorUsuario(UsuarioRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    @GetMapping("/api/usuarios")
    public List<Usuario> buscarTodos(){
        return usuarioRepo.findAll();
    }

    @GetMapping("/api/usuarios/{dni}")
    public ResponseEntity<Usuario>buscarDni(@PathVariable Long dni){
        Optional<Usuario> opcUsuario = usuarioRepo.findById(dni);

        return opcUsuario.map(ResponseEntity ::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/api/usuarios")
    public ResponseEntity<Usuario> crear(@RequestBody Usuario usuario, @RequestHeader HttpHeaders headers) {
        Usuario resultado = usuarioRepo.save(usuario);
        return ResponseEntity.ok(resultado);
    }

    @PutMapping("/api/usuarios/{dni}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long dni, @RequestBody Usuario usuario) {
        if (usuario.getNroDni() == null) {
            log.warn("intentando actualizar un usuario inexistente");
            return ResponseEntity.badRequest().build();
        }

        if (!usuarioRepo.existsById(usuario.getNroDni())) {
            log.warn("intentando actualizar un usuario inexistente");
            return ResponseEntity.badRequest().build();
        }
        Usuario resultado = usuarioRepo.save(usuario);
        return ResponseEntity.ok(resultado);
    }

    @DeleteMapping("/api/usuarios/{dni}")
    public ResponseEntity<Usuario> borrarUsuario (@PathVariable Long dni){
        Usuario usuario = usuarioRepo.findById(dni)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("User not found"));

        usuarioRepo.deleteById(dni);

        return ResponseEntity.noContent().build();
    }

}
