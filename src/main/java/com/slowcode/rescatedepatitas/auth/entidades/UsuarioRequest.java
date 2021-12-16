package com.slowcode.rescatedepatitas.auth.entidades;

import com.slowcode.rescatedepatitas.personas.roles.Rol;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioRequest {

    private String nombreDeUsuario;
    private String contrasenia;
    private String rol;

}
