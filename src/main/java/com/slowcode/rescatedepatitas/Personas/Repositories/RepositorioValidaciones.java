package com.slowcode.rescatedepatitas.Persona.Repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepositorioValidaciones {
	private List<Validacion> validaciones = new ArrayList<Validacion>();
	
	private static final RepositorioValidaciones INSTANCE = new RepositorioValidaciones();
	
	public static RepositorioValidaciones instance() {
		return INSTANCE;
	}
	
	public void validarContrasenia(String unaContrasenia, String nombreUsuario) {
		validaciones = Arrays.asList(
				new ValidarLargo(),
				new ValidarDebilidad(),
				new ValidarContenido(nombreUsuario),
				new ValidarCaracteresConsecutivos());
		validaciones.forEach(unaValidacion -> unaValidacion.validarContrasenia(unaContrasenia));
	}
}
