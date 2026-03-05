package com.daw;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca su nombre:");
		String nombre = sc.nextLine();
		
		System.out.println("Introduzca su edad:");
		String edad = sc.nextLine();
		
		
		try {
			BufferedWriter escritor = new BufferedWriter(new FileWriter("resource/datos.txt"));
			
				escritor.write("Nombre: "+nombre);
				escritor.newLine();
				escritor.write("Edad: "+edad);
				
				
			escritor.close();
		}catch (FileNotFoundException e) {
			System.out.println("Error en la ruta del fichero.");
		}catch (IOException e) {
			System.out.println("Error al intentar acceder o escribir en el fichero.");
		}
		sc.close();
	}

}
