package com.edu.ubosque.model;

public class AutomataCelular {

	public int regla30(int a, int b, int c) {
		int r = 0;
		if(a == 1 && b == 1 && c == 1) r = 0;
		else if(a == 1 && b == 1 && c == 0) r = 0;
		else if(a == 1 && b == 0 && c == 1) r = 1;
		else if(a == 1 && b == 0 && c == 0) r = 1;
		else if(a == 0 && b == 1 && c == 1) r = 0;
		else if(a == 0 && b == 1 && c == 0) r = 0;
		else if(a == 0 && b == 0 && c == 1) r = 1;
		else if(a == 0 && b == 0 && c == 0) r = 0;
		
		return r;
	}
	
	public String dePalabraABin(String pal) {
		String cadena = "0abcdefghijklmnopqrstuvwxyz1234$";
		String palBin = "";
		
		for (int i = 0; i < pal.length(); i++) {
			for (int j = 0; j < cadena.length(); j++) {
				if(pal.charAt(i) == cadena.charAt(j)) {
					String aux = Integer.toBinaryString(j);
					if(aux.length() < 5) {
						for (int k = 0; k < 5; k++) {
							aux = 0 + aux;
							if(aux.length() == 5) {
								break;
							}
						}
					}
					palBin = palBin + aux;
				}
			}
		}
		return palBin;
	}
	
	public String deBinAPalabra(String xor) {
		String cadena = "0abcdefghijklmnopqrstuvwxyz1234$";
		String binPal = "";
		
		for (int i = 0; i < xor.length();) {
			String letra = xor.substring(i, i+5);
			if(letra.length() == 5) {
				int pos = Integer.parseInt(letra, 2);
				binPal = binPal + cadena.charAt(pos);
				i+=5;
			}
		}
		System.out.println(binPal);
		return binPal;
	}
	
	public String cifrado(String palabra, String secreta, int celula, int tiempo) {
		String cifrado = "";
		String binSecreta = dePalabraABin(secreta);
		String binPalabra = dePalabraABin(palabra);
		String llave = "";
		String xor = "";
		
		int[][] binarios = new int[tiempo + binPalabra.length()][binSecreta.length()];
		
		for (int i = 0; i < binSecreta.length(); i++) {
			String n = binSecreta.charAt(i)+"";
			binarios[0][i] = Integer.parseInt(n);
		}
		
		
		int alto = binarios.length;
		int ancho = binarios[0].length;
		
		for (int i = 1; i < alto; i++) {
			for (int j = 0; j < ancho; j++) {
				int a = binarios[i-1][((j-1)+ancho)%ancho];
				int b = binarios[i-1][j];
				int c = binarios[i-1][((j+1)+ancho)%ancho];
				binarios[i][j] = regla30(a, b, c);
			}
		}
		
		for (int i = tiempo; i < binarios.length; i++) {
			llave = llave + binarios[i][celula];
		}
		
		for (int i = 0; i < llave.length(); i++) {
			String n = llave.charAt(i) + "";
			String n2 = binPalabra.charAt(i) + "";
			
			int bin1 = Integer.parseInt(n);
			int bin2 = Integer.parseInt(n2);
			
			xor = xor + (bin1^bin2);
		}
		
		for(int i=0;i<binarios.length;i++) {
			for(int j=0;j<binarios[0].length;j++) {
				System.out.print(binarios[i][j]+"\t");
			}
			System.out.println();
		}
		
		System.out.println(llave);
		cifrado = deBinAPalabra(xor);
		
		return cifrado;
	}
//	
//	public static void main(String[] args) {
//		AutomataCelular ac = new AutomataCelular();
//		System.out.println(ac.cifrado("hola", "camino", 15, 25));
//	}
	
}
