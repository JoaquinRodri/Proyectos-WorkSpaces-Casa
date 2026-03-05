package com.daw;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		int numLineas = 0;
		int numCaracteres = 0;
		int numpalabras = 0;
		
		try {
			BufferedReader leer = new BufferedReader(new FileReader("resource/carta.txt"));
			String linea = leer.readLine();
			while (linea!=null) {
				numLineas++;
				
				numCaracteres+=linea.length();
				
				if (!linea.isEmpty()) {
					numpalabras += linea.split(" ").length;
				}
				linea = leer.readLine();
				
			}
			leer.close();
			System.out.println("Numero de lineas: "+numLineas);
			System.out.println("Numero de palabras: "+numpalabras);
			System.out.println("Numero de caracteres: "+numCaracteres);
			
			
			
		} catch (FileNotFoundException e) {
			System.out.println("El fichero no existe o ha habido un porble al intentar leer el fichero.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
