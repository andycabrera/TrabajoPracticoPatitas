package com.slowcode.rescatedepatitas.mascotas.entidades.dto;

import java.sql.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaRequest {

    private String nombreCompleto;
    private String direccion;
    private Date fechaNacimiento;
    private String nroDocumento;
    private String tipoDocumento;

    private String contactoNombreCompleto;
    private String telefono;
    private String email;

    private List<MedioDeComunicacion> medios;

    private Long usuarioId;

}
