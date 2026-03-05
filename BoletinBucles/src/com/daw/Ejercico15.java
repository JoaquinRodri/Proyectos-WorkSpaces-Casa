package com.daw;

import java.util.Scanner;

public class Ejercico15 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int cont = 0;
		System.out.println("Introduce un numero: ");
		int num = sc.nextInt();
		
		System.out.println("1 no es primo");
		for (int i = 2; i <= num; i++) {
			boolean esprimo = true;
			for (int j = 2; j < num; j++) {
				if (i!=j) {
					if (i % j == 0) {

						esprimo = false;
					} 
				}
				
				
			}
			if (esprimo) {
				System.out.println(i + " es primo");
				cont++;
			} else {
				System.out.println(i+" no es primo");
			}
		}
		System.out.println("Resultado del programa: Entre el 1 y "+num+" hay "+cont+" números primos.");
		sc.close();
	}
	static boolean esPrimo(int num) {
		boolean primo = true;
		for (int i = 2; i < num; i++) {
			if (num%i ==0) {
				primo= false;
				break;
			}
		}
		
		return primo;
	}

}
