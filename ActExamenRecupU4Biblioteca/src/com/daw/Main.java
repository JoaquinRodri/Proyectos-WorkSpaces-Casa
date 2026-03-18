package com.daw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

	static Map<String, Cuento> cuentos = new TreeMap<String, Cuento>();
	static Map<String, NovelaInfantil> novelas = new TreeMap<String, NovelaInfantil>();
	static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	static Scanner sc =  new Scanner(System.in);
	public static void main(String[] args) {
		
		cargarDatos();
		
		String op = "0";
		while (!op.equals("5")) {
			
			System.out.println("1. Agregar libro.");
			System.out.println("2. Modificar libro.");
			System.out.println("3. Eliminar libro.");
			System.out.println("4. Imprimir inventario.");
			System.out.println("5. Salir.");
			System.out.println("Seleccione una opcion:");
			op = sc.nextLine();
			
			switch (op) {
			case "1":
				agregarLibro();
				break;
				
			case "2":
				modificarLibro();
				break;
				
			case "3":
				eliminarLibro();
				break;
				
			case "4":
				imprimirInventario();
				break;
				
			case "5":
				guardarDatos();
				break;

			default:
				System.out.println("Opcion no valida.");
				break;
			}
		}

	}
	public static void imprimirInventario() {
		List<Libro> libros = new ArrayList<Libro>();
		libros.addAll(cuentos.values());
		libros.addAll(novelas.values());
		
		Collections.sort(libros, new ComparadorPorFechaYNumPaginas());
		
		for (Libro libro : libros) {
			System.out.println(libro.formatoImprimir());
		}
		
	}
	public static void eliminarLibro() {
		
		System.out.println("Introduce el codigo del libro:");
		String codigo = sc.nextLine();
		
		if (cuentos.containsKey(codigo)) {
			cuentos.remove(codigo);
		}else if (novelas.containsKey(codigo)) {
			novelas.remove(codigo);
		}else {
			System.out.println("El libro con código "+codigo+" no existe");
		}
		
	}
	public static void modificarLibro() {
		System.out.println("Introduce el codigo del libro:");
		String codigo = sc.nextLine();
		
		if (!cuentos.containsKey(codigo) && !novelas.containsKey(codigo)) {
			System.out.println("El libro con código "+codigo+" no existe");
			return;
		}
		
		
		
		System.out.println("Introduce el titulo del libro:");
		String titulo = sc.nextLine();
		System.out.println("Introduce el autor del libro:");
		String autor = sc.nextLine();
		LocalDate fecha = LocalDate.now();
		System.out.println("Introduce el idioma del libro:");
		Idioma idioma = Idioma.valueOf(sc.nextLine().toUpperCase());
		System.out.println("Introduce el numero de paginas:");
		Integer numeroPaginas = Integer.valueOf(sc.nextLine());
		
		if (cuentos.containsKey(codigo)) {
			Cuento c = cuentos.get(codigo);
			System.out.println("Introduce el tipo de ilustracion:");
			String ilustracion = sc.nextLine();
			c.setTitulo(titulo);
			c.setAutor(autor);
			c.setFechaPublicacion(fecha);
			c.setIdioma(idioma);
			c.setNumeroPaginas(numeroPaginas);
			c.setTipoIlustracion(ilustracion);
		}else if (novelas.containsKey(codigo)) {
			NovelaInfantil nI = novelas.get(codigo);
			System.out.println("Introduce el tipo de genero:");
			String genero = sc.nextLine();
			nI.setTitulo(titulo);
			nI.setAutor(autor);
			nI.setFechaPublicacion(fecha);
			nI.setIdioma(idioma);
			nI.setNumeroPaginas(numeroPaginas);
			nI.setGenero(genero);
		}
		
	}
	public static void agregarLibro() {
		System.out.println("Introduce que tipo de libro vas agregar:");
		String tipo = sc.nextLine();
		System.out.println("Introduce el codigo del libro:");
		String codigo = sc.nextLine();
		
		if (cuentos.containsKey(codigo) || novelas.containsKey(codigo)) {
			System.out.println("Ya existe un libro con el código"+codigo);
			return;
		}
		System.out.println("Introduce el titulo del libro:");
		String titulo = sc.nextLine();
		System.out.println("Introduce el autor del libro:");
		String autor = sc.nextLine();
		LocalDate fecha = LocalDate.now();
		System.out.println("Introduce el idioma del libro:");
		Idioma idioma = Idioma.valueOf(sc.nextLine().toUpperCase());
		System.out.println("Introduce el numero de paginas:");
		Integer numeroPaginas = Integer.valueOf(sc.nextLine());
		
		if (tipo.equalsIgnoreCase("cuento")) {
			System.out.println("Introduce el tipo de ilustracion:");
			String tipoIlustracion = sc.nextLine();
			Cuento cu = new Cuento(codigo, titulo, autor, fecha, idioma, numeroPaginas, tipoIlustracion);
			cuentos.put(codigo, cu);
		}else if (tipo.equalsIgnoreCase("novela infantil")) {
			System.out.println("Introduce el tipo de genero:");
			String genero = sc.nextLine();
			NovelaInfantil nI = new NovelaInfantil(codigo, titulo, autor, fecha, idioma, numeroPaginas, genero);
			novelas.put(codigo, nI);
		}
		
	}
	public static void guardarDatos() {
		
		Set<Libro> libros = new TreeSet<Libro>();
		libros.addAll(cuentos.values());
		libros.addAll(novelas.values());
		
		try {
			BufferedWriter escribir = new BufferedWriter(new FileWriter("resources/biblioteca.txt"));
			for (Libro libro : libros) {
				escribir.write(libro.formatoGuardar());
				escribir.newLine();
			}
			
			
			escribir.close();
		} catch (IOException e) {
			System.out.println("Error al intentar escribir en el fichero.");
		}
		
	}
	public static void cargarDatos() {
		//CUENTO#CODIGO: #TITULO: #AUTOR: #FECHA PUBLICACIÓN: #IDIOMA: #NÚMERO PÁGINAS:
		// #TIPO ILUSTRACIÓN:
		try {
			BufferedReader leer = new BufferedReader(new FileReader("resources/biblioteca.txt"));
			String linea = leer.readLine();
			while (linea != null) {
				String partes[] = linea.split("#");
				String tipo = partes[0];
				String codigo = partes[1].split(":")[1];
				String titulo = partes[2].split(":")[1];
				String autor = partes[3].split(":")[1];
				LocalDate fecha = LocalDate.parse(partes[4].split(":")[1], formato);
				Idioma idioma = Idioma.valueOf(partes[5].split(":")[1]);
				Integer numeroPaginas = Integer.valueOf(partes[6].split(":")[1]);
				
				if (tipo.equalsIgnoreCase("cuento")) {
					String tipoIlustracion = partes[7].split(":")[1];
					Cuento cu = new Cuento(codigo, titulo, autor, fecha, idioma, numeroPaginas, tipoIlustracion);
					cuentos.put(codigo, cu);
				}else if (tipo.equalsIgnoreCase("novela infantil")) {
					String genero = partes[7].split(":")[1];
					NovelaInfantil nI = new NovelaInfantil(codigo, titulo, autor, fecha, idioma, numeroPaginas, genero);
					novelas.put(codigo, nI);
				}
				linea = leer.readLine();
			}
			
			leer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error el fichero no existe.");
		} catch (IOException e) {
			System.out.println("Error al intentar leer el fichero.");
		}
		
	}

}
