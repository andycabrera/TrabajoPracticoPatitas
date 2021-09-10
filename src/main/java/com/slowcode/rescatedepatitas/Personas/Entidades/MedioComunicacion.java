package com.slowcode.rescatedepatitas.personas.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "MEDIO_COMUNICACION")
public class MedioComunicacion implements Serializable{

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name= "MEDIO_COMUNICACION_ID", unique = true, nullable = false)
    private Long id;

    @Column(name="TIPO_DE_MEDIO")
    private String tipoDeMedio;

    @Column(name="MEDIO_PREFERIDO")
    private Boolean medioPreferido;

    @ManyToOne
    @JoinColumn(name="CONTACTO_ID", nullable=false)
    private Contacto contacto;

    public MedioComunicacion (String tipoDeMedio, Boolean medioPreferido, Contacto contacto){
        this.tipoDeMedio = tipoDeMedio;
        this.medioPreferido = medioPreferido;
        this.contacto = contacto;
    }
    
}
