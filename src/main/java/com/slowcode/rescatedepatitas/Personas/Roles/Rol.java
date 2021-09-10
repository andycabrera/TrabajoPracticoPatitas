package com.slowcode.rescatedepatitas.personas.roles;


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
@Table(name = "ROL")
public class Rol implements Serializable{
    
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name= "ID_ROL", unique = true, nullable = false)
    private Long id;

    @Column(name="ROL_DESCRIPCION")
    private String rolDescripcion;

    public Rol (String rolDescripcion){
        this.rolDescripcion = rolDescripcion;
    }
}
