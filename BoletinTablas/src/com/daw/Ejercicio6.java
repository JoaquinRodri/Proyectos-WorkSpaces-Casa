package com.daw;

import java.util.Arrays;

public class Ejercicio6 {

	public static void main(String[] args) {
		
		/*
		int n [][] = new int [5][6];
		
		for (int i = 0; i < n.length; i++) {
			for (int j = 0; j < n.length; j++) {
				if (i==0 || i==(n.length-1)) {
					n[i][j] = 1;
				} else if (j==0 || j==(n.length-1)) {
					n[i][j] = 1;
				} else {
					n[i][j] = 0;
				}
			}
		}
		
		for (int i = 0; i < n.length; i++) {
			for (int j = 0; j < n.length; j++) {
				System.out.print(n[i][j]);
			}
			System.out.println();
		}*/
		
		
		
		
		int numeros[] = new int[20];
		
		for (int i = 0; i < numeros.length; i++) {
			numeros[i]= (int)(Math.random()*5)+1;
		}
		System.out.println(Arrays.toString(numeros));
		int vector [] = sinRepetidos(numeros);
		System.out.println(Arrays.toString(vector));
		
		
	}

	static int[] sinRepetidos(int[]numeros) {
		
		int contRe = 0;
		for (int i = 0; i < numeros.length; i++) {
			for (int j = 0; j < numeros.length; j++) {
				if (numeros[i]==numeros[j]) {
					if (i<j) {
						contRe++;
					} else if (i>j) {
						break;
					}
				}
			}
		}
		
		//int sinRepetidos [] = new int [(numeros.length-contRe)];
		int sinRepetidos [] = new int [(numeros.length)];
		int indice = 0;
		for (int i = 0; i < numeros.length; i++) {
			boolean esta = false;
			for (int j = 0; j < sinRepetidos.length; j++) {
				if (sinRepetidos[j]==numeros[i]) {
					esta = true;
					//sinRepetidos[i]=-1;
					break;
				}
			}
			if (esta!=true) {
				sinRepetidos[indice]=numeros[i];
				indice++;
				//sinRepetidos[i]=numeros[i];
			}
		}
		
		//for (int i = indice; i < sinRepetidos.length; i++) {
			//sinRepetidos[i]=-1;
		//}
		return sinRepetidos;
	}
	
}
