package com.ecomarket.usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomarket.usuario.model.Usuario;
import com.ecomarket.usuario.service.UsuarioService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


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
    
}
