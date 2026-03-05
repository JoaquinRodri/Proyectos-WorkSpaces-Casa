package com.daw;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in);
//		Set<String> lista = new TreeSet<>();
//		
//		System.out.println("Introduce una palabra:");
//		String palabra = sc.nextLine().trim();
//		
//		while (!palabra.equalsIgnoreCase("fin")) {
//			lista.add(palabra);
//			System.out.println("Vuelva a introducir una palabra");
//			palabra = sc.nextLine().trim();
//		}
//		
//		System.out.println(lista);
		
//		List<String> nombres = new ArrayList<String>();
//		nombres.add("joaquin");
//		nombres.add("alejandro");
//		nombres.add("marina");
//		nombres.add("joaquin");
//		nombres.add("alejandro");
//		
//		List<String> nSinRep = eliminaRepetidos(nombres);
//		System.out.println(nSinRep);
		
		Set<Integer> c1 = new HashSet<Integer>();
		Set<Integer> c2 = new HashSet<Integer>();
		
		c1.add(1);
		c1.add(2);
		c1.add(3);
		c2.add(3);
		c2.add(4);
		c2.add(5);
		
		System.out.println("Union de dos conjuntos: "+union(c1, c2));
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("diferencia de dos conjuntos: "+diferencia(c1, c2));
		System.out.println("-----------------------------------------------------------------------------------------");
		List<Integer> l1 = new ArrayList<Integer>();
		List<Integer> l2 = new ArrayList<Integer>();
		
		l1.add(1);
		l1.add(2);
		l1.add(3);
		l2.add(3);
		l2.add(4);
		l2.add(5);
		
		System.out.println("Fusion de dos listas ordenadas: "+fusion(l1,l2));

	}
	public static List<Object> fusion(List<? extends Object> c1, List<? extends Object> c2){
		List<Object> resul = new ArrayList<Object>(c1);
		resul.addAll(c2);
		return resul;
	}
	
	public static Set<Object> diferencia(Set<? extends Object> c1, Set<? extends Object> c2){
		Set<Object> resul = new HashSet<Object>(c1);
		resul.removeAll(c2);
		return resul;
	}
	
	public static Set<Object> union(Set<? extends Object> c1, Set<? extends Object> c2){
		Set<Object> resul = new HashSet<Object>(c1);
		resul.addAll(c2);
		return resul;
	}
	
	public static List eliminaRepetidos(List m){
		Set<String> sinRep = new LinkedHashSet<String>(m);
		List<String> aux = new ArrayList<String>(sinRep);
		
		return aux;
	}

}
