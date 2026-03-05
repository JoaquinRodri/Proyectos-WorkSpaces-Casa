package com.daw;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca su edad:");
		Integer edad = Integer.valueOf(sc.nextLine());
		System.out.println("Introduzca el numero de personas que se inscriben:");
		Integer n_p_inscritas = Integer.valueOf(sc.nextLine());
		
		try {
			inscribirEstudiante(edad, n_p_inscritas);
			System.out.println("Inscrito correctamente.");
		} catch (EdadInsuficienteException e) {
			System.out.println("Error: "+e.getMessage());
		} catch (CursoLlenoException e) {
			System.out.println("Error: "+e.getMessage());
		}
		

	}
	
	public static void inscribirEstudiante(int edad, int inscritos) throws EdadInsuficienteException, CursoLlenoException {
		
		if (edad<18) {
			throw new EdadInsuficienteException("El estudiante debe tener al menos 18 años para poder inscribirse.");
		}else if (inscritos <0 || inscritos >= 5) {
			throw new CursoLlenoException("Ya no hay plazas disponibles para el curso.");
		}
		
	}

}
