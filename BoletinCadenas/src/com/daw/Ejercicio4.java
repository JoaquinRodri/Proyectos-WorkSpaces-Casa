package com.daw;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una frase:");
		String frase = sc.nextLine();
		
		char caracterDelMedio = frase.charAt(frase.length()/2);
		System.out.println(caracterDelMedio);
		
		if (Character.isSpaceChar(caracterDelMedio)) {
			System.out.println("El caracter del medio es un espacio.");
		}else {
			System.out.println("El caracter del medio no es un espacio.");
		}
		
		sc.close();
		
	}

}
