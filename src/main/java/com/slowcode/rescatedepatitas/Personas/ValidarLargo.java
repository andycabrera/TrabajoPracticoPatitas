package Usuarios;

import Excepciones.EsContraseniaMuyCortaException;

public class ValidarLargo implements Validacion {

	@Override
	public void validarContrasenia(String unaContrasenia) {
		if(unaContrasenia.length()<8) {
			throw new EsContraseniaMuyCortaException("La contrasenia ingresada debe tener como minimo 8 caracteres");
		}
	}

}
