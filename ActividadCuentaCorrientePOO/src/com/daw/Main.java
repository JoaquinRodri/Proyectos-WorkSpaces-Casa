package com.daw;

public class Main {

	public static void main(String[] args) {
		
		Cuenta c1 = new Cuenta("Joaquin Rodriguez Rodriguez");
		
		Cuenta c2 = new Cuenta("Fernando Torrijas", 300.8);
		
		c1.ingresar(120);
		c2.retirar(50);
		
		System.out.println(c1);
		System.out.println(c2);

	}

}
