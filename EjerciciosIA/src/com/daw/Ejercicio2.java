package com.daw;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		/*
		 * Ejercicio 2: Verificación de Formato y Transformación de Datos. Tienes un
		 * String que simula una etiqueta de inventario con el formato
		 * [CODIGO-DE-PROD-999999-FIN], donde 999999 son dígitos. 
		 * 
		 * a) Validación de
		 * Envoltura (length(), startsWith(), endsWith()): Verifica si el String tiene
		 * exactamente 20 caracteres de longitud. Confirma que comienza con [ y termina
		 * con ]. Si alguna de estas condiciones falla, imprime un mensaje de error. 
		 * 
		 * b)
		 * Extracción del Contenido (substring(), indexOf(), lastIndexOf()): Utilizando
		 * indexOf y lastIndexOf, extrae únicamente el contenido sin los corchetes (ej:
		 * CODIGO-DE-PROD-999999-FIN). 
		 * 
		 * c) Verificación Numérica y Reemplazo (contains(),
		 * replace()): Verifica si el String extraído contiene el subfijo numérico
		 * 999999. Si lo contiene, reemplaza ese subfijo por la palabra "VERSION-FINAL".
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una etiqueta de verificacion:");
		String etiqueta = sc.nextLine();
		
		
		//A
		boolean valido = validacion(etiqueta);
		if (!valido) {
			System.out.println("ERROR: etiqueta no valida");
		} else {
			System.out.println("Etiqueta valida.");
		}
		
		//B
		String etiquetaMod = etiqueta.substring(etiqueta.indexOf("[")+1, etiqueta.lastIndexOf("]"));
		System.out.println(etiquetaMod);
		
		//C
		String etiqueta2 = etiqueta;
		if (etiqueta2.contains("999999")) {
			etiqueta2 = etiqueta2.replace("999999","VERSION-FINAL");
			System.out.println(etiqueta2);
		}
		sc.close();
		

	}
	static boolean validacion(String etiqueta) {
		
		return etiqueta.length()==20 && etiqueta.startsWith("[") && etiqueta.endsWith("]");
	}

}
