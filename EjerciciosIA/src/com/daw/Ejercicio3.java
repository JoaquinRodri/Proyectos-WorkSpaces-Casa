package com.daw;


import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {

		/*
		 * Ejercicio 3: Análisis de Palíndromos y Anagramas (Simplificado) Se introduce
		 * una palabra. El objetivo es determinar si es un palíndromo simple y
		 * prepararla para una comparación de anagramas. 
		 * 
		 * a) Estandarización y Reversa
		 * (Combinación de métodos): Convierte la palabra a minúsculas. Utiliza un bucle
		 * junto con charAt() para generar un String invertido de la palabra
		 * estandarizada. 
		 * 
		 * b) Comprobación de Palíndromo (equals()): Compara la palabra
		 * estandarizada con su versión invertida usando equals() e imprime si es o no
		 * un palíndromo. 
		 * 
		 * ºc) Búsqueda Múltiple (indexOf(), lastIndexOf()): Busca e
		 * imprime la primera y última aparición del carácter que se encuentra en la
		 * posición central de la palabra original.
		 */
		
		Scanner sc =  new Scanner(System.in);
		System.out.println("Introduce una palabra:");
		String palabra = sc.nextLine();
		
		//A
		String invertido = "";
		String palabraMod = palabra.toLowerCase();
		for (int i = palabra.length()-1; i >= 0; i--) {
			invertido+=palabraMod.charAt(i);
		}
		System.out.println("Invertida: "+invertido);
		
		//B
		if (palabraMod.equals(invertido)) {
			System.out.println("es palindromo");
		}else {
			System.out.println("No es palindromo");
		}
		
		//C
		System.out.println("Introduce otra palabra:");
		String palabra2 = sc.nextLine().toLowerCase();
		
		if (palabra.length()==palabra2.length()) {
			char[] arrayPalabra2 = palabra2.toCharArray();
			for (int i = 0; i < palabra.length(); i++) {
				for (int j = 0; j < arrayPalabra2.length; j++) {
					if (palabraMod.charAt(i)==arrayPalabra2[j]) {
						arrayPalabra2[j]=' ';
						break;
					}
				}
			}
			
			String resultado = String.valueOf(arrayPalabra2);
			resultado = resultado.trim();
			
			if (resultado.length()==0) {
				System.out.println("Es anagrama");
			}else {
				System.out.println("No es anagrama");
			}
			
		}
		
		sc.close();
		

	}

}
