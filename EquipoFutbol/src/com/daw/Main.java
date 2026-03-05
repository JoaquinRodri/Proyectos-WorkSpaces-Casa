package com.daw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	private static final Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		Map<Integer, Jugador> plantilla = new HashMap<Integer, Jugador>();
		
		cargarDatos(plantilla);

		int opcion = 0;
		while (opcion!=4) {
			
			System.out.println("Seleciona una opcion:");
			System.out.println("1. Alta de jugador.");
			System.out.println("2. Eliminar jugador.");
			System.out.println("3. Editar Jugador.");
			System.out.println("4. Guardar datos.");
			System.out.println("5. Mostrar datos.");
			opcion = Integer.valueOf(sc.nextLine());
			
			Integer dorsal = null;
			switch (opcion) {
			case 1:
				System.out.println("Introduce el dorsal del jugador:");
				dorsal = Integer.valueOf(sc.nextLine());
				if (!plantilla.containsKey(dorsal)) {
					altaJugador(plantilla, dorsal);
					
				}else {
					System.out.println("Ya hay un jugador con ese dorsal.");
				}
				break;
			case 2:
				System.out.println("Introduce el dorsal del jugador:");
				dorsal = Integer.valueOf(sc.nextLine());
				if (plantilla.containsKey(dorsal)) {
					eliminarJugador(plantilla, dorsal);
				}else {
					System.out.println("No hay un jugador con ese dorsal.");
				}
				
				break;
			case 3:
				System.out.println("Introduce el dorsal del jugador:");
				dorsal = Integer.valueOf(sc.nextLine());
				Boolean result = editarJugador(plantilla, dorsal);
				if (result) {
					System.out.println("Jugador edita con exito");
				}else {
					System.out.println("No existe un jugador con ese dorsal.");
				}
				break;
			case 4:
				System.out.println("Guardando datos.....");
				guardarDatos(plantilla);
				System.out.println("Guardado con exito.");
				break;
			case 5:
				for (Jugador j : plantilla.values()) {
					System.out.println(j);
				}
				break;

			default:
				System.out.println("Opcion no valida.");
				break;
			}
		}
		

	}
	public static void altaJugador(Map<Integer, Jugador> plantilla, Integer dorsal) {
		System.out.println("Introduzce su dni:");
		String dni = sc.nextLine();
		System.out.println("Introduzce su nombre:");
		String nombre = sc.nextLine();
		System.out.println("Introduzce su estatura:");
		float estatura = Float.valueOf(sc.nextLine()); 
		System.out.println("Introduzce su posicion:");
		Posicion pos = Posicion.valueOf(sc.nextLine().toUpperCase());
		
		Jugador j = new Jugador(dni, nombre, pos, estatura);
		
		plantilla.put(dorsal, j);
	}
	
	public static Jugador eliminarJugador(Map<Integer, Jugador> plantilla, Integer dorsal) {
		Jugador eliminado = plantilla.remove(dorsal);
		System.out.println("Jugador eliminado.");
		return eliminado;
	}
	
	public static boolean editarJugador(Map<Integer,Jugador> plantilla , Integer dorsal) {
		
		if (plantilla.containsKey(dorsal)) {
			Jugador aMod = plantilla.get(dorsal);
			System.out.println("Introduce su nuevo nombre (dejar el blanco si no quieres):");
			String nombre = sc.nextLine();
			System.out.println("Introduce su nueva posicion (dejar el blanco si no quieres):");
			String pos = sc.nextLine();
			System.out.println("Introduce su nueva estatura (dejar el blanco si no quieres):");
			String est = sc.nextLine();
			
			if (!nombre.isBlank()) {
				aMod.setNombre(nombre);
			}
			if (!pos.isBlank()) {
				Posicion p = Posicion.valueOf(pos.toUpperCase());
				aMod.setPosicion(p);
			}
			if (!est.isBlank()) {
				float estatu = Float.valueOf(est);
				aMod.setEstatura(estatu);
			}
			
			plantilla.put(dorsal, aMod);
			return true;
			
		}
		
		
		/*
		 *System.out.println("Seleciona el valor a editar:");
			System.out.println("1. Nombre.");
			System.out.println("2. Posicion.");
			System.out.println("3. Estatura.");
			int opcion = sc.nexLine();
			Jugador aMod = plantilla.get(dorsal);
			
			switch (opcion) {
		case 1:
			System.out.println("Introduce su nuevo nombre:");
			String nombre = sc.nextLine();
			aMod.setNombre(nombre);
			break;
		case 2:
			System.out.println("Introduce su nueva posicion:");
			Posicion p = Posicion.valueOf(sc.nextLine());
			aMod.setPosicion(p);
			break;
		case 3:
			System.out.println("Introduce su nueva estatura:");
			float estatu = Float.ValueOf(sc.nextLine());
			aMod.setEstatura(estatu);
			break;
		default:
			break;
		}
			 */
		
		
		return false;
	}
	
	public static void guardarDatos(Map<Integer,Jugador> plantilla) {
		
		try {
			BufferedWriter escribir = new BufferedWriter(new FileWriter("resources/jugadores.txt"));
			for (Integer clave : plantilla.keySet()) {
				Jugador j = plantilla.get(clave);
				String formato = clave+"|@|"+j.getDni()+"|@|"+j.getNombre()+"|@|"+j.getPosicion().name()+"|@|"+j.getEstatura();
				escribir.write(formato);
				escribir.newLine();
			}
			escribir.close();
		} catch (IOException e) {
			System.out.println("Error al intentar escribir en el fichero.");
		}
		
	}
	
	public static void cargarDatos(Map<Integer,Jugador> plantilla) {
		
		try {
			BufferedReader leer = new BufferedReader(new FileReader("resources/jugadores.txt"));
			String linea = leer.readLine();
			while (linea!=null) {
				String partes[] = linea.split("\\|@\\|");
				Jugador j = new Jugador(partes[1], partes[2], Posicion.valueOf(partes[3]), Float.valueOf(partes[4]));
				Integer clave = Integer.valueOf(partes[0]);
				plantilla.put(clave, j);
				linea = leer.readLine();
			}
			
			leer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
