package com.daw;

import java.util.Scanner;

public class Ej5AnalizadorContraseñas {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una contraseña:");
		String contraseña = sc.nextLine();
		System.out.println("Subcadena a buscar en contraseña:");
		String subcadena = sc.nextLine();
		
		//muestra cuántos caracteres tiene.
		System.out.println("Longitud de la contraseña: "+contraseña.length());
		
		//muestra cuantos caracteresa son letras.
		int contLetra = caracteresLetras(contraseña);
		System.out.println("Letras: "+contLetra);
		
		//muestra cuantos caracteres son digitos.
		int contDigitos = caracteresDigitos(contraseña);
		System.out.println("Digitos: "+contDigitos);
		
		//muestra cuantos caracteres son espacios.
		int contEspacios = caracteresEspacios(contraseña);
		System.out.println("Espacios es blanco: "+contEspacios);
		
		//Muestra si la contraseña contiene una determinada subcadena (por ejemplo, "123" o el nombre del usuario).
		String contiene = "";
		if (contraseña.contains(subcadena)) {
			contiene = "Si";
		}else {
			contiene = "No";
		}
		System.out.println("¿Contiene \""+subcadena+"\"?: "+contiene);
		
		//Crea una nueva versión de la contraseña donde todos los espacios se sustituyan por un guion bajo _ y se muestren todas las letras en mayúsculas.
		mostrarContraseñaModificada(contraseña);
		
		sc.close();

	}
	static void mostrarContraseñaModificada(String contraseña) {
		contraseña = contraseña.toUpperCase();
		char caracteres [] = contraseña.toCharArray();
		for (int i = 0; i < caracteres.length; i++) {
			if (Character.isSpaceChar(caracteres[i])) {
				caracteres[i] = '_';
			}
		}
		String contrasenaMod = String.valueOf(caracteres);
		System.out.println("Contraseña transformada: "+contrasenaMod);
	}
	
	static int caracteresEspacios(String contraseña) {
		int contador = 0;
		for (int i = 0; i < contraseña.length(); i++) {
			if (Character.isSpaceChar(contraseña.charAt(i))) {
				contador++;
			}
		}
		
		return contador;
	}
	
	static int caracteresDigitos(String contraseña) {
		int contador = 0;
		for (int i = 0; i < contraseña.length(); i++) {
			if (Character.isDigit(contraseña.charAt(i))) {
				contador++;
			}
		}
		
		return contador;
	}
	
	static int caracteresLetras(String contraseña) {
		int contador = 0;
		for (int i = 0; i < contraseña.length(); i++) {
			if (Character.isLetter(contraseña.charAt(i))) {
				contador++;
			}
		}
		
		return contador;
	}

}
