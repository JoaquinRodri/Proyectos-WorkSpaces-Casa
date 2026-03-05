package com.daw;

import java.util.Scanner;

public class Ej3ValidacionMatriculaCoche {

	public static void main(String[] args) {
		 
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una matricula:");
		String matricula = sc.nextLine();
		
		boolean matriculaValida = true;
		
		//muestra cuántos caracteres tiene.
		System.out.println("Longitud de la matricula: "+matricula.length());
		
		//Comprueba si los 4 primeros caracteres son todos dígitos.
		String cuatrosPrimeros = matricula.substring(0,4);
		//validacion digitos
		String primeros4 = "";
		if (validacionCuatroPrimeros(cuatrosPrimeros)) {
			primeros4 = "Si";
		}else {
			primeros4 = "No";
			matriculaValida = false;
		}
		System.out.println("Los 4 primeros caracteres son dígitos: "+primeros4);
		
		//Comprueba si los 3 últimos caracteres son letras y están en mayúscula.sin ñ
		String ultimos3 = matricula.substring(matricula.length()-3, matricula.length());
		//validacion letras
		String ultimos = "";
		if (validacionUltimos(ultimos3)) {
			ultimos = "Si";
		}else {
			ultimos = "No";
			matriculaValida = false;
		}
		System.out.println("Los 3 últimos caracteres son letras mayúsculas: "+ultimos);
		
		//comprobar si tiene espacios interiores
		if (matricula.contains(" ")) {
			matriculaValida = false;
			System.out.println("Contiene espacios interiores");
		}
		
		//comprobacion de si la matricula es valida
		System.out.print("Resultado: ");
		if (matriculaValida) {
			System.out.println("La matricula es valida.");
		}else {
			System.out.println("La matricula no es valida.");
		}
		sc.close();
		

	}
	static boolean validacionUltimos(String ultimos) {
		for (int i = 0; i < ultimos.length(); i++) {
			if (!Character.isLetter(ultimos.charAt(i)) || ultimos.charAt(i)=='ñ') {
				return false;
			}
		}
		return true;
	}
	
	static boolean validacionCuatroPrimeros(String primeros) {
		for (int i = 0; i < primeros.length(); i++) {
			if (!Character.isDigit(primeros.charAt(i))) {
				return false;
			}
		}
		return true;
	}

}
