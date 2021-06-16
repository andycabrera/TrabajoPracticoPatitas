package Usuarios;

import Excepciones.LaContraseniaNoPuedeContenerElNombreDeUsuarioException;

public class ValidarContenido implements Validacion{
	String nombreUsuario;
	
	public ValidarContenido(String nombreUsuario) {
		this.nombreUsuario=nombreUsuario;
	}

	@Override
	public void validarContrasenia(String unaContrasenia) {
		if(unaContrasenia.contains(nombreUsuario)) {
			throw new LaContraseniaNoPuedeContenerElNombreDeUsuarioException("La contrasenia no puede contener el nombre de usuario");
		}
		
	}

}
