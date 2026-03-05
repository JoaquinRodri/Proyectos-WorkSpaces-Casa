package com.daw;

import java.util.Scanner;

public class Ejercicio16 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Por favor, introduzca el dia:");
		int dias = sc.nextInt();

		System.out.println("Por favor, introduzca el mes:");
		int mes = sc.nextInt();

		System.out.println("Por favor, introduzca el años:");
		int anio = sc.nextInt();

		switch (mes) {
		case 4, 6, 9, 11:
			if (dias<=30 && dias>0) {
				System.out.println("Fecha correcta!!!");
			} else {
				System.out.println("La fecha es incorrecta. no sabes en que dia vives!!!");
			}
			break;
		case 1,3,5,7,8,10,12:
			if (dias<=31 && dias>0) {
				System.out.println("Fecha correcta!!!");
			} else {
				System.out.println("La fecha es incorrecta. no sabes en que dia vives!!!");
			}
			break;
		case 2:
			if (dias<=28 && dias>0) {
				System.out.println("Fecha correcta!!!");
			} else {
				System.out.println("La fecha es incorrecta. no sabes en que dia vives!!!");
			}
			break;

		default:
			System.out.println("La fecha es incorrecta. aprende los dias del mes mejo!!!");
			break;
		}

		sc.close();
	}

}
