package com.example.demo1.controladores;

import com.example.demo1.entidades.Usuario;
import com.example.demo1.repositorios.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ControladorUsuario {
    private UsuarioRepository usuarioRepo;

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
    public Usuario crear(@RequestBody Usuario usuario) {
        return usuarioRepo.save(usuario);
    }


}
