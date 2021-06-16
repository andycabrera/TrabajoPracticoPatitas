package Usuarios;

import Excepciones.EsContraseniaDebilException;

public class ValidarDebilidad implements Validacion{

	@Override
	public void validarContrasenia(String unaContrasenia) {
		if (LecturaClaves.instace().esContraseniaDebil(unaContrasenia)) {
			throw new EsContraseniaDebilException("La contrasenia ingresada es debil");
		}
	}

}
