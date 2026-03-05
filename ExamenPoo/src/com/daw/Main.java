package com.daw;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		Biblioteca b = new Biblioteca();
		
		Libro l1 = new Libro("L01", "El Quijote", "Cervantes", 1605, true, "123", 500, Formato.NORMAL);
		Libro l2 = new Libro("L02", "Cien Años", "Marquez", 1967, true, "456", 400, Formato.COLECCIONISTA);
		Libro l3 = new Libro("L03", "Harry Potter", "Rowling", 1997, true, "789", 300, Formato.BOLSILLO);
		Revista r1 = new Revista("R01", "NatGeo", "Varios", 2023, true, 500, Mes.ENERO, 12);
		Revista r2 = new Revista("R02", "PC Hoy", "Varios", 2024, true, 120, Mes.FEBRERO, 16);
		
		b.agregarMaterial(l2);
		b.agregarMaterial(l1);
		b.agregarMaterial(l3);
		b.agregarMaterial(r1);
		b.agregarMaterial(r2);
		
		
		
		Usuario u1 = new Usuario("1", "Joaquin", "12345678B", "joaquin@example.com");
		Usuario u2 = new Usuario("2", "Manuel", "87654321N", "manuel@example.com");
		b.registrarUsuario(u1);
		b.registrarUsuario(u2);
		
		System.out.println(l1);
		l1.prestar(u1);
		r1.prestar(u2);
		
		System.out.println(l1);
		System.out.println(r1);
		
		l1.devolver();
		r1.devolver();
		u1.getMaterialesPrestados().remove(l1);
		
		
		System.out.println(l1);
		System.out.println(r1);
		
		List<Material> aux = b.getMateriales();
		Collections.sort(aux);
		System.out.println("Ordenado por Titulo:");
		
		System.out.println(aux);
		System.out.println();
		
		
		System.out.println("Ordenador por Año:");
		aux = b.obtenerMaterialesOrdenados(new ComparadorPorAnio());
		System.out.println(aux);
		System.out.println();
		
		System.out.println("Ordenado por autor y titulo:");
		aux = b.obtenerMaterialesOrdenados(new ComparadorPorAutorYTitulo());
		System.out.println(aux);
		
		System.out.println();
		b.generarReporte();
	}

}
