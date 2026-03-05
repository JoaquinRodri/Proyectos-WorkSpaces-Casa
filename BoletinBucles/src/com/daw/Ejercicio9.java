package com.daw;

import java.util.Scanner;

public class Ejercicio9 {

	public static void main(String[] args) {
		/*
		 * Un centro de investigación de la flora urbana necesita una aplicación que
		 * muestre cual es el árbol más alto. Para ello se introducirán por teclado las
		 * alturas en cms de cada árbol, terminando cuando se introduzca -1. Los árboles
		 * se identifican mediante etiquetas con números correlativos, comenzando en 0.
		 */
		
		Scanner sc = new Scanner(System.in);
		int contArbolMAx = 0;
		int arbolMax = 0;
		int cont = 0;
		System.out.println("Introduce la medida en cm del arbol:");
		int cmArbol = sc.nextInt();
		
		while (cmArbol!=-1) {
			
			if (cmArbol>0) {
				if (cmArbol>arbolMax) {
					arbolMax = cmArbol;
					contArbolMAx = cont;
					
				}
				cont++;
				
			}
			System.out.println("Introduce la medida en cm del arbol:");
			cmArbol = sc.nextInt();
		}
		System.out.println("El arbol mas alto es el "+contArbolMAx+" con "+arbolMax+"cm.");
		
		sc.close();
	}

}
