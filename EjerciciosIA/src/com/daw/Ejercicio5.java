package com.daw;

public class Ejercicio5 {

	public static void main(String[] args) {

		/*
		 * Ejercicio 5: Formateo de Rutas de Archivos Se tiene una ruta de archivo en
		 * formato Unix (separador /) y se necesita transformarla a formato Windows
		 * (separador \). Ejemplo: /home/usuario/documento.txt. 
		 * 
		 * a) Reemplazo y
		 * Normalización (replace(), toLowerCase()): Reemplaza todas las barras
		 * inclinadas (/) por barras invertidas (\) para simular la ruta de Windows.
		 * Convierte toda la ruta a minúsculas. 
		 * 
		 * b) Extracción de Nombre de Archivo
		 * (substring(), lastIndexOf()): Utilizando lastIndexOf('\'), extrae e imprime
		 * solo el nombre del archivo con su extensión (ej: documento.txt). 
		 * 
		 * c)
		 * Verificación de Tipo (endsWith()): Verifica e imprime si el nombre del
		 * archivo termina con la extensión .java (esto determinaría si es un archivo
		 * fuente de Java). 
		 * 
		 * d) Diferencia de Longitud (length(), replace()): Reemplaza
		 * el punto (.) por un espacio en blanco (' ') en el nombre del archivo. Calcula
		 * e imprime la diferencia de longitud entre el nombre del archivo original y el
		 * nombre del archivo modificado (que ahora tiene un espacio en
		 * lugar de un punto).
		 */
		
		String ruta = "/home/usuario/documento.txt";
		ruta = ruta.trim();
		
		String copiaRuta = ruta;
		
		//A
		copiaRuta = copiaRuta.replace('/', '\\');
		copiaRuta = copiaRuta.toLowerCase();
		System.out.println(copiaRuta);
		
		//B
		String nombreArchivo = copiaRuta.substring(copiaRuta.lastIndexOf('\\')+1, copiaRuta.length());
		System.out.println(nombreArchivo);
		System.out.println();
		//C
		if (copiaRuta.endsWith(".java")) {
			System.out.println("Es un fichero java.");
		}else {
			String extension = copiaRuta.substring(copiaRuta.lastIndexOf('.'), copiaRuta.length());
			System.out.println("Es un fichero "+extension);
		}
		
		//D
		String nombreArchivoSpace = nombreArchivo.replace('.', ' ');
		System.out.println("La diferencia entre los archivos: "+Math.abs((nombreArchivo.length()-nombreArchivoSpace.length())) );
		
	}

}
