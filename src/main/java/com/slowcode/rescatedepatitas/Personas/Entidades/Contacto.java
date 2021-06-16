package com.slowcode.rescatedepatitas.Personas.Entidades;

import java.util.List;

import com.slowcode.rescatedepatitas.Utils.Notificacion.FormaNotificacion;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Contacto {

    private String id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private List<FormaNotificacion> formasDeNotificacion;

    public Contacto(String nombre, String apellido, String telefono, String email, List<FormaNotificacion> formasDeNotificacion){
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.formasDeNotificacion = formasDeNotificacion;
    }

}
