package com.daw;

import java.util.Scanner;

public class Ej1Normalizacion {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una frase:");
		String frase = sc.nextLine();
		
		//normalizacion
		String textoNormalizado = normalizacionTexto(frase);
		
		//Primera letra de la frase en mayuscula.
		textoNormalizado = primeraMayus(textoNormalizado);
		System.out.println(textoNormalizado);
		
		//muestra varios
		muestraCPL(textoNormalizado);
		
		sc.close();

	}
	static void muestraCPL(String texto) {
		//nº total de caracteres
		System.out.println("Caracteres: "+texto.length());
		
		//Numeros de palabras
		String [] palabras = texto.split(" ");
		System.out.println("Palabras: "+palabras.length);
		
		//palabras mas larga
		String palabraXl = "";
		
		for (String palabra : palabras) {
			if (palabra.length()>palabraXl.length()) {
				palabraXl = palabra;
			}
		}
		System.out.println("Palabra mas larga: "+palabraXl);
		System.out.println("Longitud de la palabra mas larga: "+palabraXl.length());
		
	}
	
	static String primeraMayus(String texto) {
		texto = texto.toLowerCase();
		
		return texto.substring(0,1).toUpperCase() + texto.substring(1);
	}
	
	static String normalizacionTexto(String texto) {
		texto = texto.trim();
		boolean espacio = false;
		String resultado = "";
		for (int i = 0; i < texto.length(); i++) {
			char c = texto.charAt(i);
			if (Character.isLetter(c)) {
				resultado += c;
				espacio = false;
			}else if (c == ' ' && !espacio) {
				resultado += c;
				espacio = true;
			}
		}
		return resultado;
	}

}
