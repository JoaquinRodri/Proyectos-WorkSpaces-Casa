package claseParticulares;

import java.util.Scanner;

public class PatronNumEscalonado {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un numero:");
		int num = sc.nextInt();
		
		if (num % 2 == 0) {
			for (int i = 1; i <= num; i++) {
				String fila = "";
				for (int j = 1; j <= num-i+1; j++) {
					fila+=j;
				}
				System.out.println(fila);
			}
		} else {
			for (int i = 1; i <= num; i++) {
				String fila = "";
				for (int j = 1; j <= i; j++) {
					fila+=j;
				}
				System.out.println(fila);
			}
		}
		
		sc.close();
		
		
		
		

	}

}
