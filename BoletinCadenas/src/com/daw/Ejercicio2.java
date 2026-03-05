package com.daw;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce la contraseña que vamos a intentar descubrir:");
		String contraseña = sc.nextLine();
		char primeraLetra = contraseña.charAt(0);
		char ultimaLetra = contraseña.charAt(contraseña.length()-1);
		System.out.println("Tienes estas pista:\n"
				+ "Numeros de caracteres: "+contraseña.length()+"\n"
						+ "Primera letra: "+primeraLetra+"\n"
								+ "Ultima letra: "+ultimaLetra);
		System.out.println("Intenta averiguar la contraseña:");
		String intenContraseña = sc.nextLine();
		
		if (contraseña.equals(intenContraseña)) {
			System.out.println("Acertaste");
		}else {
			System.out.println("Fallaste");
		}
		
		sc.close();

	}

}
