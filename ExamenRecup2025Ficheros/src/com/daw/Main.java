package com.daw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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
			
			int op;
			switch (opcion) {
			case 1:
				System.out.println("Que figura vas a crear:");
				System.out.println("1. Cuadrado");
				System.out.println("2. Triangulo");
				System.out.println("3. Rectangulo");
				System.out.println("4. Circulo");
				op = Integer.valueOf(sc.nextLine());
				crearFigura(op);
				
				break;
			case 2:
				
				System.out.println("Que figura quieres modificar:");
				System.out.println("1. Cuadrado");
				System.out.println("2. Triangulo");
				System.out.println("3. Rectangulo");
				System.out.println("4. Circulo");
				op = Integer.valueOf(sc.nextLine());
				
				modificarFigura(op);
				
				
				break;
			case 3:
				
				System.out.println("Que figura quieres eliminar:");
				System.out.println("1. Cuadrado");
				System.out.println("2. Triangulo");
				System.out.println("3. Rectangulo");
				System.out.println("4. Circulo");
				op = Integer.valueOf(sc.nextLine());
				System.out.println("Introduce el codigo de la figura:");
				String codigo = sc.nextLine();
				
				if (Triangulo.containsKey(codigo) || Cuadrados.containsKey(codigo) || Rectangulo.containsKey(codigo) || Circulo.containsKey(codigo)) {
					if (op == 1) {
						Cuadrados.remove(codigo);
						
					} else if (op == 2) {
						
						Triangulo.remove(codigo);
					} else if (op == 3) {
						
						Rectangulo.remove(codigo);
					}else if (op == 4) {
						Circulo.remove(codigo);
					}else {
						System.out.println("opcion no valida, volviendo al menu principal....");
					}
				}else {
					System.out.println("La figura con código "+codigo+" no existe");
				}
				
				break;
			case 4:
				
				List<Figura> imprimir = listaDeFiguras();
				Collections.sort(imprimir, new ComparadorfechaYPeso());
				for (Figura figura : imprimir) {
					System.out.println(figura.toString());
				}
				
				break;
			case 5:
				
				List<Figura> ordenadas = listaDeFiguras();
				Collections.sort(ordenadas, new ComparadorAlfabeticaPorArea());
				try {
					BufferedWriter escribir = new BufferedWriter(new FileWriter("resources/inventario.txt"));
					for (Figura figura : ordenadas) {
						escribir.write(figura.stringGuardar());
						escribir.newLine();
					}
					escribir.close();
				} catch (IOException e) {
					System.out.println("Error al escribir en el fichero.");
				}
				
				
				break;

			default:
				break;
			}
			
			
		}

	}
	private static List<Figura> listaDeFiguras() {
		List<Figura> figuras = new ArrayList<Figura>();
		figuras.addAll(Cuadrados.values());
		figuras.addAll(Triangulo.values());
		figuras.addAll(Circulo.values());
		figuras.addAll(Rectangulo.values());
		
		
		return figuras;
	}
	
	
	public static void modificarFigura(int op) {
		
		String codigo;
		if (op == 1) {
			System.out.println("Introduce el codigo del cuadrado ha modificar:");
			 codigo = sc.nextLine();
			if (Cuadrados.containsKey(codigo)) {
				modificarCuadrado(codigo);
			}else {
				System.out.println("La figura con código "+codigo+" no existe");
			}
		}else if (op == 2) {
			System.out.println("Introduce el codigo del triangulo a modificar:");
			codigo = sc.nextLine();
			if (Triangulo.containsKey(codigo)) {
				String figura = "triangulo";
				modificarTrianguloORectangulo(codigo, figura);
			}else {
				System.out.println("La figura con código "+codigo+" no existe");
			}
			
		}else if (op == 3) {
			System.out.println("Introduce el codigo del rectangulo a modificar:");
			codigo = sc.nextLine();
			if (Rectangulo.containsKey(codigo)) {
				String figura = "rectangulo";
				modificarTrianguloORectangulo(codigo, figura);
			}else {
				System.out.println("La figura con código "+codigo+" no existe");
			}
			
		}else if (op == 4) {
			System.out.println("Introduce el codigo del circulo a modificar:");
			codigo = sc.nextLine();
			if (Circulo.containsKey(codigo)) {
				modificarCirculo(codigo);
			}else {
				System.out.println("La figura con código "+codigo+" no existe");
			}
			
		}else {
			System.out.println("Opcio no valida, volviendo al menu principal...");
			return;
		}
		
	}
	
	
	public static void modificarCirculo(String codigo) {
		
		Circulo c = Circulo.get(codigo);
		
		System.out.println("Nuevo valor del color:");
		Color color = Color.valueOf(sc.nextLine().toUpperCase());
		System.out.println("Nueva fecha a registrar:");
		String fecha = sc.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime fechaF = LocalDateTime.parse(fecha, formatter);
		System.out.println("Nuevo peso por cm cuadrados:");
		Float peso = Float.valueOf(sc.nextLine());
		System.out.println("Nuevo valor del radio:");
		Float radio = Float.valueOf(sc.nextLine());
		
		c.setColor(color);
		c.setFechaRegistro(fechaF);
		c.setPseCmCuadrado(peso);
		c.setRadio(radio);
		
	}
	public static void modificarTrianguloORectangulo(String codigo, String nfigura) {
		
		Triangulo t = null;
		Rectangulo r = null;
		
			
		System.out.println("Nuevo valor del color:");
		Color color = Color.valueOf(sc.nextLine().toUpperCase());
		System.out.println("Nueva fecha a registrar:");
		String fecha = sc.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime fechaF = LocalDateTime.parse(fecha, formatter);
		System.out.println("Nuevo peso por cm cuadrados:");
		Float peso = Float.valueOf(sc.nextLine());
		System.out.println("Nuevo valor del base:");
		Float base = Float.valueOf(sc.nextLine());
		System.out.println("Nuevo valor del altura:");
		Float altura = Float.valueOf(sc.nextLine());
		
		
		if (nfigura.equals("triangulo")) {
			t = Triangulo.get(codigo);
			t.setColor(color);
			t.setFechaRegistro(fechaF);
			t.setPseCmCuadrado(peso);
			t.setAltura(altura);
			t.setBase(base);
		}else if (nfigura.equals("rectangulo")) {
			r = Rectangulo.get(codigo);
			r.setColor(color);
			r.setFechaRegistro(fechaF);
			r.setPseCmCuadrado(peso);
			r.setAltura(altura);
			r.setBase(base);
		}
		
		
		
		
	}
	public static void modificarCuadrado(String codigo) {
		
		Cuadrado c = Cuadrados.get(codigo);
		
		System.out.println("Nuevo valor del color:");
		Color color = Color.valueOf(sc.nextLine().toUpperCase());
		System.out.println("Nueva fecha a registrar:");
		String fecha = sc.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime fechaF = LocalDateTime.parse(fecha, formatter);
		System.out.println("Nuevo peso por cm cuadrados:");
		Float peso = Float.valueOf(sc.nextLine());
		System.out.println("Nuevo valor del lado:");
		Float lado = Float.valueOf(sc.nextLine());
		
		c.setColor(color);
		c.setFechaRegistro(fechaF);
		c.setPseCmCuadrado(peso);
		c.setLado(lado);
		
	}
	
	public static void crearFigura(int op) {
		
		System.out.println("Introduce el codigo de la figura a crear:");
		String codigo = sc.nextLine();
		
		if (Triangulo.containsKey(codigo) || Cuadrados.containsKey(codigo) || Rectangulo.containsKey(codigo) || Circulo.containsKey(codigo)) {
		
			System.out.println("Ya existe una figura con código " + codigo);
		}else {
			if (op == 1) {
				crearCuadrado(codigo);
			
			}else if (op == 2) {
				crearTriangulo(codigo);
				
			}else if (op == 3) {
				crearRectangulo(codigo);
			
			}else if (op == 4) {
				crearCirculo(codigo);
			
			}else {
			System.out.println("Opcio no valida, volviendo al menu principal...");
			return;
			}
		}
		
	}
	
	public static void crearRectangulo(String codigo) {
		
		System.out.println("Introduce el color:");
		Color color = Color.valueOf(sc.nextLine().toUpperCase());
		System.out.println("Introduce la fecha en el siguiente formato (dd/mm/yyyy hh:mm):");
		String fecha = sc.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime fechaF = LocalDateTime.parse(fecha, formatter);
		System.out.println("Introduce su peso por cm cuadrados:");
		Float pCm2 = Float.valueOf(sc.nextLine());
		System.out.println("Introduce el valor de la base:");
		Float base = Float.valueOf(sc.nextLine());
		System.out.println("Introduce el valor de la altura:");
		Float altura = Float.valueOf(sc.nextLine());
		
		Rectangulo t = new Rectangulo(codigo, color, fechaF, pCm2, base, altura);
		Rectangulo.put(codigo, t);
		
	}
	
	public static void crearCirculo(String codigo) {
		
		System.out.println("Introduce el color:");
		Color color = Color.valueOf(sc.nextLine().toUpperCase());
		System.out.println("Introduce la fecha en el siguiente formato (dd/mm/yyyy hh:mm):");
		String fecha = sc.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime fechaF = LocalDateTime.parse(fecha, formatter);
		System.out.println("Introduce su peso por cm cuadrados:");
		Float pCm2 = Float.valueOf(sc.nextLine());
		System.out.println("Introduce el valor de radio:");
		Float radio = Float.valueOf(sc.nextLine());
		
		Circulo c = new Circulo(codigo, color, fechaF, pCm2, radio);
		Circulo.put(codigo, c);
		
	}
	
	public static void crearTriangulo(String codigo) {
		
		System.out.println("Introduce el color:");
		Color color = Color.valueOf(sc.nextLine().toUpperCase());
		System.out.println("Introduce la fecha en el siguiente formato (dd/mm/yyyy hh:mm):");
		String fecha = sc.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime fechaF = LocalDateTime.parse(fecha, formatter);
		System.out.println("Introduce su peso por cm cuadrados:");
		Float pCm2 = Float.valueOf(sc.nextLine());
		System.out.println("Introduce el valor de la base:");
		Float base = Float.valueOf(sc.nextLine());
		System.out.println("Introduce el valor de la altura:");
		Float altura = Float.valueOf(sc.nextLine());
		
		Triangulo t = new Triangulo(codigo, color, fechaF, pCm2, base, altura);
		Triangulo.put(codigo, t);
		
	}
	
	public static void crearCuadrado(String codigo) {
		
		System.out.println("Introduce el color:");
		Color color = Color.valueOf(sc.nextLine().toUpperCase());
		System.out.println("Introduce la fecha en el siguiente formato (dd/mm/yyyy hh:mm):");
		String fecha = sc.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime fechaF = LocalDateTime.parse(fecha, formatter);
		System.out.println("Introduce su peso por cm cuadrados:");
		Float pCm2 = Float.valueOf(sc.nextLine());
		System.out.println("Introduce el valor de lado:");
		Float lado = Float.valueOf(sc.nextLine());
		
		Cuadrado c = new Cuadrado(codigo, color, fechaF, pCm2, lado);
		Cuadrados.put(codigo, c);
		
	}
	
	
	
	public static void procesarFichero() {
		
		try {
			BufferedReader leer = new BufferedReader(new FileReader("resources/inventario.txt"));
			String linea = leer.readLine();
			while (linea!=null) {
				String [] partes = linea.split("#");
				if (partes[0].equalsIgnoreCase("CUADRADO")) {
					String pcodigo[] = partes[1].split(";");
					String pcolor [] = partes[2].split(";");
					String pfecha [] = partes[3].split(";");
					String ppeso [] = partes[4].split(";");
					String plado [] = partes[5].split(";");
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
					LocalDateTime fechaF = LocalDateTime.parse(pfecha[1], formatter);
					Cuadrado c = new Cuadrado(pcodigo[1], Color.valueOf(pcolor[1]), fechaF, Float.valueOf(ppeso[1]), Float.valueOf(plado[1]));
					Cuadrados.put(pcodigo[1], c);
				}else if (partes[0].equalsIgnoreCase("CÍRCULO")) {
					String pcodigo[] = partes[1].split(";");
					String pcolor [] = partes[2].split(";");
					String pfecha [] = partes[3].split(";");
					String ppeso [] = partes[4].split(";");
					String pradio [] = partes[5].split(";");
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
					LocalDateTime fechaF = LocalDateTime.parse(pfecha[1], formatter);
					Circulo c = new Circulo(pcodigo[1], Color.valueOf(pcolor[1]), fechaF, Float.valueOf(ppeso[1]), Float.valueOf(pradio[1]));
					Circulo.put(pcodigo[1], c);
				}else if (partes[0].equalsIgnoreCase("RECTÁNGULO")) {
					String pcodigo[] = partes[1].split(";");
					String pcolor [] = partes[2].split(";");
					String pfecha [] = partes[3].split(";");
					String ppeso [] = partes[4].split(";");
					String pbase [] = partes[5].split(";");
					String palt [] = partes[6].split(";");
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
					LocalDateTime fechaF = LocalDateTime.parse(pfecha[1], formatter);
					Rectangulo r = new Rectangulo(pcodigo[1], Color.valueOf(pcolor[1]), fechaF, Float.valueOf(ppeso[1]), Float.valueOf(pbase[1]), Float.valueOf(palt[1]));
					Rectangulo.put(pcodigo[1], r);
				}else if (partes[0].equalsIgnoreCase("TRIÁNGULO")) {
					String pcodigo[] = partes[1].split(";");
					String pcolor [] = partes[2].split(";");
					String pfecha [] = partes[3].split(";");
					String ppeso [] = partes[4].split(";");
					String pbase [] = partes[5].split(";");
					String palt [] = partes[6].split(";");
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
					LocalDateTime fechaF = LocalDateTime.parse(pfecha[1], formatter);
					Triangulo T = new Triangulo(pcodigo[1], Color.valueOf(pcolor[1]), fechaF, Float.valueOf(ppeso[1]), Float.valueOf(pbase[1]), Float.valueOf(palt[1]));
					Triangulo.put(pcodigo[1], T);
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
