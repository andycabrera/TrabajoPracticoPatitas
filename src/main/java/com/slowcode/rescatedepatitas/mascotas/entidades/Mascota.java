package com.slowcode.rescatedepatitas.mascotas.entidades;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mascota {
    
    private String nombre;
    private String apodo;
    private String tipoAnimal;
    private Integer edad;
    private Sexo sexo;
    private String descripcion;
    private List<String> fotos;
    private List<String> caracteristicas;
}
