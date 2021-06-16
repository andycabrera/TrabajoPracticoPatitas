package com.slowcode.rescatedepatitas.personas.entidades;

import java.sql.Date;
import java.util.List;

import com.slowcode.rescatedepatitas.mascotas.entidades.Mascota;
import com.slowcode.rescatedepatitas.personas.roles.Rol;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Persona {
    
    private String nombreCompleto;
    private Date fechaNacimiento;
    private String tipoDocumento;
    private String nroDocumento;
    private List<Contacto> contactos;
    private List<Mascota> mascotas;
    private Rol rol;

    public Persona(
            String nombreCompleto, 
            Date fechaNacimiento, 
            String tipoDocumento, 
            List<Contacto> contactos,
            Rol rol
        ){
            this.nombreCompleto = nombreCompleto;
            this.fechaNacimiento = fechaNacimiento;
            this.tipoDocumento = tipoDocumento;
            this.contactos = contactos;
            this.rol = rol;        
    }

}
