package com.daw;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce primer numero");
		int n1 = sc.nextInt();

		System.out.println("Introduce segundo numero");
		int n2 = sc.nextInt();
	
		n1 = compruebaMayor(n1,n2);
		mostrar(n1);
		
	}

	public static int compruebaMayor(int n,int m) {
			
		// return (n>m) ? n:m;
		
		if(n>m)
		{	
			return n;
		}
		else
		{ 	
			return m;
		}
		
		
	}
	
	public static void mostrar(int num) {
		System.out.println("El numero mayor es: "+num);
	}
	
}
