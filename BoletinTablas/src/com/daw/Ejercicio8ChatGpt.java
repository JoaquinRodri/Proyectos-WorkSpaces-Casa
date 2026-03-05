package com.daw;

import java.util.Scanner;

public class Ejercicio8ChatGpt {

	public static void main(String[] args) {

		int [] vector = {1,6,1,7,5};
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un numero:");
		int numeroAInsert = sc.nextInt();
		System.out.println("Inserta la posicion donde quieres meterlo");
		int indice;
		do {
			indice = sc.nextInt();
			if (indice<0 || indice>vector.length) {
				System.out.println("posicion no valida, introduce un posicion valida del vector.");
			}
		} while (indice<0 || indice>vector.length);
		
		int [] vector2 = new int[vector.length+1];
		for (int i = 0; i < vector2.length; i++) {
			if (i==indice) {
				vector2[i]=numeroAInsert;
			} else if (i>indice) {
				vector2[i]=vector[i-1];
			}else {
				vector2[i]=vector[i];
			}

		}

		

		for (int i = 0; i < vector2.length; i++) {
			System.out.print(vector2[i]);
		}
		
		sc.close();

	}

}
