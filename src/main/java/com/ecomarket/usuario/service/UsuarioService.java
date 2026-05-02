package com.ecomarket.usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ecomarket.usuario.model.Usuario;
import com.ecomarket.usuario.repository.UsuarioRepository;

public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> readAll() {
        return usuarioRepository.readAll();
    }

    public Usuario readById(Integer id) {
        return usuarioRepository.readById(id).orElse(null);
    }

    public Usuario create(Usuario usuario) {
        return usuarioRepository.create(usuario);
    }

    public Usuario update(Usuario usuario, Integer id) {
        return usuarioRepository.update(usuario, id).orElse(null);
    }

    public Usuario deleteById(Integer id) {
        return usuarioRepository.deleteById(id).orElse(null);
    }

    public Usuario deleteByEmail(String email) {
        return usuarioRepository.deleteByEmail(email).orElse(null);
    }
}
