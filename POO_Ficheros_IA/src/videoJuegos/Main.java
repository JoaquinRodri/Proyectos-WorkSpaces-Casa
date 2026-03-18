package videoJuegos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	static Map<String, Consola> consolas = new HashMap<String, Consola>();
	static Map<String, Pc> pcs = new HashMap<String, Pc>();
	static Map<String, Mesa> mesas = new HashMap<String, Mesa>();
	static Map<String, Vr> vrs = new HashMap<String, Vr>();
	static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	static final String rutaFicheroText = "resources/ludoteca.txt";
	static Scanner sc = new Scanner(System.in);
	static List<VideoJuego> alquilados = new ArrayList<VideoJuego>();
	public static void main(String[] args) {
		
		// CARGAR DATOS
		cargarDatos();
		
		//MENU
		String op = "0";
		while (!op.equals("9")) {
			
			System.out.println("1. Agregar VideoJuego.");
			System.out.println("2. Modificar VideoJuego.");
			System.out.println("3. Eliminar VideoJuego.");
			System.out.println("4. Listar VideoJuego.");
			System.out.println("5. Generar informe de disponibles.");
			System.out.println("6. Mostrar obervaciones de un VideoJuego.");
			System.out.println("7. Marcar como alquilado.");
			System.out.println("8. Recuperar histórico de alquileres.");
			System.out.println("9. Salir.");
			System.out.println("Seleccione una opcion:");
			op = sc.nextLine();
			
			switch (op) {
			case "1":
				AgregarVideoJuego();
				System.out.println();
				break;
				
			case "2":
				modificarVideoJuego();
				System.out.println();
				break;
				
			case "3":
				eliminarVideoJuego();
				System.out.println();
				break;
				
			case "4":
				listarVideoJuego();
				System.out.println();
				break;
				
			case "5":
				informeDisponibles();
				System.out.println();
				break;
				
			case "6":
				observacionesVideojuego();
				System.out.println();
				break;
				
			case "7":
				marcarAlquilado();
				System.out.println();
				break;
				
			case "8":
				recuperarAlquilados();
				System.out.println();
				break;
			case "9":
				guardarDatosTxt();
				break;

			default:
				break;
			}
			
		}

	}
	public static void recuperarAlquilados() {
		
		ObjectInputStream leer = null;
		try {
			leer = new ObjectInputStream(new FileInputStream("resources/alquilado.dat"));
			while (true) {
				VideoJuego v = (VideoJuego) leer.readObject();
				alquilados.add(v);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("El fichero no existe.");
		} catch (EOFException e) {
			System.out.println("Fin del fichero.");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("Error al intentar leer el fichero.");
		}finally {
			if (leer != null) {
				try {
					leer.close();
				} catch (IOException e) {
					System.out.println("Error al intentar cerrar el fichero.");
				}
			}
		}
		
		if (alquilados.size()!= 0) {
			for (VideoJuego videoJuego : alquilados) {
				System.out.println(videoJuego.toString());
			}
		}
		
	}
	public static void marcarAlquilado() {
		List<VideoJuego> videojuegos = listaVideoJuegos();
		
		try {
			ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream("resources/alquilado.dat"));
			for (VideoJuego videoJuego : videojuegos) {
				if (!videoJuego.getDisponible()) {
					escribir.writeObject(videoJuego);
				}
			}
			
			escribir.close();
		} catch (FileNotFoundException e) {
			System.out.println("El fichero no existe.");
		} catch (IOException e) {
			System.out.println("Erro al intentar escribir el fichero.");
		}
		
	}
	public static void observacionesVideojuego() {
		
		System.out.println("Introduce el codigo del videojuego:");
		String codigo = sc.nextLine();
		System.out.println("Observaciones:");
		Boolean hayObservaciones = false;
			try {
				BufferedReader leer = new BufferedReader(new FileReader("resources/observaciones.txt"));
				String linea = leer.readLine();
				while (linea != null) {
					String partes[] = linea.split("#");
					if (partes[0].equals(codigo)) {
						System.out.println(partes[1]);
						hayObservaciones = true;
					}
					linea = leer.readLine();
				}
				
				leer.close();
			} catch (FileNotFoundException e) {
				System.out.println("El fichero no existe.");
			} catch (IOException e) {
				System.out.println("Error al leer el fichero.");
			}
		
		if (!hayObservaciones) {
			System.out.println("No existen observaciones para el videojuego "+codigo);
		}
		
	}
	public static void informeDisponibles() {
		List<VideoJuego> videojuegos = listaVideoJuegos();
		
		try {
			BufferedWriter escribir = new BufferedWriter(new FileWriter("resources/disponibles.txt"));
			
			if (videojuegos.size() == 0) {
				escribir.write("No hay videojuegos disponibles");
				escribir.newLine();
			}else {
				for (VideoJuego videoJuego : videojuegos) {
					if (videoJuego.getDisponible()) {
						escribir.write(videoJuego.stringDisponibles());
						escribir.newLine();
					}
				}
			}
			
			
			escribir.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static List<VideoJuego> listaVideoJuegos(){
		List<VideoJuego> videojuegos = new ArrayList<VideoJuego>();
		videojuegos.addAll(consolas.values());
		videojuegos.addAll(pcs.values());
		videojuegos.addAll(mesas.values());
		videojuegos.addAll(vrs.values());
		
		return videojuegos;
	}
	public static void guardarDatosTxt() {
		
		List<VideoJuego> videojuegos = new ArrayList<VideoJuego>();
		videojuegos.addAll(consolas.values());
		videojuegos.addAll(pcs.values());
		videojuegos.addAll(mesas.values());
		videojuegos.addAll(vrs.values());
		
		Collections.sort(videojuegos);
		
		try {
			BufferedWriter escribir = new BufferedWriter(new FileWriter(rutaFicheroText));
			for (VideoJuego videoJuego : videojuegos) {
				escribir.write(videoJuego.formatoGuardar());
				escribir.newLine();
			}
			
			escribir.close();
		} catch (IOException e) {
			System.out.println("Error al intentar guardar.");
		}
		
	}
	public static void eliminarVideoJuego() {
		
		System.out.println("Introduce el codigo del videojuego:");
		String codigo = sc.nextLine();
		
		if (consolas.containsKey(codigo)) {
			consolas.remove(codigo);
		}else if (pcs.containsKey(codigo)) {
			pcs.remove(codigo);
		}else if (mesas.containsKey(codigo)) {
			mesas.remove(codigo);
		}else if (vrs.containsKey(codigo)) {
			vrs.remove(codigo);
		}else {
			System.out.println("El videojuego con código "+codigo+" no existe");
		}
		
		
	}
	public static void listarVideoJuego() {
		List<VideoJuego> videojuegos = new ArrayList<VideoJuego>();
		videojuegos.addAll(consolas.values());
		videojuegos.addAll(pcs.values());
		videojuegos.addAll(mesas.values());
		videojuegos.addAll(vrs.values());
		
		Collections.sort(videojuegos, new ComparadorPorFechaYPrecio());
		
		for (VideoJuego videoJuego : videojuegos) {
			System.out.println(videoJuego);
		}
		
	}
	public static void modificarVideoJuego() {
		
		System.out.println("Introduce el codigo del videojuego:");
		String codigo = sc.nextLine();
		
		VideoJuego v = null;
		
		if (consolas.containsKey(codigo)) {
			v = consolas.get(codigo);
		}else if (pcs.containsKey(codigo)) {
			v = pcs.get(codigo);
		}else if (mesas.containsKey(codigo)) {
			v = mesas.get(codigo);
		}else if (vrs.containsKey(codigo)) {
			v = vrs.get(codigo);
		}else {
			System.out.println("El videojuego con código "+codigo+" no existe");
		}
		
		
		
		if (v != null) {
			System.out.println("Nuevo precio de alquiler:");
			Float precio = Float.valueOf(sc.nextLine());
			System.out.println("Introduce la disponibilidad:");
			Boolean disponible = sc.nextLine().equalsIgnoreCase("si")? true:false;
			
			v.setPrecioAlquiler(precio);
			v.setDisponible(disponible);
		}
		
	}
	public static void AgregarVideoJuego() {
		System.out.println("Inserta que tipo de videojuego quieres agregar:");
		String tipo = sc.nextLine();
		System.out.println("Introduce el codigo del videojuego:");
		String codigo = sc.nextLine();
		if (consolas.containsKey(codigo) || pcs.containsKey(codigo) || mesas.containsKey(codigo) || vrs.containsKey(codigo)) {
			System.out.println("Ya existe un videojuego con el código "+codigo);
			return;
		}
		
		System.out.println("Introduce el titulo de videojuego:");
		String titulo = sc.nextLine();
		LocalDate fecha = LocalDate.now();
		System.out.println("Introduce el precio del alquiler delvideojuego:");
		Float precio = Float.valueOf(sc.nextLine());
		System.out.println("Introduce el estado del videojuego (nuevo, usado o retro):");
		Estado estado = Estado.valueOf(sc.nextLine().toUpperCase());
		System.out.println("Introduce si esta disponible:");
		Boolean disponible = sc.nextLine().equalsIgnoreCase("si")? true:false;
		
		if (tipo.equalsIgnoreCase("consola")) {
			Plataforma plataforma = Plataforma.valueOf(sc.nextLine().toUpperCase());
			Boolean multijugador = sc.nextLine().equalsIgnoreCase("si")? true:false;
			
			Consola c = new Consola(codigo, titulo, fecha, precio, estado, disponible, plataforma, multijugador);
			consolas.put(codigo, c);
		}else if (tipo.equalsIgnoreCase("pc")) {
			String requisitos = sc.nextLine();
			Boolean online = sc.nextLine().equalsIgnoreCase("si")? true:false;
			
			Pc pc = new Pc(codigo, titulo, fecha, precio, estado, disponible, requisitos, online);
			pcs.put(codigo, pc);
		}else if (tipo.equalsIgnoreCase("mesa")) {
			Integer numJugadores = Integer.valueOf(sc.nextLine());
			Integer duracionPart = Integer.valueOf(sc.nextLine());
			
			Mesa mesa = new Mesa(codigo, titulo, fecha, precio, estado, disponible, numJugadores, duracionPart);
			mesas.put(codigo, mesa);
		}else if (tipo.equalsIgnoreCase("vr")) {
			Integer edadMinima = Integer.valueOf(sc.nextLine());
			Boolean sensores = sc.nextLine().equalsIgnoreCase("si")? true:false;
			
			Vr vr = new Vr(codigo, titulo, fecha, precio, estado, disponible, edadMinima, sensores);
			vrs.put(codigo, vr);
		}
		
		
	}
	public static void cargarDatos() {
		
		try {
			BufferedReader leer = new BufferedReader(new FileReader(rutaFicheroText));
			String linea = leer.readLine();
			while (linea != null) {
				//CONSOLA#CODIGO:#TITULO:#FECHAALTA:#PRECIO:#ESTADO:#DISPONIBLE:#PLATAFORMA:#MULTIJUGADOR:
				String partes[] = linea.split("#");
				String tipo = partes[0];
				String codigo = partes[1].split(":")[1];
				String titulo = partes[2].split(":")[1];
				LocalDate fecha = LocalDate.parse(partes[3].split(":")[1], formato);
				Float precio = Float.valueOf(partes[4].split(":")[1]);
				Estado estado = Estado.valueOf(partes[5].split(":")[1]);
				Boolean disponible = partes[6].split(":")[1].equalsIgnoreCase("si")? true:false;
				
				if (tipo.equalsIgnoreCase("consola")) {
					Plataforma plataforma = Plataforma.valueOf(partes[7].split(":")[1]);
					Boolean multijugador = partes[8].split(":")[1].equalsIgnoreCase("si")? true:false;
					
					Consola c = new Consola(codigo, titulo, fecha, precio, estado, disponible, plataforma, multijugador);
					consolas.put(codigo, c);
				}else if (tipo.equalsIgnoreCase("pc")) {
					String requisitos = partes[7].split(":")[1];
					Boolean online = partes[8].split(":")[1].equalsIgnoreCase("si")? true:false;
					
					Pc pc = new Pc(codigo, titulo, fecha, precio, estado, disponible, requisitos, online);
					pcs.put(codigo, pc);
				}else if (tipo.equalsIgnoreCase("mesa")) {
					Integer numJugadores = Integer.valueOf(partes[7].split(":")[1]);
					Integer duracionPart = Integer.valueOf(partes[8].split(":")[1]);
					
					Mesa mesa = new Mesa(codigo, titulo, fecha, precio, estado, disponible, numJugadores, duracionPart);
					mesas.put(codigo, mesa);
				}else if (tipo.equalsIgnoreCase("vr")) {
					Integer edadMinima = Integer.valueOf(partes[7].split(":")[1]);
					Boolean sensores = partes[8].split(":")[1].equalsIgnoreCase("si")? true:false;
					
					Vr vr = new Vr(codigo, titulo, fecha, precio, estado, disponible, edadMinima, sensores);
					vrs.put(codigo, vr);
				}
				
				linea = leer.readLine();
			}
			
			leer.close();
		} catch (FileNotFoundException e) {
			System.out.println("El fichero no existe.");
		} catch (IOException e) {
			System.out.println("Error al intentar leer el fichero.");
		}
		
	}

}
