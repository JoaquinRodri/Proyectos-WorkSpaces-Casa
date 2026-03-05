package com.daw;

import java.util.Scanner;

public class Ej1AnalisisFrase {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una frase:");
		String frase = sc.nextLine();
		
		//muéstrala entre comillas dobles tal cual la ha escrito el usuario.
		System.out.println("frase original: \""+frase+"\"");
		
		//Muestra cuántos caracteres tiene la frase sin contar los espacios en blanco.
		frase = frase.trim();
		muestraNumCaracteres(frase);
		
		//Muestra el primer y el último carácter de la frase (ignorando si hay espacios al principio o al final).
		System.out.println("Primer caracter no vacio: \'"+frase.charAt(0)+"\'");
		System.out.println("ultimo caracter no vacio: \'"+frase.charAt(frase.length()-1)+"\'");
		
		//Pide al usuario una palabra y muestra si esa palabra aparece dentro de la frase o no.
		System.out.println("Introduce una palabra a buscar:");
		String palabra = sc.nextLine();
		System.out.print("¿La palabra \""+palabra+"\" aparece en la frase?: ");
		if (aparecePalabra(frase, palabra)) {
			System.out.print("Si");
		}else {
			System.out.print("No");
		}
		sc.close();
		

	}
	static boolean aparecePalabra(String frase, String palabra) {
		boolean aparece = false;
		if (frase.indexOf(palabra) != -1) {
			aparece = true;
		}
		
		
		return aparece;
	}
	
	static void muestraNumCaracteres(String frase) {
		int cont = 0;
		for (int i = 0; i < frase.length(); i++) {
			if (frase.charAt(i)!=' ') {
				cont++;
			}
		}
		System.out.println("Número de caracteres (sin espacios): "+cont);
	}

}
