package com.slowcode.rescatedepatitas.mascotas.entidades.dto;

import java.sql.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestReportar {

    private String nombreCompleto;
    private String direccion;
    private Date fechaNacimiento;
    private String nroDocumento;
    private String tipoDocumento;
    private String mail;
    private String telefono;

    private String idPersona;

    private String latitud;
    private String longitud;

    private String nombreMascota;
    private String descripcionFisica;
    private List<String> fotos;

}
