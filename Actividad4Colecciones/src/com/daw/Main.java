package com.daw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un cadena de texto");
		String cadena = sc.nextLine();
		
		cadena = cadena.trim();
		
		List<String> texto = new ArrayList<String>(Arrays.asList(cadena.split(" ")));
		
		System.out.println(texto);
		
		System.out.println("palabras repetidas:");
		for (int i = 0; i < texto.size(); i++) {
			int estaRep = 0;
			for (int j = i; j < texto.size(); j++) {
				if (texto.get(i).equals(texto.get(j))) {
					estaRep++;
				}
			}
			if (estaRep>1 && !texto.get(i).isBlank()) {
				System.out.println(texto.get(i));
			}
			
		}
		
		System.out.println("Palabras no repetidas:");
		for (int i = 0; i < texto.size(); i++) {
			int estaRep = 0;
			for (int j = 0; j < texto.size(); j++) {
				if (texto.get(i).equals(texto.get(j))) {
					estaRep++;
				}
			}
			if (estaRep==1 && !texto.get(i).isBlank()) {
				System.out.println(texto.get(i));
			}
		}

	}

}
