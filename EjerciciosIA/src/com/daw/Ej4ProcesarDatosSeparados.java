package com.daw;

import java.util.Scanner;

public class Ej4ProcesarDatosSeparados {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una linea de etxto separadas por ';':");
		String linea = sc.nextLine();
		
		
		
		//Separa la línea en sus distintos campos y elimina los espacios sobrantes al principio y al final de cada uno.
		String []palabras = linea.split(";");
		for (int i = 0; i < palabras.length; i++) {
			palabras[i] = palabras[i].trim();
			System.out.println("Campo "+(i+1)+": "+palabras[i]);
		}
		
		System.out.println("Código a comprobar al inicio: ");
		String comienzaCon = sc.nextLine();
		
		System.out.println("La linea termina con:");
		String termina = sc.nextLine();
		System.out.println("Texto a reemplazar: ");
		String textoARemplazar = sc.nextLine();
		System.out.println("Nuevo texto");
		String nuevoTexto = sc.nextLine();
		
		//Muestra si la línea comienza por un determinado código (por ejemplo, 015) y si termina con una determinada palabra (por ejemplo, Aprobado).
		String lineaSinEspacios = linea.trim();
		String empieza = "";
		if (lineaSinEspacios.startsWith(comienzaCon)) {
			empieza = "Si";
		}else {
			empieza = "No";
		}
		System.out.println("¿La línea empieza por \""+palabras[0]+"\"?: "+empieza);
		String acaba = "";
		if (lineaSinEspacios.endsWith(termina)) {
			acaba = "Si";
		}else {
			acaba = "No";
		}
		System.out.println("¿La línea termina en \""+palabras[palabras.length-1]+"\"?: "+acaba);
		
		//Muestra la misma línea pero sustituyendo todas las apariciones de un texto por otro (por ejemplo, cambiar "Aprobado" por "APTO").
		String lineaMod = linea;
		lineaMod = lineaMod.replace(textoARemplazar, nuevoTexto);
		System.out.println("Linea modificada: "+lineaMod);
		sc.close();

	}

}
