package com.slowcode.rescatedepatitas.auth.entidades;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioRequestLogin {
    
    private String nombreDeUsuario;
    private String contrasenia;
    
}