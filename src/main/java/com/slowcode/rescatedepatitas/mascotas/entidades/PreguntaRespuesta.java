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

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.AccessLevel;
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "INTENCION_ID", nullable = true)
    @Getter(AccessLevel.NONE)
    @NotFound(action = NotFoundAction.IGNORE)
    private IntencionAdopcion intencionAdopcion;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ADOPCION_ID", nullable = true)
    @Getter(AccessLevel.NONE)
    @NotFound(action = NotFoundAction.IGNORE)
    private Adopcion adopcion;


    public PreguntaRespuesta() {
    }

    public PreguntaRespuesta(String pregunta, String respuesta) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }
}
