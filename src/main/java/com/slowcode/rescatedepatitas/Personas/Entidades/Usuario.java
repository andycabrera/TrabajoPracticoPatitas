package com.slowcode.rescatedepatitas.personas.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.slowcode.rescatedepatitas.personas.roles.Rol;
import com.slowcode.rescatedepatitas.personas.validaciones.repositories.RepositorioValidaciones;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {
    
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name= "USUARIO_ID", unique = true, nullable = false)
    private Long id;

    @Column(name="NOMBRE_USUARIO")
    private String nombreDeUsuario;

    @Column(name="CONTRASENIA")
    private String contrasenia;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "ID_ROL", referencedColumnName = "ID_ROL")
    private Rol rol;

    public Usuario(){}

    public Usuario(String nombreDeUsuario, String contrasenia, Rol rol) {
		this.nombreDeUsuario = nombreDeUsuario;
		this.contrasenia = validarContrasenia(contrasenia.trim());
        this.rol = rol;
	}

    public String validarContrasenia(String unaContrasenia) {
		RepositorioValidaciones.instance().validarContrasenia(unaContrasenia, this.nombreDeUsuario);
		return unaContrasenia;
	}

}
