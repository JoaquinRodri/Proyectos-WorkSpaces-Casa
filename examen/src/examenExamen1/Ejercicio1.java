package examenExamen1;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int [][] matriz = new int [4][4];
		System.out.println("Por favor, introduce los valores de la matriz:");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
						matriz[i][j] = sc.nextInt();;
			}
		}
		System.out.println();
		
		//imprimir la matriz
		System.out.println("La matriz introducida es la siguiente:");
		for (int i = 0; i < matriz.length; i++) {
			String fila = "";
			for (int j = 0; j < matriz.length; j++) {
				fila += matriz[i][j]+" ";
			}
			System.out.println(fila);
		}
		
		//valor maximo y minimo.
		int max = matriz[0][0];
		int min = matriz[0][0];
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				if (matriz[i][j]>max) {
					max = matriz[i][j];
				} else if (matriz[i][j]<min) {
					min = matriz[i][j];
				}
			}
		}
		
		System.out.println("El valor máximo de la matriz es: "+max);
		System.out.println("El valor mínimo de la matriz es: "+min);
		
		//calcular media.
		float media = 0.0f;
		int sumaTotal = 0;
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				sumaTotal+=matriz[i][j];
			}
		}
		media = (float)sumaTotal/(matriz.length*matriz.length);
		System.out.println("El valor medio de los valores es: "+media);
		
		//primera diagonal
		String diagonal1 = "";
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				if (i==j) {
					diagonal1+=matriz[i][j]+" ";
				}
			}
		}
		
		System.out.println("Primera diagonal: "+diagonal1);
		
		//segunda diagonal
		String diagonal2 = "";
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				if (i+j==matriz.length-1) {
					diagonal2+=matriz[i][j]+" ";
				}
			}
		}
		
		System.out.println("Segunda diagonal: "+diagonal2);
		
		sc.close();

		
	}

}
