package com.daw;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		/*
		 * Ejercicio 1: Procesamiento de Entrada de Usuario. El usuario introduce una
		 * frase de ejemplo, que puede tener espacios innecesarios al inicio y al final.
		 * 
		 * a) Limpieza y Estandarización (trim(), toLowerCase(), startsWith()): Elimina
		 * los espacios en blanco al inicio y al final de la frase. Convierte toda la
		 * frase a minúsculas. Verifica e imprime si la frase resultante comienza con la
		 * palabra "java". 
		 * 
		 * b) Segmentación y Extracción (split(), length): Divide la
		 * frase limpia en un array de palabras usando el espacio como delimitador.
		 * Imprime la cantidad total de palabras en el array. 
		 * 
		 * c) Subcadena y
		 * Modificación (substring(), replace()): Extrae el primer tercio de la frase
		 * limpia como una subcadena. En esa subcadena, reemplaza todas las letras 'a'
		 * por el símbolo '*'.
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una frase:");
		String frase = sc.nextLine();
		String fraseMod;
		//A
		fraseMod = frase.trim();
		
		fraseMod = fraseMod.toLowerCase();
		
		if (fraseMod.startsWith("java")) {
			System.out.println("La frase empieza con java.");
		}else {
			System.out.println("La frase no empieza con java.");
		}
		
		//B
		String [] fraseDivididaSpace = fraseMod.split(" ");
		
		System.out.println("La cantidad total de palabras es: "+fraseDivididaSpace.length);
		
		//C
		int tercio = fraseMod.length()/3;
		String cadena;
		cadena = fraseMod.substring(0, tercio);
		System.out.println(cadena);
		cadena = cadena.replace('a', '*');
		System.out.println(cadena);
		
		
		sc.close();

	}

}
