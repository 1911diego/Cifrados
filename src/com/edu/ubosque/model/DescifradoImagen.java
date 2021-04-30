package com.edu.ubosque.model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DescifradoImagen {

	private BufferedImage inputImage;
	private BufferedImage outputImage;
	private int l1,l2,l3;
	private int iteracion;
	private int ancho,alto;
	
	public DescifradoImagen(String ruta,int l1,int l2,int l3,int iteracion) {
		this.l1 = l1;
		this.l2 = l2;
		this.l3 = l3;
		this.iteracion = iteracion;
		
		try {
			inputImage = ImageIO.read(new File(ruta));
			ancho = inputImage.getWidth();
			alto = inputImage.getHeight();
			outputImage = inputImage;
		} catch (IOException e) {
		
		}
	}
	
	public BufferedImage descifrarImagen() {
		int[][] matrizAux = new int[iteracion+2][ancho];
		int count = 0;
		int itAux = iteracion;
		for(int i=0;i<alto-1;i++) {
			count++;
			for(int j=0;j<ancho;j++) {
				matrizAux[itAux][j] = new Color(inputImage.getRGB(j,i)).getBlue();	
			}
			itAux++;
			if(count ==2) {
				int[][] filasDescifradas = filasDescifradas(matrizAux);
				
				ordenarCifrado(filasDescifradas,i-1);
				count = 0;
				itAux = iteracion;
			}
			
		}
		return outputImage;
	}
	
	
	public int[][] filasDescifradas(int[][] matriz){
		int s1 = 0;
		int s2 = 0;
		int s3 = 0;
		int s4 = 0;
		int operacion = 0;
		int[][] resultado = new int[2][matriz[0].length];
		
		for(int i=matriz.length-2;i>=1;i--) {
			for(int j=0;j<matriz[0].length;j++) {
				
				s1 = matriz[i][modulo(j-1,ancho)];
				s2 = matriz[i][j];
				s3 = matriz[i][modulo(j+1,ancho)];
				s4 = matriz[modulo(i+1,alto)][j];
				
				operacion = ((s4-(s1*l1)-(s2*l2)-(s3*l3))+256)%256;
				if(operacion<0) operacion = (operacion+256)%256;
				matriz[i-1][j] = operacion;
			}
			
		}
	
		int x = 0;
		for(int i=0;i<2;i++) {
			
			for(int j=0;j<matriz[0].length;j++) {
				resultado[x][j] = matriz[i][j];	
			}
			x++;
		}
		return resultado;
	}
	
	private void ordenarCifrado(int[][]matriz,int x) {
		
		int auxI = 0;
		for(int i=x;i<x+2;i++) {
			for(int j=0;j<ancho;j++) {
				int color = matriz[auxI][j];
				Color c = new Color(color,color,color);
				outputImage.setRGB(j,i,c.getRGB());
			}
			auxI++;
		}
	}
	
	private int modulo(int numero, int c) {
		return (numero+c)%c;
	}
	
	
	
}
