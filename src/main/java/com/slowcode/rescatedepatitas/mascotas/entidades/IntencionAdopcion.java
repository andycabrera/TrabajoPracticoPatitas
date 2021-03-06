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
@Table(name = "INTENCION_ADOPCION")
public class IntencionAdopcion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INTENCION_ID", unique = true, nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PERSONA_ID", nullable = false)
    private Persona persona;
    

    @OneToMany(mappedBy = "intencionAdopcion", cascade=CascadeType.ALL)
    private List<PreguntaRespuesta> listaPreguntaRespuesta;

    public IntencionAdopcion() {
    }

}