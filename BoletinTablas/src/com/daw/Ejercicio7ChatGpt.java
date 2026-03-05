package com.daw;

public class Ejercicio7ChatGpt {

	public static void main(String[] args) {

		int [] vector = {1,6,1,7,5};
		int numeroC = 1;
		int indice = 0;
		for (int i = 0; i < vector.length; i++) {
			if (numeroC!=vector[i]) {
				vector[indice]=vector[i];
				indice++;
			}

		}

		for (int i = indice; i < vector.length; i++) {
			vector[i]=-1;
		}

		for (int i = 0; i < vector.length; i++) {
			System.out.print(vector[i]);
		}

	}

}
