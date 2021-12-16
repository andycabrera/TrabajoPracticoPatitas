package com.slowcode.rescatedepatitas.mascotas.entidades.dto;

import java.util.List;

import com.slowcode.rescatedepatitas.mascotas.entidades.Caracteristica;

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
    private List<Caracteristica> caracteristicas;
}
