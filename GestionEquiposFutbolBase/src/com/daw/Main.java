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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	private static Map<String, Equipo> equipos = new HashMap<String, Equipo>();

	static {
		equipos.put(NombreEquipo.Real_Madrid.name(), new Equipo(NombreEquipo.Real_Madrid));
		equipos.put(NombreEquipo.Barcelona.name(), new Equipo(NombreEquipo.Barcelona));
		equipos.put(NombreEquipo.Atlético_Madrid.name(), new Equipo(NombreEquipo.Atlético_Madrid));
		equipos.put(NombreEquipo.Sevilla.name(), new Equipo(NombreEquipo.Sevilla));
		equipos.put(NombreEquipo.Real_Betis.name(), new Equipo(NombreEquipo.Real_Betis));
		equipos.put(NombreEquipo.Real_Sociedad.name(), new Equipo(NombreEquipo.Real_Sociedad));
		equipos.put(NombreEquipo.Villarreal.name(), new Equipo(NombreEquipo.Villarreal));
		equipos.put(NombreEquipo.Athletic_Club.name(), new Equipo(NombreEquipo.Athletic_Club));
		equipos.put(NombreEquipo.Valencia.name(), new Equipo(NombreEquipo.Valencia));
		equipos.put(NombreEquipo.Osasuna.name(), new Equipo(NombreEquipo.Osasuna));
		equipos.put(NombreEquipo.Celta_de_Vigo.name(), new Equipo(NombreEquipo.Celta_de_Vigo));
		equipos.put(NombreEquipo.Rayo_Vallecano.name(), new Equipo(NombreEquipo.Rayo_Vallecano));
		equipos.put(NombreEquipo.Alavés.name(), new Equipo(NombreEquipo.Alavés));
		equipos.put(NombreEquipo.Espanyol.name(), new Equipo(NombreEquipo.Espanyol));
		equipos.put(NombreEquipo.Getafe.name(), new Equipo(NombreEquipo.Getafe));
		equipos.put(NombreEquipo.Girona.name(), new Equipo(NombreEquipo.Girona));
		equipos.put(NombreEquipo.Las_Palmas.name(), new Equipo(NombreEquipo.Las_Palmas));
		equipos.put(NombreEquipo.Leganés.name(), new Equipo(NombreEquipo.Leganés));
		equipos.put(NombreEquipo.Mallorca.name(), new Equipo(NombreEquipo.Mallorca));
		equipos.put(NombreEquipo.Valladolid.name(), new Equipo(NombreEquipo.Valladolid));
	}
	static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	static Map<String, Portero> porteros = new HashMap<String, Portero>();
	static Map<String, Jugador_Campo> JugadoresDeCampo = new HashMap<String, Jugador_Campo>();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		System.out.println("##################################################");
		System.out.println("############ GESTIÓN EQUIPOS FÚTBOL ##############");
		System.out.println("##################################################");
		
		cargarDatos();
		
		Integer accion = 0;
		do {
			System.out.println("##################################################");
			System.out.println("Seleccion la operación que desea realizar:");
			System.out.println("1 - Crear un nuevo jugador:");
			System.out.println("2 - Modificar un jugador existente:");
			System.out.println("3 - Eliminar un jugador existente:");
			System.out.println("4 - Mostrar jugadores ordenados por tarjetas:");
			System.out.println("5 - Mostrar estadísticas por equipo:");
			System.out.println("6 - Salir");
			System.out.println("##################################################");
			accion = Integer.valueOf(sc.nextLine());
			
			switch(accion) {
			case 1:
				crearJugador();
				break;
			case 2:
				modificarJugador();
				break;
			case 3:
				eliminarJugador();
				break;
			case 4:
				mostrarJugadoresOrdenados();
				break;
			case 5:
				mostrarEstadísticasPorEquipo();
				break;
			case 6:
				salir();
				guardarDatos();
				break;
			default:
				System.out.println("¡¡¡Opción no válida!!!");
			}
			
			
		} while(accion!=6);
		
	}

	private static void crearJugador() {
		System.out.println("##################################################");
		System.out.println("############  CREACIÓN DE JUGADOR   ##############");
		System.out.println("##################################################");
		System.out.println("Indica el código:");
		String codigo = sc.nextLine();
						
		System.out.println("Indica el equipo:");
		String equipo = sc.nextLine();
				
		System.out.println("Indica la demarcación:");
		String demarcacion = sc.nextLine();
		
		if (JugadoresDeCampo.containsKey(codigo)) {
			System.out.println("Ya existe un jugador con ese codigo.");
			return;
		}
		
		if (!equipos.containsKey(equipo)) {
			System.out.println("El equipo "+equipo+" no existe");
			return;
		}
		
		if (!demarcacion.equals("PORTERO") && !demarcacion.equals("JUGADOR DE CAMPO")) {
			System.out.println("La demarcacion "+demarcacion+" no existe.");
			return;
		}
				
		System.out.println("Indica nombre y apellidos:");
		String nombre = sc.nextLine();
		System.out.println("Indica la fecha de nacimiento:");
		LocalDate fechaNacimiento = LocalDate.parse(sc.nextLine(), formato);
		System.out.println("Indica la estatura:");
		Float estatura = Float.valueOf(sc.nextLine());
		System.out.println("Indica los partidos jugados:");
		Integer partidosJugados = Integer.valueOf(sc.nextLine());
		System.out.println("Indica las tarjetas amarillas:");
		Integer tarjetasAmarillas = Integer.valueOf(sc.nextLine());
		System.out.println("Indica las tarjetas rojas:");
		Integer tarjetasRojas = Integer.valueOf(sc.nextLine());
				
		
		if (demarcacion.equals("PORTERO")) {
			System.out.println("Indica los goles encajados:");
			Integer golesEncajados = Integer.valueOf(sc.nextLine());
			System.out.println("Indica los penaltis parados:");
			Integer penaltisParados = Integer.valueOf(sc.nextLine());
			Portero por = new Portero(codigo, nombre, fechaNacimiento, estatura, partidosJugados, tarjetasAmarillas, tarjetasRojas, golesEncajados, penaltisParados);
			porteros.put(codigo, por);
			equipos.get(equipo).addJugador(por);
		} else if (demarcacion.equals("PORTERO")) {
			System.out.println("Indica los goles:");
			Integer goles = Integer.valueOf(sc.nextLine());
			System.out.println("Indica las asistencias:");
			Integer asistencias = Integer.valueOf(sc.nextLine());
			Jugador_Campo ju = new Jugador_Campo(codigo, nombre, fechaNacimiento, estatura, partidosJugados, tarjetasAmarillas, tarjetasRojas, goles, asistencias);
			JugadoresDeCampo.put(codigo, ju);
			equipos.get(equipo).addJugador(ju);
		}
			
			
			
						
	}

	private static void modificarJugador() {
		System.out.println("##################################################");
		System.out.println("##########  MODIFICACIÓN DE JUGADOR   ############");
		System.out.println("##################################################");
		
		System.out.println("Indica el código:");
		String codigo = sc.nextLine();
		
		Jugador j = buscarJugador(codigo);
		
		if (j == null) {
			System.out.println("No existe el jugador con codigo "+codigo);
		}
		
		if (porteros.containsKey(codigo)) {
			System.out.println("Indica los goles encajados:");
			Integer golesEncajados = Integer.valueOf(sc.nextLine());
			System.out.println("Indica los penaltis parados:");
			Integer penaltisParados = Integer.valueOf(sc.nextLine());
			Portero p = porteros.get(codigo);
			p.setGolesEncajados(golesEncajados);
			p.setPenaltisParados(penaltisParados);
		}else if (JugadoresDeCampo.containsKey(codigo)) {
			System.out.println("Indica los goles:");
			Integer goles = Integer.valueOf(sc.nextLine());
			System.out.println("Indica las asistencias:");
			Integer asistencias = Integer.valueOf(sc.nextLine());
			Jugador_Campo ju = JugadoresDeCampo.get(codigo);
			ju.setGoles(goles);
			ju.setAsistencias(asistencias);
		}
				
		
			
		
	}

	private static void eliminarJugador() {
		System.out.println("##################################################");
		System.out.println("##########  ELIMINACIÓN DE JUGADOR   #############");
		System.out.println("##################################################");
		System.out.println("Indica el código:");
		String codigo = sc.nextLine();
		
		if (!porteros.containsKey(codigo) && !JugadoresDeCampo.containsKey(codigo)) {
			System.out.println("No existe el jugador con codigo "+codigo);
			return;
		}
		
		if (porteros.containsKey(codigo)) {
			Portero p = porteros.remove(codigo);
			for (String equipo : equipos.keySet()) {
				for (Jugador j : equipos.get(equipo).getJugadores()) {
					if (p.getCodigo().equals(j.getCodigo())) {
						equipos.get(equipo).getJugadores().remove(p);
						return;
					}
				}
			}
		}else if (JugadoresDeCampo.containsKey(codigo)) {
			Jugador_Campo j = JugadoresDeCampo.remove(codigo);
			for (String equipo : equipos.keySet()) {
				for (Jugador ju : equipos.get(equipo).getJugadores()) {
					if (ju.getCodigo().equals(j.getCodigo())) {
						equipos.get(equipo).getJugadores().remove(j);
						return;
					}
				}
			}
		}
		
	}

	private static void mostrarJugadoresOrdenados() {
		System.out.println("##################################################");
		System.out.println("#############  MOSTRAR ORDENADOS   ###############");
		System.out.println("##################################################");
		
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.addAll(JugadoresDeCampo.values());
		jugadores.addAll(porteros.values());
		
		Collections.sort(jugadores, new ComparadorTarjetas());
		System.out.println("Jugadores ordenados por tarjeta:");
		System.out.println();
		for (Jugador jugador : jugadores) {
			System.out.println(jugador.getEstadisticas());
		}
	
				
	}

	private static void mostrarEstadísticasPorEquipo() {
		System.out.println("##################################################");
		System.out.println("############  MOSTRAR ESTADÍSTICAS  ##############");
		System.out.println("##################################################");
		
		
		for (String equipo : equipos.keySet()) {
			System.out.println(equipo+":");
			int golesMarc = 0;
			System.out.println();
			for (Jugador jugador : equipos.get(equipo).getJugadores()) {
				System.out.println("\t"+jugador.getEstadisticas());
				System.out.println();
				if (jugador.getDemarcacion().equals("JUGADOR DE CAMPO")) {
					Jugador_Campo j = (Jugador_Campo) jugador;
					golesMarc = golesMarc + j.getGoles();
				}
			}
			System.out.println("Goles Marcados: "+golesMarc);
			System.out.println();
		}
				
	}

	private static void salir() {
		
		
		System.out.println("Programa finalizado");
		
		
	}
	
	private static void cargarDatos() {
		
		try {
			BufferedReader leer = new BufferedReader(new FileReader("equipos.txt"));
			String linea = leer.readLine();
			while (linea != null) {
				//EQUIPO:#CODIGO:#NOMBRE:#FECHA_NACIMIENTO:#ESTATURA:#DEMARCACION:#PARTIDOS_JUGADOS:#TARJETAS_AMARILLAS:#TARJETAS_ROJAS
				String partes[] = linea.split("#");
				String nombreEquipo = partes[0];
				String codigo = partes[1].split(":")[1];
				String nombreJ = partes[2].split(":")[1];
				LocalDate fecha = LocalDate.parse(partes[3].split(":")[1], formato);
				Float estatura = Float.valueOf(partes[4].split(":")[1]);
				String demarcacion = partes[5].split(":")[1];
				Integer p_jugados = Integer.valueOf(partes[6].split(":")[1]);
				Integer amarillas = Integer.valueOf(partes[7].split(":")[1]);
				Integer rojas = Integer.valueOf(partes[8].split(":")[1]);
				
				if (demarcacion.equals("PORTERO")) {
					Integer goles = Integer.valueOf(partes[9].split(":")[1]);
					Integer penaltis = Integer.valueOf(partes[10].split(":")[1]);
					Portero por = new Portero(codigo, nombreJ, fecha, estatura, p_jugados, amarillas, rojas, goles, penaltis);
					porteros.put(codigo, por);
					equipos.get(nombreEquipo).addJugador(por);
				}else if (demarcacion.equals("JUGADOR DE CAMPO")) {
					Integer goles = Integer.valueOf(partes[9].split(":")[1]);
					Integer asistencias = Integer.valueOf(partes[10].split(":")[1]);
					Jugador_Campo jug = new Jugador_Campo(codigo, nombreJ, fecha, estatura, p_jugados, amarillas, rojas, goles, asistencias);
					JugadoresDeCampo.put(codigo, jug);
					equipos.get(nombreEquipo).addJugador(jug);
				}
				
				linea = leer.readLine();
			}
			
			leer.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	private static void guardarDatos() {
		
		
		
		try {
			BufferedWriter escribir = new BufferedWriter(new FileWriter("equipos.txt"));
			
			for (String equipo : equipos.keySet()) {
				for (Jugador jugador : equipos.get(equipo).getJugadores()) {
					escribir.write(equipo+jugador.formatoGuardar());
					escribir.newLine();
				}
			}
			
			escribir.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static Jugador buscarJugador(String codigo) {
		Jugador j = null;
		
		if(JugadoresDeCampo.containsKey(codigo)) {
			j = JugadoresDeCampo.get(codigo);
		} else if (porteros.containsKey(codigo)) {
			j = porteros.get(codigo);
		}
		
		return j;
	}

//	private static NombreEquipo buscarNombreEquipo(String nombreEquipo) {
//		
//	}

}
