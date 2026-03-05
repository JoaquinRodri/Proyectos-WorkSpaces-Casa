package com.daw;


import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca longitud de la clave");
		int longitud = sc.nextInt();
		
		int claveSecreta [] = new int [longitud];
		
		for (int i = 0; i < claveSecreta.length; i++) {
			claveSecreta[i] = (int) (Math.random()*5)+1;
		}
		
		System.out.println("Intente acertarla");
		//numero del intento.
		int intento = sc.nextInt();
		
		
		boolean acertado = false;
		while (acertado == false) {
			
			// aqui se va a guardar el numero del intento separado.
			int nIntentos [] = new int [longitud];
			
			//funcion que mete los numeros separados en la tabla.
			nIntentos = separaNumeros(nIntentos, intento);
			
			//funcion que mirar los numeros y muestra cual es mayor, menor o igual y devuelve un boleano
			//para saber si a acertado.
			acertado = compararIntentos(claveSecreta, nIntentos);
			
			if (acertado!=true) {
				System.out.println("Intente acertarla de nuevo");
				intento = sc.nextInt();
			} else {
				System.out.println("Enhorabuena has acertado");
			}
			
		}
		sc.close();

	}
	static boolean compararIntentos(int[] claveSecreta, int[] n) {
		boolean acertado = false;
		int contAciertos = 0;
		String cadena = "";
		for (int i = 0; i < n.length; i++) {
			if (n[i]==claveSecreta[i]) {
				contAciertos++;
				cadena+=n[i]+" es igual, ";
			} else if (n[i]>claveSecreta[i]) {
				cadena+=n[i]+" es mayor, ";
			} else {
				cadena+=n[i]+" es menor, ";
			}
		}
		System.out.println(cadena);
		
		if (contAciertos==n.length) {
			acertado = true;
		}
		return acertado;
		
	}
	
	static int[] separaNumeros(int[] nSeparados, int n) {
		int indice = nSeparados.length-1;
		while (n>0) {
			int cifra = n%10;
			nSeparados[indice]=cifra;
			n = n/10;
			indice--;
		
		}
		
		return nSeparados;
	}

}
