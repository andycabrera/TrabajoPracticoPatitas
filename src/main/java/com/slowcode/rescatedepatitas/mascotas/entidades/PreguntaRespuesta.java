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
@Table(name = "PREGUNTA_RESPUESTA")
public class PreguntaRespuesta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PREGUNTARESPUESTA_ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "PREGUNTA")
    private String pregunta;

    @Column(name = "RESPUESTA")
    private String respuesta;

    public PreguntaRespuesta() {
    }

    public PreguntaRespuesta(String pregunta, String respuesta) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }
}
