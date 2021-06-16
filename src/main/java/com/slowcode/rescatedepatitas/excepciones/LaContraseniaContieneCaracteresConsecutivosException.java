package com.slowcode.rescatedepatitas.excepciones;

public class LaContraseniaContieneCaracteresConsecutivosException extends RuntimeException {
	public LaContraseniaContieneCaracteresConsecutivosException(String message) {
		super(message);
	}
}
