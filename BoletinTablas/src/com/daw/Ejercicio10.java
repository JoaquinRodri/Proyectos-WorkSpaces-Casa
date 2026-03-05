package com.daw;


import java.util.Scanner;

public class Ejercicio10 {

	public static void main(String[] args) {
		
		
		
		int [] vector = new int[5];
		int cantImpares = rellenaPares(vector);
		
		
		
		System.out.println("el numero de impares es: "+cantImpares);

	}
	static int rellenaPares(int[]vector) {
		int cont = 0;
		Scanner sc = new Scanner(System.in);
		int i = 0;
		while (i!=vector.length) {
			System.out.println("Inserta un numero");
			int numero = sc.nextInt();
			if (numero%2==0) {
				vector[i]=numero;
				i++;
			}else {
				cont++;
			}
			
			
		}
		for (int j = 0; j < vector.length; j++) {
			System.out.print(vector[j]+", ");
		}
		
		sc.close();
		return cont;
	}

}
