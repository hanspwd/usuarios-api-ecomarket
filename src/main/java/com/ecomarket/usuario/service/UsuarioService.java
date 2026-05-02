package com.ecomarket.usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomarket.usuario.model.Rol;
import com.ecomarket.usuario.model.Usuario;
import com.ecomarket.usuario.repository.UsuarioRepository;

/*
Repository: Devuelve Optional<Entidad>.

Service: Abre el Optional (lo desempaqueta del Optional). Si existe, lo transforma a DTO y lo retorna. Si no existe, lanza una excepción personalizada.

Controller: Llama al Service. Si recibe el DTO, devuelve 200 OK.

RestControllerAdvice: Si el Service lanzó la excepción, la intercepta y devuelve un 404 Not Found con un mensaje JSON estructurado y seguro.
*/

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> readAll() {
        return usuarioRepository.readAll();
    }

    public Usuario readById(Integer id) {
        return usuarioRepository.readById(id).orElse(null);
    }

        public Usuario readByEmail(String email) {
        return usuarioRepository.readByEmail(email).orElse(null);
    }

    public Usuario create(Usuario usuario) {
        return usuarioRepository.create(usuario);
    }

    public Usuario update(Usuario usuario, Integer id) {
        return usuarioRepository.update(usuario, id).orElse(null);
    }

    public Usuario updateRolById(Integer id, Rol nuevoRol) {
        return usuarioRepository.updateRolById(id, nuevoRol).orElse(null);
    }

    public Usuario deleteById(Integer id) {
        return usuarioRepository.deleteById(id).orElse(null);
    }

    public Usuario deleteByEmail(String email) {
        return usuarioRepository.deleteByEmail(email).orElse(null);
    }
}
