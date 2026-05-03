package com.ecomarket.usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomarket.usuario.model.Rol;
import com.ecomarket.usuario.model.Usuario;
import com.ecomarket.usuario.service.UsuarioService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<?> getAllUsuarios() {
        List<Usuario> usuarios = usuarioService.readAll();
        
        if(!usuarios.isEmpty()) {
            return ResponseEntity.ok(usuarios);
        }

        return ResponseEntity.status(404).body("Recursos no encontrados");
    }

    @GetMapping("id/{id}")
    public ResponseEntity<?> getUsuarioById(@Valid @PathVariable Integer id) {

        Usuario usuario = usuarioService.readById(id);

        if(usuario != null) {
            return ResponseEntity.ok(usuario);
        }

        return ResponseEntity.status(404).body("Recurso no encontrado");
    }

    @GetMapping("email/{email}")
    public ResponseEntity<?> getUsuarioByEmail(@Valid @PathVariable String email) {
        
        Usuario usuario = usuarioService.readByEmail(email);

        if(usuario != null) {
            return ResponseEntity.ok(usuario);
        }

        return ResponseEntity.status(404).body("Recurso no encontrado");
    }

    @PostMapping
    public ResponseEntity<?> createUsuario(@Valid @RequestBody Usuario usuario) {
             Usuario existUsuario = usuarioService.readByEmail(usuario.getEmail());

            if(existUsuario == null) {
                Usuario entity = usuarioService.create(usuario);
                return ResponseEntity.ok(entity);
            } else {
                return ResponseEntity.status(400).body("Ya existe un usuario con el email: " + usuario.getEmail());
            }            
    }

    @PutMapping("id/{id}")
    public ResponseEntity<?> putUsuarioById(@PathVariable Integer id, @RequestBody Usuario nuevoUsuario) {
        Usuario oldUsuario = usuarioService.readById(id);
        if(oldUsuario != null) {
            oldUsuario.setNombre(nuevoUsuario.getNombre());
            oldUsuario.setApellido(nuevoUsuario.getApellido());
            oldUsuario.setDireccion(nuevoUsuario.getDireccion());
            oldUsuario.setEmail(nuevoUsuario.getEmail());
            
            oldUsuario = usuarioService.update(oldUsuario, id);
            return ResponseEntity.ok(oldUsuario);
            
        }
        return ResponseEntity.status(404).body("Recurso no encontrado");
    }

    @PutMapping("rol/{id}")
    public ResponseEntity<?> putUsuarioRolById(@PathVariable Integer id, @RequestBody Rol nuevoRol) {
        Usuario oldUsuario = usuarioService.readById(id);
        if(oldUsuario != null) {
            oldUsuario.setRol(nuevoRol);
            oldUsuario = usuarioService.updateRolById(nuevoRol, id);
            return ResponseEntity.ok(oldUsuario);
        }

        return ResponseEntity.status(404).body("Recurso no encontrado");
    }
}
