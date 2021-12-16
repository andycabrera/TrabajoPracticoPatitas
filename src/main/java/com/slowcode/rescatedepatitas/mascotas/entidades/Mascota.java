package com.slowcode.rescatedepatitas.mascotas.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.slowcode.rescatedepatitas.personas.entidades.Persona;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "MASCOTA")
public class Mascota implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MASCOTA_ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "APODO")
    private String apodo;

    @Column(name = "EDAD")
    private Integer edad;

    @Column(name = "SEXO")
    private String sexo;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "CLASE_ANIMAL")
    private String claseAnimal;

    @Column(name = "FOTO")
    private String foto;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PERSONA_ID", nullable = false)
    @Getter(AccessLevel.NONE)
    private Persona persona;

    @OneToMany(mappedBy = "id")
    private List<Caracteristica> caracteristicas;

    public Mascota() {
    }

    public Mascota(String nombre, String apodo, Integer edad, String sexo, String descripcion, String estado,
            String claseAnimal, String foto, Persona persona, List<Caracteristica> caracteristicas) {
        this.nombre = nombre;
        this.apodo = apodo;
        this.edad = edad;
        this.sexo = sexo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.claseAnimal = claseAnimal;
        this.foto = foto;
        this.persona = persona;
        this.caracteristicas = caracteristicas;
    }
}
