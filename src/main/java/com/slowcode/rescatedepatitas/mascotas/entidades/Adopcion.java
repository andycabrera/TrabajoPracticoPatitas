package com.slowcode.rescatedepatitas.mascotas.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.slowcode.rescatedepatitas.personas.entidades.Persona;

import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;

@Getter
@Setter
@Entity
@Table(name = "ADOPCION")
public class Adopcion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADOPCION_ID", unique = true, nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PERSONA_ID", nullable = false)
    @Getter(AccessLevel.NONE)
    private Persona persona;

    @OneToMany(mappedBy = "id")
    private List<PreguntaRespuesta> listaPreguntaRespuesta;

    @Column(name = "FOTO")
    private String foto;

    public Adopcion() {
    }

}
