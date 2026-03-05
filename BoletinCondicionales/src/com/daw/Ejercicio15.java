package com.daw;

import java.util.Scanner;

public class Ejercicio15 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Por favor, introuzca un numero entre 0 y 9999:");
		int num = sc.nextInt();
		
		if (num>=0 && num<=9999) {
			if (num/1000>0) {
				System.out.println("Tiene 4 cifras.");
			} else if (num/100>0) {
				System.out.println("Tiene 3 cifras.");
			} else if (num/10>0) {
				System.out.println("Tiene 2 cifras.");
			} else {
				System.out.println("Tiene 1 cifra.");
			}
		} else {
			System.out.println("Numero no valido.");
		}
		
		sc.close();
	}

}
