package com.ecomarket.usuario.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ecomarket.usuario.model.Rol;
import com.ecomarket.usuario.model.Usuario;

@Repository
public class UsuarioRepository {
    
    List<Usuario> usuarios = new ArrayList<>();

    public List<Usuario> readAll() {
        return usuarios;
    }

    public Optional<Usuario> readById(Integer id) {
        return usuarios.stream().filter(x -> x.getId().equals(id)).findFirst();
    }

    public Optional<Usuario> readByEmail(String email) {
        return usuarios.stream().filter(x -> x.getEmail().equals(email)).findFirst();
    }

    public Optional<Usuario> create(Usuario usuario) {
        usuarios.add(usuario);
        return Optional.of(usuario);
    }

    public Optional<Usuario> update(Usuario nUsuario, Integer id) {
        Optional<Usuario> usuarioOpt = readById(id);
        if(usuarioOpt.isEmpty()) {
            return Optional.empty();
        }
        usuarioOpt.get().setNombre(nUsuario.getNombre());
        usuarioOpt.get().setApellido(nUsuario.getApellido());
        usuarioOpt.get().setDireccion(nUsuario.getDireccion());
        usuarioOpt.get().setEmail(nUsuario.getEmail()); // fines de contacto
        // usuarioOpt.get().setPasswordNoHash(nUsuario.getPasswordNoHash()); // fines de autenticacion (en el microservicio login)
        return Optional.of(usuarioOpt.get());
    }

    public Optional<Usuario> updateRolById(Integer id, Rol nuevoRol) {
        Optional<Usuario> usuarioOpt = readById(id);
        if(usuarioOpt.isEmpty()) {
            return Optional.empty();
        }
        usuarioOpt.get().setRol(nuevoRol);
        return Optional.of(usuarioOpt.get());

    }

    public Optional<Usuario> deleteById(Integer id) {
        Optional<Usuario> usuarioOpt = readById(id);
        if(usuarioOpt.isEmpty()) {
            return Optional.empty() ;    
        }
       
        usuarios.removeIf(x-> x.getId().equals(usuarioOpt.get().getId()));
        return Optional.of(usuarioOpt.get());
    }

    public Optional<Usuario> deleteByEmail(String email) {
        Optional<Usuario> usuarioOpt = readByEmail(email);
        if(usuarioOpt.isEmpty()) {
            return Optional.empty() ;    
        }
        usuarios.removeIf(x-> x.getEmail().equals(usuarioOpt.get().getEmail()));
        return Optional.of(usuarioOpt.get());
    }
}
