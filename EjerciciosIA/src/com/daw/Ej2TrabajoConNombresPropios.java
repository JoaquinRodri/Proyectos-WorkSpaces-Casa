package com.daw;

import java.util.Scanner;

public class Ej2TrabajoConNombresPropios {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce el nombre completo 1:");
		String nombre1 = sc.nextLine();
		System.out.println("Introduce un caracter para indentificarlo:");
		String caracter;
		do {
			caracter = sc.nextLine();
			if (caracter.length()!=1) {
				System.out.println("Valor introducido no valido, debe de ser un caracter. Vuelva a introducirlo:");
			}
		} while (caracter.length()!=1);
		char caracterConver = caracter.charAt(0);
		System.out.println("Introduce el nombre completo 2:");
		String nombre2 = sc.nextLine();
		nombre1 = nombre1.trim();
		nombre2 = nombre2.trim();
		
		//muéstralo todo en mayúsculas.
		nombre1 = nombre1.toUpperCase();
		System.out.println("Nombre en mayusculas: "+nombre1);
		
		//muéstralo todo en minusculas.
		nombre1 = nombre1.toLowerCase();
		System.out.println("Nombre en minusculas: "+nombre1);
		
		//muestra si ese carácter es una letra, un número, un espacio en blanco u otro símbolo.
		verificarCaracter(caracterConver);
		
		//uestra si ambos nombres son iguales sin tener en cuenta mayúsculas/minúsculas.
		String sonIguales = "";
		if (nombre1.equalsIgnoreCase(nombre2)) {
			sonIguales = "Si";
		}else {
			sonIguales = "No";
		}
		System.out.println("¿Los nombres son iguales ignorando mayúsculas/minúsculas?: "+sonIguales);
		sc.close();

	}
	static void verificarCaracter(char caracter) {
		String resultado = "";
		if (Character.isDigit(caracter)) {
			resultado = "un digito";
		}else if (Character.isLetter(caracter)) {
			resultado = "una letra";
		}else if (Character.isWhitespace(caracter)) {
			resultado = "un espacio";
		}else {
			resultado = "otro simbolo";
		}
		System.out.println("El caracter '"+caracter+"' es "+resultado);
	}

}
