package com.daw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		
		Map<Integer, Alumno> alumnado = new HashMap<Integer, Alumno>();
		
		try {
			BufferedReader leer = new BufferedReader(new FileReader("resources/alumnos.txt"));
			String linea = leer.readLine();
			while (linea!=null) {
				String [] partes = linea.split("-");
				Alumno alumno = new Alumno(Integer.valueOf(partes[0]), partes[1], partes[2]);
				alumnado.put(alumno.getCodigo(), alumno);
				linea = leer.readLine();
				
			}
			
			
			
			leer.close();
		} catch (FileNotFoundException e) {
			System.out.println("El archivo no existe o no se puede leer.");
		} catch (IOException e) {
			System.out.println("No se pudo leer el fichero.");
		}
		
		try {
			BufferedReader leer = new BufferedReader(new FileReader("resources/notas.txt"));
			String linea = leer.readLine();
			while (linea!=null) {
				String [] partes = linea.split("-");
				Integer codigo = Integer.valueOf(partes[0]);
				Alumno alum = alumnado.get(codigo);
				alum.addNota(partes[1], Float.valueOf(partes[2]));
				linea = leer.readLine();
				
			}
			
			primerApartado(alumnado);
			System.out.println();
			segundoApartado();
			System.out.println();
			tercerApartado(alumnado);
			System.out.println();
			cuartoApartado(alumnado);
			System.out.println();
			
			System.out.println("Archivo creado exitosamente.");
			System.out.println("Contenido copiado al fichero nuevo_alumnos_notas.txt");
			leer.close();
		} catch (FileNotFoundException e) {
			System.out.println("El archivo no existe o no se puede leer.");
		} catch (IOException e) {
			System.out.println("No se pudo leer el fichero o escribir el fichero.");
		}
		
		

	}
	public static void primerApartado(Map<Integer, Alumno> alumnado) throws IOException {
		for (Alumno a : alumnado.values()) {
		System.out.println(a);	
			
		}
		
		
			BufferedWriter escribir = new BufferedWriter(new FileWriter("resources/nuevo_alumnos_notas.txt"));
			for (Alumno a : alumnado.values()) {
				escribir.write(a.toString());
				escribir.newLine();
					
				}
			escribir.close();
		
		
		
	}
	
	public static void segundoApartado() throws IOException {
		Map<String, Integer> aprobado = new HashMap<String, Integer>();
		Map<String, Integer> sobre = new HashMap<String, Integer>();
		
			
			BufferedReader leer = new BufferedReader(new FileReader("resources/notas.txt"));
			String linea = leer.readLine();
			while (linea!=null) {
				String [] partes = linea.split("-");
				String asignatura = partes[1];
				Float nota = Float.valueOf(partes[2]);
				if (aprobado.get(asignatura)==null) {
					aprobado.put(asignatura, 0);
				}
				if (nota>5) {
					aprobado.put(asignatura, aprobado.get(asignatura)+1);
				}
				if (sobre.get(asignatura)==null) {
					sobre.put(asignatura, 0);
				}
				if (nota>9) {
					sobre.put(asignatura, sobre.get(asignatura)+1);
				}
				linea = leer.readLine();
				
			}
			
			List<String> asignaturas = new ArrayList<String>();
			asignaturas.addAll(aprobado.keySet());
			Collections.sort(asignaturas);
			BufferedWriter escribir = new BufferedWriter(new FileWriter("resources/nuevo_alumnos_notas.txt", true));
			
			for (String asig : asignaturas) {
				escribir.write(asig+" --> aprobados: "+ aprobado.get(asig)+" Sobresalientes: "+sobre.get(asig));
				escribir.newLine();
			}
			
			escribir.newLine();
			
			leer.close();
			escribir.close();
			
			for (String asig : asignaturas) {
				System.out.println(asig+" --> aprobados: "+ aprobado.get(asig)+" Sobresalientes: "+sobre.get(asig));
			}
		
		
		
	}
	
	public static void tercerApartado(Map<Integer, Alumno> alumnado) throws IOException {
		
		List<String> aprob = new ArrayList<String>();
		
			
			BufferedReader leer = new BufferedReader(new FileReader("resources/alumnos.txt"));
			String linea = leer.readLine();
			while (linea!=null) {
					String [] partes = linea.split("-");
					Alumno a = alumnado.get(Integer.valueOf(partes[0]));
					boolean suspenso = false;
					Map<String, Float> notas = a.getAsignaturas();
					for (Float n : notas.values()) {
						if (n<5) {
							suspenso = true;
							break;
						}
					}
					if (suspenso == false) {
						aprob.add(linea);
					}
				
				
				linea = leer.readLine();
				
			}
			
			BufferedWriter escribir = new BufferedWriter(new FileWriter("resources/nuevo_alumnos_notas.txt", true));
			escribir.write("Lista de Alumnos con todas las asignaturas aprobadas");
			escribir.newLine();
			for (String alum : aprob) {
				escribir.write(alum+",");
				escribir.newLine();
			}
			
			escribir.newLine();
			
			leer.close();
			escribir.close();
			System.out.println("Lista de Alumnos con todas las asignaturas aprobadas");
			for (String alum : aprob) {
				System.out.println(alum+",");
			}

		
		
	}
	
	public static void cuartoApartado(Map<Integer, Alumno> alumnado) throws IOException {
		
		List<String> suspensos = new ArrayList<String>();
		
			
			BufferedReader leer = new BufferedReader(new FileReader("resources/alumnos.txt"));
			String linea = leer.readLine();
			while (linea!=null) {
					String [] partes = linea.split("-");
					Alumno a = alumnado.get(Integer.valueOf(partes[0]));
					boolean aprobado = false;
					Map<String, Float> notas = a.getAsignaturas();
					for (Float n : notas.values()) {
						if (n>=5) {
							aprobado = true;
							break;
						}
					}
					if (!aprobado) {
						suspensos.add(linea);
					}
				
				
				linea = leer.readLine();
				
			}
			
			BufferedWriter escribir = new BufferedWriter(new FileWriter("resources/nuevo_alumnos_notas.txt", true));
			escribir.write("Lista de Alumnos con todas las asignaturas suspensas");
			escribir.newLine();
			for (String alum : suspensos) {
				escribir.write(alum);
				escribir.newLine();
			}
			
			escribir.newLine();
			
			leer.close();
			escribir.close();
		
		
		System.out.println("Lista de Alumnos con todas las asignaturas suspensas");
		for (String alum : suspensos) {
			System.out.println(alum);
		}
	}

}
