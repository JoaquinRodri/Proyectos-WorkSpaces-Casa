package com.daw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

	private static Scanner sc = new Scanner(System.in);
	private static final TreeMap<String, Producto> inventario = new TreeMap<String, Producto>();

	public static void main(String[] args) {
		
		System.out.println("*******************");
		System.out.println("TIENDA DE REPUESTOS");
		System.out.println("*******************");
		System.out.println();
		
		cargarInventario();
		
		imprimirInventario();

		int opcion = 0;
		while (opcion != 5) {

			System.out.println("Selecciona la operación a realizar:");
			System.out.println("\t 1.- Alta Producto.");
			System.out.println("\t 2.- Baja Producto.");
			System.out.println("\t 3.- Cambiar Stock Producto.");
			System.out.println("\t 4.- Imprimir inventario.");
			System.out.println("\t 5.- Salir.");
			
			opcion = sc.nextInt();
			sc.nextLine();
			
			switch(opcion) {
				case 1:
					altaProducto();
					break;
				case 2:
					bajaProducto();
					break;
				case 3: 
					modificarStockProducto();
					break;
				case 4:
					imprimirInventario();
					break;
				case 5:
					guardarInventario();
					break;
				default:
					System.out.println("Opción incorrecta.");
			}

		}

	}

	public static void altaProducto() {
		
		System.out.println("Introduce el codigo del producta a dar de alta:");
		String codigo = sc.nextLine();
		
		if (inventario.containsKey(codigo)) {
			System.out.println("EL codigo de producto a insertar ya existe.");
			return;
		}
		
		System.out.println("Introduce la descripcion de producto con codigo "+codigo+":");
		String descripcion = sc.nextLine();
		
		System.out.println("Introduce el numero de stock del producto a insertar:");
		Integer stock = Integer.valueOf(sc.nextLine());
		
		Producto p = new Producto(codigo, descripcion, stock);
		inventario.put(codigo, p);
		
		System.out.println("Producto dado de alta correctamente.");
		
	}

	public static void bajaProducto() {
		
		System.out.println("Introduce el codigo del producto a borrar:");
		String codigo = sc.nextLine();
		
		if (inventario.containsKey(codigo)) {
			inventario.remove(codigo);
			System.out.println("Producto con codigo "+codigo+" eliminado.");
		}else {
			System.out.println("El codigo "+codigo+" no pertenece a ningun producto.");
		}
		
	}

	public static void modificarStockProducto() {
		
		System.out.println("Introduce el codigo del producto a modificar el stock:");
		String codigo = sc.nextLine();
		
		if (!inventario.containsKey(codigo)) {
			System.out.println("El codigo "+codigo+" no pertenece a ningun producto.");
			return;
		}
		
		Producto p = inventario.get(codigo);
		
		System.out.println("Introduce el nuevo stock del producto:");
		Integer stock = Integer.valueOf(sc.nextLine());
		
		p.setStock(stock);
		System.out.println("Stock actualizado.");
		
	}

	public static void cargarInventario() {
		
		try {
			BufferedReader leer = new BufferedReader(new FileReader("resources/inventario.txt"));
			String linea = leer.readLine();
			while (linea!=null) {
				String [] partes = linea.split("#");
				if (!linea.isBlank()) {
					Producto p = new Producto(partes[0], partes[1], Integer.valueOf(partes[2]));
					inventario.put(partes[0], p);
				}
				linea = leer.readLine();
				
			}
			leer.close();
		} catch (FileNotFoundException e) {
			System.out.println("El fichero no existes o no se ha podido abrir.");
		} catch (IOException e) {
			System.err.println("Erros al intentar leer el fichero.");
		}
		
	}

	public static void guardarInventario() {
		
		try {
			BufferedWriter escribir = new BufferedWriter(new FileWriter("resources/inventario.txt"));
			
			
			for (String cod : inventario.keySet()) {
				
				Producto p = inventario.get(cod);
				escribir.write(p.toString());
				escribir.newLine();
				
			}
			escribir.close();
		} catch (IOException e) {
			System.out.println("Error al intentar guardar el contenido en el fichero.");
		}
		
	}
	
	public static void imprimirInventario() {
		System.out.println("********************");
		System.out.println("     INVENTARIO     ");
		System.out.println("********************");
		System.out.println();
		
		//TODO: imprimir los productos del inventario
		//		Producto:
		//			Codigo: COD001
		//			Descripcion: Producto 1
		//			Stock: 50
		
		for (String cod : inventario.keySet()) {
			Producto p = inventario.get(cod);
			String resul = "Producto:\n"
					+ "\tCodigo: "+p.getCodigo()+"\n"
					+ "\tDescripcion: "+p.getDescripcion()+"\n"
					+ "\tStock: "+p.getStock()+"\n";
			System.out.println(resul);
			
		}
		
	}

}
