package com.slowcode.rescatedepatitas.personas.validaciones;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.slowcode.rescatedepatitas.excepciones.ArchivoNoEncontradoException;


public class LecturaClaves {
	
	private static final LecturaClaves INSTANCE = new LecturaClaves();
	private List<String> listaDeClavesProhibidas = new ArrayList<>();
	
	private LecturaClaves() {
		this.listaDeClavesProhibidas = extraerContraseniasDebiles();
	}
	
	public static LecturaClaves instace() {
		return INSTANCE;
	}
	
	
	public static List<String> extraerContraseniasDebiles() {
		List<String> lista = new ArrayList<>();
		File fichero = new File("Contrasenias.txt");
		Scanner s = null;

		try {
			s = new Scanner(fichero);

			// Leemos linea a linea el fichero
			while (s.hasNextLine()) {
				String linea = s.nextLine(); 	// Guardamos la linea en un String
				lista.add(linea.trim());
				//System.out.println(linea.trim());      // Imprimimos la linea
			}

		} catch (Exception ex) {
			throw new ArchivoNoEncontradoException("El archivo "+ex+" se encuentra vacion");
		} finally {
			// Cerramos el fichero tanto si la lectura ha sido correcta o no
			if (s != null) {
				s.close();
			}
		}
		return lista;
	}
	
	public boolean esContraseniaDebil(String contrasenia) {
		return  listaDeClavesProhibidas.contains(contrasenia);
	}



}
