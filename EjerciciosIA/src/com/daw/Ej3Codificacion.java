package com.daw;

import java.util.Scanner;

public class Ej3Codificacion {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una frase:");
		String frase = sc.nextLine();
		
		frase = frase.trim();
		
		String fInvertida = invertida(frase);
		
		String fSustituida = sustituirVocal(fInvertida);
		
		fSustituida = fSustituida.toUpperCase();
		System.out.println("Frase codificada: "+fSustituida);
		
		sc.close();

	}
	public static String sustituirVocal(String texto) {
		char caracteres [] = texto.toCharArray();
		String valoresU = "256789";
		for (int i = 0; i < texto.length(); i++) {
			if (texto.charAt(i)=='a') {
				caracteres[i]='4';
			}
			if (texto.charAt(i)=='e') {
				caracteres[i]='3';
			}
			if (texto.charAt(i)=='i') {
				caracteres[i]='1';
			}
			if (texto.charAt(i)=='o') {
				caracteres[i]='0';
			}
			if (texto.charAt(i)=='u') {
				int indice = (int)(Math.random()*6);
				caracteres[i]=valoresU.charAt(indice);
			}
		}
		
		String resultado = String.valueOf(caracteres);
		
		return resultado;
	}
	
	static String invertida(String texto) {
		String inver = "";
		for (int i = texto.length()-1; i >= 0; i--) {
			inver+=texto.charAt(i);
		}
		
		return inver;
	}

}
