package com.slowcode.rescatedepatitas.mascotas.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.slowcode.rescatedepatitas.personas.entidades.Persona;

import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;

@Getter
@Setter
@Entity
@Table(name = "PUBLICACION")
public class Publicacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PUBLICACION_ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "ESTADO_MASCOTA_ENCONTRADA")
    private String estadoMascotaEncontrada;

    @Column(name = "LATITUD")
    private String latitud;

    @Column(name = "LONGITUD")
    private String longitud;

    @Column(name = "ESTADO_PUBLICACION")
    private String estadoPublicacion;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PERSONA_ID", nullable = false)
    @Getter(AccessLevel.NONE)
    private Persona persona;

    @Column(name = "NOMBRE_MASCOTA")
    private String nombreMascota;

    @Column(name = "DESCRIPCION_FISICA")
    private String descripcionFisica;

    @Column(name = "FOTO")
    private String foto;

    public Publicacion() {
    }

    public Publicacion(String estadoMascotaEncontrada, String latitud, String longitud, String estadoPublicacion,
            Persona persona, String nombreMascota, String descripcionFisica, String foto) {

        this.estadoMascotaEncontrada = estadoMascotaEncontrada;
        this.latitud = latitud;
        this.longitud = longitud;
        this.estadoPublicacion = estadoPublicacion;
        this.persona = persona;
        this.nombreMascota = nombreMascota;
        this.descripcionFisica = descripcionFisica;
        this.foto = foto;

    }
}
