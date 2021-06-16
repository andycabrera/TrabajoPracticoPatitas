package com.slowcode.rescatedepatitas.personas.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.slowcode.rescatedepatitas.personas.validaciones.repositories.RepositorioValidaciones;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Usuario implements Serializable {
    
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name="NOMBRE_USUARIO")
    private String nombreDeUsuario;

    @Column(name="CONTRASENIA")
    private String contrasenia;

    @Column(name="ES_ADMIN")
    private Boolean esAdmin;

    @OneToOne()
    @Column(name="PERSONA")
    private Persona persona;

    public Usuario(String nombreDeUsuario, String contrasenia, Boolean esAdmin, Persona persona) {
		this.nombreDeUsuario = nombreDeUsuario;
		this.contrasenia = validarContrasenia(contrasenia.trim());
        this.esAdmin = esAdmin;
        this.persona = persona;
	}

    public String validarContrasenia(String unaContrasenia) {
		RepositorioValidaciones.instance().validarContrasenia(unaContrasenia, this.nombreDeUsuario);
		return unaContrasenia;
	}

}
