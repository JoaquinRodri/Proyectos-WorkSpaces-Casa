package com.daw;

import java.util.Iterator;
import java.util.Scanner;

public class Ejercicio14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int limite = 0;
		System.out.println("Introduce un numero para dibujar un triángulo rectángulo de n elementos");
		int num = sc.nextInt();
		String fila = "";
		limite = num;
		
		for (int i = 1; i <= num ; i++) {
			fila = "";
			for (int j = 1; j <= num-i+1 ; j++) {
				fila+="*";
			}
			System.out.println(fila);
			limite--;
		}
		
		
		/*for (int i = 0; i < num; i++) {
			fila = "";
			for (int j =0 ; j < num-i ; j++) {
				fila+="*";
			}
			System.out.println(fila);
		}*/
		sc.close();

	}

}
