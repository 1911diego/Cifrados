package com.edu.ubosque.model;

public class CifradoAritmetico {

	private final static char[] caracteres = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
			'�', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

	private int modulo;

	/**
	 * M�todo constructor, instancia el m�dulo de los car�cteres a utilizar
	 */
	public CifradoAritmetico() {
		modulo = caracteres.length;
	}

	/**
	 * M�todo que encripta o descencripta cadenas seg�n el requerimiento del usuario
	 * @param corrimiento, indica el corrimiento de la encriptaci�n o descencriptaci�n
	 * @param cadena, la cadena a encriptar/Desencriptar
	 * @param cifrar, booleano que indica si se ecriptar� o descencriptar� la cadena
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

