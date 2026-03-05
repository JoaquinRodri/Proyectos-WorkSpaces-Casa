package com.daw;

import java.util.Scanner;

public class Ejercico5 {

	public static void main(String[] args) {
		
		
		String d1 = "Javalín, javalón";
		String d2 = "javalén, len, len";
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una frase:");
		String frase = sc.nextLine();
		
		boolean esIdioma = frase.startsWith(d1) || frase.endsWith(d2);
		
		if (esIdioma) {
			String mensajeLimpio = devuelveMensaje(frase,d1,d2);
			System.out.println("El mensaje sin muletillas es: "+mensajeLimpio);
		}else {
			System.out.println("EL mensaje no corresponde la idioma de javalandia.");
		}
		
		sc.close();

	}
	static String devuelveMensaje(String mensaje, String d1, String d2) {
		String mensajeLimpio="";
		if (mensaje.startsWith(d1)) {
			mensajeLimpio = mensaje.substring(d1.length()).trim();
		}else if (mensaje.endsWith(d2)) {
			mensajeLimpio = mensaje.substring(0, mensaje.length()-d2.length()).trim();
		}
		
		
		return mensajeLimpio;
	}

}
