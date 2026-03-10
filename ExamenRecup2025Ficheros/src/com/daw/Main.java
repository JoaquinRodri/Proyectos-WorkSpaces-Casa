package com.daw;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	static final Scanner sc = new Scanner(System.in);
	static final Map<String, Cuadrado> Cuadrados = new HashMap<String, Cuadrado>();
	static final Map<String, Rectangulo> Rectangulo = new HashMap<String, Rectangulo>();
	static final Map<String, Circulo> Circulo = new HashMap<String, Circulo>();
	static final Map<String, Triangulo> Triangulo = new HashMap<String, Triangulo>();
	public static void main(String[] args) {
		
				
		procesarFichero();
		
		Integer opcion = 0;
		
		while (opcion != 5) {
			System.out.println("1. Crear Figura.");
			System.out.println("2. Modificar Figura.");
			System.out.println("3. Eliminar Figura.");
			System.out.println("4. Imprimir Inventario.");
			System.out.println("5. Salir.");
			opcion = Integer.valueOf(sc.nextLine());
			
			switch (opcion) {
			case 1:
				
				break;

			default:
				break;
			}
			
			
		}

	}
	public static void procesarFichero() {
		
		try {
			BufferedReader leer = new BufferedReader(new FileReader("resources/inventario.txt"));
			String linea = leer.readLine();
			while (linea!=null) {
				String [] partes = linea.split("#");
				if (partes[0].equals("CUADRADO")) {
					//Cuadrado c = new Cuadrado(partes[1], Color.valueOf(partes[2]), , null, null)
				}
				
				linea = leer.readLine();
			}
			leer.close();
		} catch (FileNotFoundException e) {
			System.out.println("El fichero no existe.");
		} catch (IOException e) {
			System.out.println("Error al leer el fichero.");
		}
		
	}

}
