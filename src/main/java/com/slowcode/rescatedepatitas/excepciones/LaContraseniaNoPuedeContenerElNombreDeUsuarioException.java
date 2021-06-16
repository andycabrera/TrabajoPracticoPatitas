package com.slowcode.rescatedepatitas.excepciones;


public class LaContraseniaNoPuedeContenerElNombreDeUsuarioException extends RuntimeException{
	
	public LaContraseniaNoPuedeContenerElNombreDeUsuarioException(String message) {
		super(message);
	}
}
