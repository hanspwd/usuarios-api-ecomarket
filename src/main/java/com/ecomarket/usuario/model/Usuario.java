package com.ecomarket.usuario.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    private Integer id;

    @NotEmpty(message = "El nombre no puede estar vacío")
    @NotNull(message = "El nombre no puede ser nulo")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String nombre;

    @NotEmpty(message = "El apellido no puede estar vacío")
    @NotNull(message = "El apellido no puede ser nulo")
    @Size(min = 3, max = 50, message = "El apellido debe tener entre 3 y 50 caracteres")
    private String apellido;

    @NotEmpty(message = "El direccion no puede estar vacía")
    @NotNull(message = "El direccion no puede ser nulo")
    @Size(min = 3, max = 100, message = "El direccion debe tener entre 3 y 100 caracteres")
    private String direccion;

    @Email(message = "El email debe ser válido")
    @NotEmpty(message = "El email no puede estar vacío")
    @NotNull(message = "El email no puede ser nulo")
    private String email;

    @NotNull(message = "El rol no puede ser nulo")
    private Rol rol;

}
