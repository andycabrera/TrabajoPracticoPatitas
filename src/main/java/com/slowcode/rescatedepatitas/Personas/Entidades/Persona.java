package com.slowcode.rescatedepatitas.personas.entidades;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.slowcode.rescatedepatitas.mascotas.entidades.Mascota;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Persona implements Serializable {

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name= "PERSONA_ID", unique = true, nullable = false)
    private Long id;
    
    @Column(name="NOMBRE_COMPLETO")
    private String nombreCompleto;
    
    @Column(name="DIRECCION")
    private String direccion;

    @Column(name="FECHA_NAC")
    private Date fechaNacimiento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="DOCUMENTO_ID")
    private Documento documento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="CONTACTO_ID")
    private Contacto contacto;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="USUARIO_ID" , referencedColumnName = "USUARIO_ID")
    private Usuario usuario;

    @OneToMany(mappedBy = "persona", cascade=CascadeType.ALL)
    private List<Mascota> mascota;

    

    public Persona(){}

    public Persona(
            String nombreCompleto, 
            String direccion,
            Date fechaNacimiento,
            Documento documento,
            Contacto contacto
        ){
            this.nombreCompleto = nombreCompleto;
            this.fechaNacimiento = fechaNacimiento;
            this.direccion = direccion;
            this.documento = documento;
            this.contacto = contacto;        
    }

}
