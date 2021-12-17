package com.slowcode.rescatedepatitas.mascotas.entidades.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestReportar {

    private Long idPersona;

    private String latitud;
    private String longitud;
    private String estadoMascotaEncontrada;
    private String estadoPublicacion;

    private String nombreMascota;
    private String descripcionFisica;
    private String foto;

}
