package com.slowcode.rescatedepatitas.personas.validaciones;

import com.slowcode.rescatedepatitas.excepciones.EsContraseniaDebilException;

public class ValidarDebilidad implements Validacion{

	@Override
	public void validarContrasenia(String unaContrasenia) {
		if (LecturaClaves.instace().esContraseniaDebil(unaContrasenia)) {
			throw new EsContraseniaDebilException("La contrasenia ingresada es debil");
		}
	}

}
