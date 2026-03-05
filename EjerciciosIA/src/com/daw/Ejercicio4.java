package com.daw;



public class Ejercicio4 {

	public static void main(String[] args) {
		/*
		 * Ejercicio 4: Conversión y Manipulación de Listas de Contactos Tienes un
		 * String que contiene nombres separados por un punto y coma y con títulos (ej:
		 * "Sr.Juan;Sra.Maria;Dr.Luis;"). 
		 * 
		 * a) Estandarización y Limpieza (replace(),
		 * trim()): Elimina todos los prefijos de títulos (Sr., Sra., Dr.) del String.
		 * Asegúrate de que la cadena final no tenga el punto y coma sobrante al final.
		 * 
		 * b) División y Concatenación (split(), toUpperCase()): Divide la cadena
		 * resultante en un array de nombres usando el punto y coma (;) como
		 * delimitador. Crea un nuevo String concatenando el segundo y tercer nombre del
		 * array, convertidos a mayúsculas. 
		 * 
		 * c) Búsqueda Final (contains(), isEmpty()):
		 * Verifica si la cadena original contenía algún título usando el método
		 * contains("Sr.") (o similar). Verifica si el String final concatenado no está
		 * vacío utilizando isEmpty().
		 */
		
		String listaContactos = "Sr.Juan;Sra.Maria;Dr.Luis;";
		listaContactos = listaContactos.trim();
		String[] prefijos = {"Sr.","Sra.","Dr.","Dra.","Mr."};
		
		//A
		String listaMod = listaContactos;
		for (String prefijo : prefijos) {
			listaMod = listaMod.replace(prefijo, "");
		}
		listaMod = listaMod.substring(0, listaMod.length()-1);
		System.out.println(listaMod);
		System.out.println();
		
		//B
		String nombres [] = listaMod.split(";");
		String nombreMay = "";
		for (int i = 0; i < nombres.length; i++) {
			if (i>=1) {
				nombreMay+=nombres[i].toUpperCase();
			}
		}
		
		System.out.println(nombreMay);
		System.out.println();
		
		//C
		System.out.println("Contiene los prefijos: ");
		for (String prefijo : prefijos) {
			if (listaContactos.contains(prefijo)) {
				System.out.println(prefijo);
			}
		}
		
		System.out.println();
		if (!nombreMay.isEmpty()) {
			System.out.println("No esta vacio");
		}else {
			System.out.println("Esta vacio");
		}

	}

}
