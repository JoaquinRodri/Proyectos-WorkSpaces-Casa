package com.daw;

import java.util.Scanner;

public class Ejercicio17 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Por favor, introduzca el dia:");
		int dias = sc.nextInt();

		System.out.println("Por favor, introduzca el mes:");
		int mes = sc.nextInt();

		System.out.println("Por favor, introduzca el años:");
		int anio = sc.nextInt();

		if (dias<30) {
			dias+=1;
		} else if (dias==30 && mes<12) {
			dias = 1;
			mes+=1;
		} else if(dias==30 && mes==12) {
			dias = 1;
			mes = 1;
			anio+=1;
		}
		
		System.out.println("La fecha siguiente es: "+dias+"/"+mes+"/"+anio);

		sc.close();
	}

}
