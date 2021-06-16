package com.slowcode.rescatedepatitas.personas.validaciones;

import com.slowcode.rescatedepatitas.excepciones.LaContraseniaContieneCaracteresConsecutivosException;

public class ValidarCaracteresConsecutivos implements Validacion {

	@Override
	public void validarContrasenia(String unaContrasenia) {
		if(contieneCaracteresConsecutivos(unaContrasenia)) {
			throw new LaContraseniaContieneCaracteresConsecutivosException("La contrasenia no puede contener caracteres consecutivos");
		}
	}
	

	public boolean contieneCaracteresConsecutivos(String unaContrasenia) {
		for(int i=1; i<unaContrasenia.length();i++) {
			if(unaContrasenia.charAt(i-1)==(unaContrasenia.charAt(i)-1)) {
				return true;
			}
		}
		return false;
	}

}
