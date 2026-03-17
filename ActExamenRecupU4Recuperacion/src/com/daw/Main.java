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
import java.util.TreeMap;

public class Main {

	static Map<String, Perro> perros = new TreeMap<String, Perro>();
	static Map<String, Gato> gatos = new TreeMap<String, Gato>();
	static Map<String, Conejo> conejos = new TreeMap<String, Conejo>();
	static Map<String, Ave> aves = new TreeMap<String, Ave>();
	static Scanner sc = new Scanner(System.in);
	static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public static void main(String[] args) {
		
		procesarFichero();
		String op = "0";
		while (!op.equals("5")) {
			
			System.out.println("########### REFUGIO DE ADOPTACIÓN #############");
			System.out.println("1. Agregar Animal.");
			System.out.println("2. Modificar Animal.");
			System.out.println("3. Eliminar Animal.");
			System.out.println("4. Listar Animales.");
			System.out.println("5. Salir.");
			System.out.println("Seleccione una opcion:");
			op = sc.nextLine();
			
			switch (op) {
			case "1":
				System.out.println("########### AGREGAR ANIMAL #############");
				System.out.println("ELIGE UN ANIMAL:");
				System.out.println("1. PERRO.");
				System.out.println("2. GATO.");
				System.out.println("3. CONEJO.");
				System.out.println("4. AVE.");
				System.out.println("Selecciona una opcion:");
				int opAnimal = Integer.valueOf(sc.nextLine());
				crearAnimal(opAnimal);
				System.out.println();
				break;
				
			case "2":
				System.out.println("########### MODIFICAR ANIMAL #############");
				System.out.println("Introduce el id del animal a modficar");
				String id = sc.nextLine();
				if (!perros.containsKey(id) && !gatos.containsKey(id) && !conejos.containsKey(id) && !aves.containsKey(id)) {
					System.out.println("EL animal con ID "+id+" no existe.");
				}else {
					modificarAnimal(id);
				}
				
				break;
				
			case "3":
				System.out.println("########### ELIMINAR ANIMAL #############");
				System.out.println("Introduce el id del animal a eliminar:");
				String id1 = sc.nextLine();
				
				if (perros.containsKey(id1)) {
					perros.remove(id1);
					System.out.println("Animal borrado con exito");
				}else if (gatos.containsKey(id1)) {
					gatos.remove(id1);
					System.out.println("Animal borrado con exito");
				}else if (conejos.containsKey(id1)) {
					conejos.remove(id1);
					System.out.println("Animal borrado con exito");
				}else if (aves.containsKey(id1)) {
					aves.remove(id1);
					System.out.println("Animal borrado con exito");
				}else {
					System.out.println("EL animal con ID "+id1+" no existe.");
				}
				System.out.println();
				break;
				
			case "4":
				
				System.out.println("########### LISTA DE TODOS LOS ANIMALES #############\n");
				List<Animal> ordenar = listaAnimales();
				Collections.sort(ordenar, new ComparadorFechaYEdad());
				for (Animal animal : ordenar) {
					System.out.println(animal.getDescripcion());
				}
				System.out.println();
				break;
				
			case "5":
				
				System.out.println("########### GUARDADO DE DATOS EN FICHERO #############\n");
				List<Animal> ordenar2 = listaAnimales();
				Collections.sort(ordenar2);
				try {
					BufferedWriter escribir = new BufferedWriter(new FileWriter("resources/refugio.txt"));
					for (Animal animal : ordenar2) {
						escribir.write(animal.formatGuardar());
						escribir.newLine();
					}
					System.out.println("Guardando....");
					escribir.close();
				} catch (IOException e) {
					System.out.println("Error al intentar escribir el fichero.");
				}
				System.out.println("############ DATOS GUARDADOS CON EXITO ##############");
				break;

			default:
				System.out.println("Opcion no valida.");
				break;
			}
			
			
		}

	}
	public static List<Animal> listaAnimales() {
		List<Animal> aux = new ArrayList<Animal>();
		aux.addAll(perros.values());
		aux.addAll(gatos.values());
		aux.addAll(conejos.values());
		aux.addAll(aves.values());
		return aux;
	}
	public static void modificarAnimal(String id) {
		
		System.out.println("Inserte la edad del animal:");
		Float edad = null;
		try {
			edad = Float.valueOf(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("El formato de introduccion de datos no es correcto. Valor introducido por defecto 0. El formato es \"1.2\"");
			edad = 0f;
		}
		System.out.println("¿Esta vacunado?");
		Boolean vacunado = sc.nextLine().equalsIgnoreCase("si")? true:false;
		
		if (perros.containsKey(id)) {
			Perro p = perros.get(id);
			p.setEdad(edad);
			p.setVacunado(vacunado);
		}else if (gatos.containsKey(id)) {
			Gato g = gatos.get(id);
			g.setEdad(edad);
			g.setVacunado(vacunado);
		}else if (conejos.containsKey(id)) {
			Conejo co = conejos.get(id);
			co.setEdad(edad);
			co.setVacunado(vacunado);
		}else if (aves.containsKey(id)) {
			Ave av = aves.get(id);
			av.setEdad(edad);
			av.setVacunado(vacunado);
		}else {
			System.out.println("El animal con ID "+id+" no existe.");
		}
		
	}
	public static void crearAnimal(int opAnimal) {
		System.out.println("Introduce el id del animal:");
		String id = sc.nextLine();
		
		if (perros.containsKey(id) || gatos.containsKey(id) || conejos.containsKey(id) || aves.containsKey(id)) {
			System.out.println("Ya existe un animal con el ID "+id);
			return;
		}else {
			System.out.println("Introduce el nombre de animal:");
			String nombre = sc.nextLine();
			LocalDate fecha = LocalDate.now();
			System.out.println("Introduce la edad del animal:");
			Float edad;
			try {
				edad = Float.valueOf(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("El formato de introduccion de datos no es correcto. Valor introducido por defecto 0. El formato es \"1.2\"");
				edad = 0f;
			}
			System.out.println("Introduce el genero del animal:");
			Genero genero;
			try {
				genero = Genero.valueOf(sc.nextLine().toUpperCase());
			} catch (IllegalArgumentException e) {
				System.out.println("Datos no validos, solo puede ser hembra o mayo.");
				System.out.println("Volviendo al menu....");
				return;
			}
			System.out.println("Introduce si esta vacunado o no el animal:");
			Boolean vacunado = sc.nextLine().equalsIgnoreCase("si")? true:false;
			
			if (opAnimal == 1) {
				System.out.println("Introduce la raza del animal:");
				String raza = sc.nextLine();
				System.out.println("Introduce el nivel de energia del animal:");
				NivelEnergia energia;
				try {
					energia = NivelEnergia.valueOf(sc.nextLine().toUpperCase());
				} catch (IllegalArgumentException e) {
					System.out.println("Datos no validos, solo puede ser bajo, medio o alto.");
					System.out.println("Volviendo al menu....");
					return;
				}
				Perro pe = new Perro(id, nombre, fecha, edad, genero, vacunado, raza, energia);
				perros.put(id, pe);
			}else if (opAnimal == 2) {
				System.out.println("¿El animal el pelirrojo?:");
				Boolean pelirrojo = sc.nextLine().equalsIgnoreCase("si")? true:false;
				System.out.println("¿El animal convive con otros animales?:");
				Boolean convive = sc.nextLine().equalsIgnoreCase("si")? true:false;
				Gato ga = new Gato(id, nombre, fecha, edad, genero, vacunado, pelirrojo, convive);
				gatos.put(id, ga);
			}else if (opAnimal == 3) {
				System.out.println("Introduce el peso del animal:");
				Double peso = Double.valueOf(sc.nextLine());
				System.out.println("Introduce el tipo de pelaje del animal:");
				TipoPelaje pelaje;
				try {
					pelaje = TipoPelaje.valueOf(sc.nextLine().toUpperCase());
				} catch (IllegalArgumentException e) {
					System.out.println("Datos no validos, solo puede ser corto, medio o largo.");
					return;
				}
				Conejo co = new Conejo(id, nombre, fecha, edad, genero, vacunado, peso, pelaje);
				conejos.put(id, co);
			}else if (opAnimal == 4) {
				System.out.println("Introduce al especie del animal:");
				String especie = sc.nextLine();
				System.out.println("¿El animal vuela?:");
				Boolean vuela = sc.nextLine().equalsIgnoreCase("si")? true:false;
				Ave ave = new Ave(id, nombre, fecha, edad, genero, vacunado, especie, vuela);
				aves.put(id, ave);
			}
		}
		
	}
	public static void procesarFichero() {
		
		try {
			BufferedReader leer = new BufferedReader(new FileReader("resources/refugio.txt"));
			String linea = leer.readLine();
			while (linea != null) {
				String partes [] = linea.split("#");
				String animal = partes[0].trim();
				String id = partes[1].split(":")[1].trim();
				String nombre = partes[2].split(":")[1].trim();
				LocalDate fecha = LocalDate.parse(partes[3].split(":")[1].trim(), formato);
				Float edad  = Float.valueOf(partes[4].split(":")[1].trim());
				Genero genero = Genero.valueOf(partes[5].split(":")[1].toUpperCase().trim());
				Boolean vacunado = Boolean.valueOf(partes[6].split(":")[1].trim());
				
				if (animal.equals("PERRO")) {
					String raza = partes[7].split(":")[1].trim();
					NivelEnergia energia = NivelEnergia.valueOf(partes[8].split(":")[1].toUpperCase().trim());
					Perro perro = new Perro(id, nombre, fecha, edad, genero, vacunado, raza, energia);
					perros.put(id, perro);
				}else if (animal.equals("GATO")) {
					Boolean pelirrojo = Boolean.valueOf(partes[7].split(":")[1].trim());
					Boolean convive = Boolean.valueOf(partes[8].split(":")[1].trim());
					Gato gato = new Gato(id, nombre, fecha, edad, genero, vacunado, pelirrojo, convive);
					gatos.put(id, gato);
				}else if (animal.equals("CONEJO")) {
					Double peso = Double.valueOf(partes[7].split(":")[1].trim());
					TipoPelaje pelaje = TipoPelaje.valueOf(partes[8].split(":")[1].toUpperCase().trim());
					Conejo conejo = new Conejo(id, nombre, fecha, edad, genero, vacunado, peso, pelaje);
					conejos.put(id, conejo);
				}else if (animal.equals("AVE")) {
					String especie = partes[7].split(":")[1].trim();
					Boolean vuela = Boolean.valueOf(partes[8].split(":")[1].trim());
					Ave ave = new Ave(id, nombre, fecha, edad, genero, vacunado, especie, vuela);
					aves.put(id, ave);
				}		
				linea = leer.readLine();
			}
			
			leer.close();
		} catch (FileNotFoundException e) {
			System.out.println("El ficheo no existe.");
		} catch (IOException e) {
			System.out.println("Error al leer el fichero.");
		}
		
	}

}
