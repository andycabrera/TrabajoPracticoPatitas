package com.slowcode.rescatedepatitas.mascotas.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CARACTERISTICA")
public class Caracteristica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CARACTERISTICA_ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "VALOR")
    private String valor;

    public Caracteristica() {
    }

    public Caracteristica(String nombre, String valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

}
