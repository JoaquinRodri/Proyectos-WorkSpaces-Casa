package videoteca;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

	public static void main(String[] args) {

		Videoteca videoclub = new Videoteca();

		Pelicula p1 = new Pelicula("V001","Blade Runner","Ridley Scott",1982,true,117,Genero.SCIFI);
		Pelicula p2 = new Pelicula("V002","El Padrino","Francis Ford Coppola",1972,true,175,Genero.DRAMA);
		Pelicula p3 = new Pelicula("V003","Mad Max: Fury Road","George Miller",2015,true,120,Genero.ACCION);
		Serie s1 = new Serie("S001","The Office","Greg Daniels",2005,true,9,Plataforma.PRIME);
		Serie s2 = new Serie("S002","Stranger Things","Duffer Brothers",2016,true,4,Plataforma.NETFLIX);
		
		Cliente c1 = new Cliente("C001", "Joaquin", "Joaquin@example.com");
		Cliente c2 = new Cliente("C002", "Manuel", "Manuel@example.com");
		
		videoclub.agregarContenido(p1);
		videoclub.agregarContenido(p2);
		videoclub.agregarContenido(p3);
		videoclub.agregarContenido(s1);
		videoclub.agregarContenido(s2);
		
		try {
			BufferedReader leer = new BufferedReader(new FileReader("resources/clientes.txt"));
			String linea = leer.readLine();
			while (linea!=null) {
				String partes [] = linea.split("-");
				Cliente c = new Cliente(partes[0], partes[1], partes[2]);
				videoclub.registrarCliente(c);
				linea = leer.readLine();
			}
			
			leer.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		videoclub.procesarMovimiento(c1.getId(), p1.getCodigo(), "ALQUILAR");
		videoclub.procesarMovimiento(c1.getId(), s1.getCodigo(), "ALQUILAR");
		
		
		videoclub.procesarMovimiento(c1.getId(), p1.getCodigo(), "DEVOLVER");
		videoclub.procesarMovimiento(c1.getId(), s1.getCodigo(), "DEVOLVER");
		
		System.out.println("----------------------------------------------------------------");
		System.out.println("--------------Contenidos por orden natural----------------------");
		System.out.println("----------------------------------------------------------------");
		for (Contenido c : videoclub.getContenidos()) {
			System.out.println(c);
			System.out.println();
		}
		System.out.println("----------------------------------------------------------------");
		System.out.println("------------------Contenidos por año----------------------------");
		System.out.println("----------------------------------------------------------------");
		for (Contenido c : videoclub.obtenerContenidosOrdenador(new ComparadorPorAnio())) {
			System.out.println(c);
			System.out.println();
		}
		
		System.out.println("----------------------------------------------------------------");
		System.out.println("------------Contenidos por director y titulo--------------------");
		System.out.println("----------------------------------------------------------------");
		for (Contenido c : videoclub.obtenerContenidosOrdenador(new ComparadorPorDirectorYTitulo())) {
			System.out.println(c);
			System.out.println();
		}
		
		
		
	}

}
