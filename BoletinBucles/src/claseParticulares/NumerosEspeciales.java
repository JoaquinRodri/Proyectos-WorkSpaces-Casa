package claseParticulares;

import java.util.Scanner;

public class NumerosEspeciales {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un numero:");
		int num = sc.nextInt();
		
		for (int i = 2; i <= num; i++) {
			boolean divisible = false;
			boolean primo = true;
			for (int j = 2; j <= num; j++) {
				/*if (i%3==0 && i%5==0) {
					
				} else if (i%3==0) {
					divisible = true;
				} else if (i%5==0) {
					divisible = true;
				}*/
				if ((i%3==0 || i%5==0) && !(i%15==0)) {
					divisible=true;
				}
				if (i!=j) {
					if (i%j==0) {
						primo=false;
					}
				}
			}
			if (divisible) {
				if (i==3 || i==5) {
					
				} else {
				System.out.print(i+" ");
					}
				}
			if (primo) {
				System.out.print("["+i+"] ");
			}
				
			}
		sc.close();
		}

		
	}


