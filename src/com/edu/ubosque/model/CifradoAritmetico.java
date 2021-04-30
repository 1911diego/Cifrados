package com.edu.ubosque.model;

public class CifradoAritmetico {

	private final static char[] caracteres = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
			'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

	private int modulo;

	/**
	 * Método constructor, instancia el módulo de los carácteres a utilizar
	 */
	public CifradoAritmetico() {
		modulo = caracteres.length;
	}

	/**
	 * Método que encripta o descencripta cadenas según el requerimiento del usuario
	 * @param corrimiento, indica el corrimiento de la encriptación o descencriptación
	 * @param cadena, la cadena a encriptar/Desencriptar
	 * @param cifrar, booleano que indica si se ecriptará o descencriptará la cadena
	 * @return String con la cadena encriptada o Desencriptada
	 */
	public String cifrar(int corrimiento, String cadena,boolean cifrar) {
		cadena = cadena.toLowerCase();
		if(!cifrar) corrimiento = modulo-corrimiento;
		String encriptado = "";
		for (int i = 0; i < cadena.length(); i++) {
			for (int j = 0; j < caracteres.length; j++) {
				if (cadena.charAt(i) == caracteres[j]) {
					
					if (j + corrimiento > modulo - 1) {
						encriptado += String.valueOf(caracteres[(j + corrimiento) % modulo]);
					} else {
						encriptado += String.valueOf(caracteres[j + corrimiento]);
						
					}
				}
			}
		}
		return encriptado;
	}

}

