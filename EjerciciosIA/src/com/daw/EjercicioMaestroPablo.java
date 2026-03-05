package com.daw;



public class EjercicioMaestroPablo {

	public static void main(String[] args) {
		
		String frase = " Hola Mundo Java 2024! Aprender Programación es clave. ";
		
		//Normalizacion.
		String textoNormalizado = normalizar(frase);
		System.out.println("Texto Normalizado: "+textoNormalizado);
		
		// Conteo de caracteres
		contarCaracteres(textoNormalizado);
		
		// Conteo de un carácter concreto
		char caracter = 'a';
		int contadorCaracteres = contarCaracter(textoNormalizado, caracter);
		System.out.println("El caracter '"+caracter+"' aparece "+contadorCaracteres+" veces en la frase.");
		
		//Análisis de palabras
		analizarPalabras(textoNormalizado);
		
		//Clasificación de palabras
		clasificarPalabras(textoNormalizado);
		
		//Transformación final
		System.out.println(transformar(textoNormalizado));
		

	}
	
	
	static String transformar(String texto) {
		char[] caracteres = texto.toCharArray();
		String textoMod = "";
		for (int i = 0; i < caracteres.length; i++) {
			char c = caracteres[i];
			if (!Character.isLetter(c) && !Character.isDigit(c) && !Character.isSpaceChar(c)) {
				
			}else if (Character.isLetter(c)) {
				textoMod+=Character.toUpperCase(c);
			}else if (Character.isSpaceChar(c)) {
				textoMod+="_";
			}else if (Character.isDigit(c)) {
				textoMod+=c;
			}
		}
		return textoMod;
	}
	
	static void clasificarPalabras(String texto) {
		String [] palabras = texto.split(" ");
		
		
		for (int i = 0; i < palabras.length; i++) {
			String palabra = palabras[i];
			boolean tieneLetras = false;
			boolean tieneNumeros = false;
			boolean tieneOtros = false;
			for (int j = 0; j < palabra.length(); j++) {
				if (Character.isLetter(palabra.charAt(j))) {
					tieneLetras = true;
				}else if (Character.isDigit(palabra.charAt(j))) {
					tieneNumeros = true;
				}else {
					tieneOtros = true;
				}
			}
			System.out.println("palabra: "+palabra);
			if (tieneLetras && !tieneNumeros && !tieneOtros) {
				System.out.println("Tiene solo letras.");
			}else if (tieneNumeros && !tieneLetras && !tieneOtros) {
				System.out.println("Tiene solo numeros.");
			}else if (tieneLetras && tieneNumeros) {
				System.out.println("Contiene letras y numeros.");
			}else if (tieneOtros && tieneNumeros) {
				System.out.println("Contiene numeros y tambien contiene otros caracteres");
			}else if (tieneOtros && tieneLetras) {
				System.out.println("Contiene letras y tambien contiene otros caracteres");
			}
			System.out.println();
		}
	}
	
	static void analizarPalabras(String texto) {
		String [] palabras = texto.split(" ");
		for (int i = 0; i < palabras.length; i++) {
			String palabra = palabras[i];
			System.out.println("Palabra: "+palabra);
			System.out.println("Longitud: "+palabras.length);
			char primera = palabra.charAt(0);
			char ultima = palabra.charAt(palabra.length()-1);
			if (!Character.isLetter(ultima)) {
				ultima = palabra.charAt(palabra.length()-2);
			}
			System.out.println("Primera y ultima letra: "+primera+", "+ultima);
			System.out.println();
		}
	}
	
	
	static int contarCaracter(String texto, char caracter) {
		int contCaracter = 0;
		for (int i = 0; i < texto.length(); i++) {
			if (Character.compare(texto.charAt(i), caracter) == 0) {
				contCaracter++;
			}
		}
		return contCaracter;
	}
	
	static void contarCaracteres(String texto) {
		int contLetras = 0;
		int contDigitos = 0;
		int contEspacios = 0;
		int otros = 0;
		
		for (int i = 0; i < texto.length(); i++) {
			if (Character.isLetter(texto.charAt(i))) {
				contLetras++;
			}else if (Character.isDigit(texto.charAt(i))) {
				contDigitos++;
			}else if (Character.isSpaceChar(texto.charAt(i))) {
				contEspacios++;
			}else {
				otros++;
			}
		}
		System.out.println("Letras: "+contLetras);
		System.out.println("Digitos: "+contDigitos);
		System.out.println("Espacios: "+contEspacios);
		System.out.println("Otros caracteres: "+otros);
		
	}
	
	static String normalizar(String texto) {
		texto = texto.trim();
		texto = texto.toLowerCase();
		
		return texto;
	}

}
