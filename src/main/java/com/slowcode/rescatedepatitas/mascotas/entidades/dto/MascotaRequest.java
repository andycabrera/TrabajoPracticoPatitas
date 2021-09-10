package com.slowcode.rescatedepatitas.mascotas.entidades.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MascotaRequest {
    
    private String nombre;
    private String apodo;
    private Integer edad;
    private String sexo;
    private String descripcion;
    private String estado;
    private String claseAnimal;
    private String foto;
    private Long personaId;
}
