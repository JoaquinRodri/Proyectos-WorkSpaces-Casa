package com.daw;

import java.util.Scanner;

public class Ejercicio14 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int cont =0;
		 System.out.println("1. ¿Cuál de estas asignaturas se ve en primero?");
	        System.out.println("1) Educación Física");
	        System.out.println("2) Programación");
	        System.out.println("3) Filosofía");
	        System.out.print("Respuesta: ");
	        int p = sc.nextInt();
	        
	        if (p == 2) {
				cont++;
			}
	        
	        System.out.println("\n2. ¿En qué asignatura se trabaja con bases de datos?");
	        System.out.println("a) Lenguaje de Marcas");
	        System.out.println("b) Sistemas Informáticos");
	        System.out.println("c) Base de Datos");
	        System.out.print("Respuesta: ");
	        p = sc.nextInt();
	        
	        if (p == 3) {
				cont++;
			}
	        
	        System.out.println("\n3. ¿Qué asignatura se centra en diseño de páginas web?");
	        System.out.println("a) Entornos de Desarrollo");
	        System.out.println("b) Lenguaje de Marcas");
	        System.out.println("c) Programación");
	        System.out.print("Respuesta: ");
	        p = sc.nextInt();
	        
	        if (p == 2) {
				cont++;
			}
	        
	        System.out.println("\nHas obtenido " + cont + " puntos de 3 posibles.");
	        
	        sc.close();
	}

}
