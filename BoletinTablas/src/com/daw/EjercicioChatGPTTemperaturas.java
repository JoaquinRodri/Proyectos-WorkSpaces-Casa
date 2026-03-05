package com.daw;


import java.util.Scanner;

public class EjercicioChatGPTTemperaturas {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int [] temperaturas = new int [7];
		System.out.println("Inserta las temperaturas de esta semana");
		
		for (int i = 0; i < temperaturas.length; i++) {
			temperaturas[i]=sc.nextInt();;
		}
		
		double media = tempMediaSemana(temperaturas);
		System.out.println("La temperatura media de la semana es: "+(float)media);
		
		//temperatura mas alta y baja de la semana.
		tempMasAltaBaja(temperaturas);
		
		//numeros de dias por encima de la media.
		tempEncimaMedia(temperaturas, (float)media);
		
		//numero de dias por debajo de 10 grados.
		tempPorDebajoDiez(temperaturas);
		
		//Mirar si a habido ola de calor, tres dias seguidos con temperaturas mayores a 35 grados
		if (tempMayX(temperaturas)) {
			System.out.println("Ha habido ola de calor");
		} else {
			System.out.println("No ha habido ola de calor");
		}
		
		
		sc.close();

	}
	static boolean tempMayX(int []v) {
		
		for (int i = 1; i < v.length-2; i++) {
			if (v[i]>35 && v[i-1]>35 && v[i+1]>35) {
				return true;
			}
			
		}
		
		return false;
	}
	
	static void tempPorDebajoDiez(int[]v) {
		int numPorDebajoDiez = 0;
		for (int i = 0; i < v.length; i++) {
			if (v[i]<10) {
				numPorDebajoDiez++;
			}
		}
		
		System.out.println("Los dias que han estado con temperaturas por debao de 10 grados son "+numPorDebajoDiez+" dias.");
		
	}
	
	static void tempEncimaMedia(int [] v, float media) {
		int numDiasPorEncima = 0;
		for (int i = 0; i < v.length; i++) {
			if (v[i]>media) {
				numDiasPorEncima++;
			}
		}
		
		System.out.println("Los dias que han estado con temperaturas por encima de la media son "+numDiasPorEncima+" dias.");
		
	}
	
	static void tempMasAltaBaja(int[]v) {
		int tempMax = v[0];
		int tempMin = v[0];
		for (int i = 0; i < v.length; i++) {
			if (v[i]>tempMax) {
				tempMax=v[i];
			} else if (v[i]<tempMin) {
				tempMin=v[i];
			}
		}
		
		System.out.println("La temperatura mas alta es: "+tempMax+" grados");
		System.out.println("La temperatura mas baja es: "+tempMin+" grados");
		
	}
	
	static double tempMediaSemana(int[]v) {
		int sumaTotal = 0;
		for (int i = 0; i < v.length; i++) {
			sumaTotal+=v[i];
		}
		double media = (double)sumaTotal/v.length; 
		
		return media;
	}

}
