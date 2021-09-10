package com.slowcode.rescatedepatitas.personas.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CONTACTO")
public class Contacto implements Serializable {

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name= "CONTACTO_ID", unique = true, nullable = false)
    private Long id;

    @Column(name="NOMBRE_COMPLETO")
    private String nombreCompleto;

    @Column(name="TELEFONO")
    private String telefono;

    @Column(name="EMAIL")
    private String email;

    @OneToMany(mappedBy="contacto")
    private List<MedioComunicacion> mediosDeComunicacion;

    public Contacto(){}

    public Contacto(String nombreCompleto, String telefono, String email){
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.email = email;
    }

}
