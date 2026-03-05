package com.daw;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Tamaño de Array:");
		int tamaño = sc.nextInt();
		System.out.println("Longitud de las Passwords:");
		int longitud = sc.nextInt();
		
		Password[] passwords = new Password[tamaño];
		boolean[] fuertes = new boolean[tamaño];
		
		for (int i = 0; i < tamaño; i++) {
			passwords[i]= new Password(longitud);
			fuertes[i] = passwords[i].esFuerte();
			
		}
		
		for (int i = 0; i < tamaño; i++) {
			System.out.println(passwords[i].getContraseña() + " " + fuertes[i]);
		}
		
		sc.close();

	}

}
