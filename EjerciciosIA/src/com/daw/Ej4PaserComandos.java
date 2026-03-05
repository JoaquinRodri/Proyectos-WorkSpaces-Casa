package com.daw;

import java.util.Arrays;

public class Ej4PaserComandos {

	public static void main(String[] args) {
		
		String comando = "BUSCAR.categoria=\"Video Juegos\";min= 10 ;max=50;query=\"a=b=c\";";
		
		String entrada[] = comando.split("\\.");
		System.out.println(Arrays.toString(entrada));
		
		int posicion = comando.indexOf(".");
		String parteP = comando.substring(0, posicion);
		System.out.println(parteP);
		String parteF = comando.substring(posicion+1);
		
		
		parteF = parteF.replace("\"", "");
		
		String [] paresSeparados = parteF.split(";");
		
		for (int i = 0; i < paresSeparados.length; i++) {
			int posicion1 = paresSeparados[i].indexOf("=");
			String clave = paresSeparados[i].substring(0,posicion1);
			String valor = paresSeparados[i].substring(posicion1+1);
			System.out.println(clave+" -> "+valor);
			
		}
		
		

	}

}
