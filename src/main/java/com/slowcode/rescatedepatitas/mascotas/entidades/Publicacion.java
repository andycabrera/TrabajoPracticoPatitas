package com.slowcode.rescatedepatitas.mascotas.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.slowcode.rescatedepatitas.personas.entidades.Persona;

import lombok.Getter;
import lombok.Setter;

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

    @Column(name = "PERSONA_ID")
    private Persona persona;

    @Column(name = "MASCOTA_ID")
    private Mascota mascota;

    @Column(name = "FOTO")
    private String foto;

    public Publicacion() {
    }

    public Publicacion(String estadoMascotaEncontrada, String latitud, String longitud, String estadoPublicacion,
            Persona persona, Mascota mascota, String foto) {

        this.estadoMascotaEncontrada = estadoMascotaEncontrada;
        this.latitud = latitud;
        this.longitud = longitud;
        this.estadoPublicacion = estadoPublicacion;
        this.persona = persona;
        this.mascota = mascota;
        this.foto = foto;

    }
}
