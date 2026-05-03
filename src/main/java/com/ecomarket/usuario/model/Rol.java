package com.ecomarket.usuario.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Rol {
    
    ADMIN, USUARIO, EMPLEADO;

    @JsonCreator
    public static Rol fromString(String value) {
        for (Rol rol : Rol.values()) {
            if (rol.name().equalsIgnoreCase(value)) {
                return rol;
            }
        }
        throw new IllegalArgumentException("Valor de rol no válido: " + value);
    }
}
