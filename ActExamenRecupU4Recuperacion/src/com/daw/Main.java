package com.daw;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
		int op = 0;
		while (op != 5) {
			
			System.out.println("1. Agregar Animal.");
			System.out.println("2. Modificar Animal.");
			System.out.println("3. Eliminar Animal.");
			System.out.println("4. Listar Animales.");
			System.out.println("5. Salir.");
			op = Integer.valueOf(sc.nextLine());
			
			switch (op) {
			case 1:
				System.out.println("ELIGE UN ANIMAL:");
				System.out.println("1. PERRO.");
				System.out.println("2. GATO.");
				System.out.println("3. CONEJO.");
				System.out.println("4. AVE.");
				int opAnimal = Integer.valueOf(sc.nextLine());
				crearAnimal(opAnimal);
				
				break;
				
			case 2:
				System.out.println("Introduce el id del animal a modficar");
				String id = sc.nextLine();
				if (!perros.containsKey(id) && !gatos.containsKey(id) && !conejos.containsKey(id) && !aves.containsKey(id)) {
					System.out.println("EL animal con ID "+id+" no existe.");
				}else {
					modificarAnimal(id);
				}
				
				break;
				
			case 3:
				System.out.println("Introduce el id del animal a eliminar:");
				String id1 = sc.nextLine();
				
				if (perros.containsKey(id1)) {
					perros.remove(id1);
				}else if (gatos.containsKey(id1)) {
					gatos.remove(id1);
				}else if (conejos.containsKey(id1)) {
					conejos.remove(id1);
				}else if (aves.containsKey(id1)) {
					aves.remove(id1);
				}
				
				break;
				
			case 4:
				
				break;

			default:
				break;
			}
			
			
		}

	}
	public static void modificarAnimal(String id) {
		
		System.out.println("Inserte la edad del animal:");
		Float edad = Float.valueOf(sc.nextLine());
		System.out.println("¿Esta vacunado?");
		Boolean vacunado = Boolean.valueOf(sc.nextLine());
		
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
			Float edad  = Float.valueOf(sc.nextLine());
			Genero genero = Genero.valueOf(sc.nextLine());
			Boolean vacunado = Boolean.valueOf(sc.nextLine().toUpperCase());
			
			if (opAnimal == 1) {
				String raza = sc.nextLine();
				NivelEnergia energia = NivelEnergia.valueOf(sc.nextLine());
				Perro pe = new Perro(id, nombre, fecha, edad, genero, vacunado, raza, energia);
				perros.put(id, pe);
			}else if (opAnimal == 2) {
				Boolean pelirrojo = Boolean.valueOf(sc.nextLine().toUpperCase());
				Boolean convive = Boolean.valueOf(sc.nextLine().toUpperCase());
				Gato ga = new Gato(id, nombre, fecha, edad, genero, vacunado, pelirrojo, convive);
				gatos.put(id, ga);
			}else if (opAnimal == 3) {
				Double peso = Double.valueOf(sc.nextLine());
				TipoPelaje pelaje = TipoPelaje.valueOf(sc.nextLine().toUpperCase());
				Conejo co = new Conejo(id, nombre, fecha, edad, genero, vacunado, peso, pelaje);
				conejos.put(id, co);
			}else if (opAnimal == 4) {
				String especie = sc.nextLine();
				Boolean vuela = Boolean.valueOf(sc.nextLine());
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
