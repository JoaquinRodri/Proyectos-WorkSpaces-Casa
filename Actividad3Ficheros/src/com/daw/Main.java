package com.daw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca nombre de fichero a copiar:");
		String n_fichero = sc.nextLine();
		
		
		
		try {
			BufferedReader leer = new BufferedReader(new FileReader("resource/"+n_fichero+".txt"));
			BufferedWriter escribir = new BufferedWriter(new FileWriter("resource/copia_de_"+n_fichero+".txt"));
			String linea = leer.readLine();
			while (linea!=null) {
				escribir.write(linea);
				escribir.newLine();
				linea = leer.readLine();
				
			}
			leer.close();
			escribir.close();
		} catch (FileNotFoundException e) {
			System.out.println("el fichero no existe o  eeror al acceder al fichero.");
		} catch (IOException e) {
			System.out.println("Se a producido un error al escribir en el fichero");
		}
		
		sc.close();
		
	}

}
