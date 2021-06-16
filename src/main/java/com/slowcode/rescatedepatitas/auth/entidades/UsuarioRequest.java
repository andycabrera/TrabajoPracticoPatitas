package com.slowcode.rescatedepatitas.auth.entidades;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioRequest {
    
    private String nombreDeUsuario;
    private String contrasenia;
    private Boolean esAdmin;
    
}
