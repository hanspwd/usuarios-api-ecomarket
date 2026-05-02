package com.ecomarket.usuario.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ecomarket.usuario.model.Usuario;

public class UsuarioRepository {
    
    List<Usuario> usuarios = new ArrayList<>();

    public List<Usuario> readAll() {
        return usuarios;
    }

    public Optional<Usuario> readById(Integer id) {
        return usuarios.stream().filter(x -> x.getId().equals(id)).findFirst();
    }

    public Usuario create(Usuario usuario) {
        usuarios.add(usuario);
        return usuario;
    }

    public Optional<Usuario> update(Usuario nUsuario, Integer id) {

        Optional<Usuario> usuarioAntiguo = readById(id);

        if(usuarioAntiguo.isEmpty()) {
            return Optional.empty();
        }

        usuarioAntiguo.get().setNombre(nUsuario.getNombre());
        usuarioAntiguo.get().setApellido(nUsuario.getApellido());
        usuarioAntiguo.get().setDireccion(nUsuario.getDireccion());
        usuarioAntiguo.get().setEmail(nUsuario.getEmail()); // fines de contacto
        // usuarioAntiguo.get().setPasswordNoHash(nUsuario.getPasswordNoHash()); // fines de autenticacion (en el microservicio login)
        return Optional.of(usuarioAntiguo.get());
    }

    public Usuario delete(Integer id) {
        return null;
    }

}
