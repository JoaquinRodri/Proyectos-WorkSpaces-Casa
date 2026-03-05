package com.daw;




public class Ejercicio2ChatGpt {

	public static void main(String[] args) {

		int [] vector = {1,6,1,7,5,5,7,1};
		int [][] numRep = new int [vector.length][2];
		
		for (int i = 0; i < vector.length; i++) {
			int cont = 0;
			for (int j = 0; j < vector.length; j++) {
				if (vector[i]==vector[j]) {
					if (i>j) {
						break;
					}else {
						cont++;
					}
				}
			}
			if (cont!=0) {
				System.out.println("el numero "+vector[i]+" aparece "+cont+" veces.");
				numRep[i][1]= cont;
				numRep[i][0]= vector[i];
			}
			
		}
		
		int contMax = 0;
		int numero = 0;
		for (int i = 0; i < numRep.length; i++) {
			if (numRep[i][1]>contMax) {
				contMax = numRep[i][1];
				numero = numRep[i][0];
			}
		}
		
		System.out.println("El numero que mas se repite es "+numero+", "+contMax+" veces.");
		
		
		
		
		

	}

}
