package com.daw;


import java.util.Scanner;

public class EjercicioChatGPTNotas {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] notas = new int[10];
		int opcion = 0;
		
		System.out.println("Introduce las "+notas.length+" notas.");

		for (int i = 0; i < notas.length; i++) {
			do {
				int nota = sc.nextInt();
				if (nota < 0 || nota > 10) {
					System.out.println("Valor de nota no valido debe estar entre 0 y 10.");
				} else {
					notas[i] = nota;
					break;
				}
			} while (true);
		}

		do {
			System.out.println("1. Media de las notas.");
			System.out.println("2. Nota maxima y minima.");
			System.out.println("3. Porcentaje de aprobados y suspensos.");
			System.out.println("4. Notas por encima de la media.");
			System.out.println("5. salir.");
			
			do {
				opcion = sc.nextInt();
				if (opcion!=1 && opcion!=2 && opcion!=3 && opcion!=4 && opcion!=5) {
					System.out.println("OPcion no valida.");
				}
			} while (opcion!=1 && opcion!=2 && opcion!=3 && opcion!=4 && opcion!=5);

			switch (opcion) {
			case 1:
				float media = mediaNotas(notas);
				System.out.println("La media de las notas es "+media);
				break;
			case 2:
				int max = notas[0];
				int min = notas[0];
				for (int i = 0; i < notas.length; i++) {
					if (notas[i]>max) {
						max = notas[i];
					} else if (notas[i]<min) {
						min = notas[i];
					}
				}
				System.out.println("La nota maxima es: "+max);
				System.out.println("La nota minima es: "+min);
				
				break;
			case 3:
				int aprobados = 0;
				int suspensos = 0;
				float porAprobado = 0;
				float porSuspenso = 0;
				for (int i = 0; i < notas.length; i++) {
					if (notas[i]>=5) {
						aprobados++;
					}else {
						suspensos++;
					}
				}
				
				porAprobado = (float) aprobados/notas.length*100;
				porSuspenso = (float) suspensos/notas.length*100;
				System.out.println("Porcentaje de aprobados: "+porAprobado);
				System.out.println("Porcentaje de suspensos: "+porSuspenso);
				
				break;
			case 4:
				int cont = 0;
				for (int i = 0; i < notas.length; i++) {
					if (notas[i]>mediaNotas(notas)) {
						cont++;
					}
				}
				System.out.println("El numero de notas que estan por encima de la media son "+cont+" notas.");
				
				break;

			default:
				System.out.println("Saliendoooooo");
				break;
			}

		} while (opcion != 5);
		sc.close();

	}
	static float mediaNotas(int[]notas) {
		float media = 0.0f;
		int sumaT=0;
		for (int i = 0; i < notas.length; i++) {
			sumaT+=notas[i];
		}
		media = (float)sumaT/notas.length;
		return media;
	}

}
