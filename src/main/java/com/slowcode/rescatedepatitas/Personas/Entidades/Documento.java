package com.slowcode.rescatedepatitas.personas.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "DOCUMENTO")
public class Documento implements Serializable {
    
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name= "DOCUMENTO_ID", unique = true, nullable = false)
    private Long id;
    
    @Column(name="DOCUMENTO_NRO")
    private String nroDocumento;

    @Column(name="DOCUMENTO_TIPO")
    private String tipoDocumento;

    public Documento(){}

    public Documento (String nroDocumento, String tipoDocumento){
        this.nroDocumento = nroDocumento;
        this.tipoDocumento = tipoDocumento;
    }
}
