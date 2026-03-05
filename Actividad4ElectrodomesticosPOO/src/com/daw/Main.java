package com.daw;

public class Main {

	public static void main(String[] args) {
		
		Electrodomestico[] electrodomesticos = new Electrodomestico[10];
		electrodomesticos[0] = new Electrodomestico(150, "Blanco", 'A', 20);
        electrodomesticos[1] = new Lavadora(20, "Gris", 'B', 30, 40);
        electrodomesticos[2] = new Television(340, "Negro", 'A', 15, 40, true);
        electrodomesticos[3] = new Electrodomestico(250, "Rojo", 'C', 25);
        electrodomesticos[4] = new Lavadora(350, "Blanco", 'A', 40, 60);
        electrodomesticos[5] = new Television(600, "Negro", 'B', 20, 55, false);
        electrodomesticos[6] = new Electrodomestico(180, "Azul", 'D', 18);
        electrodomesticos[7] = new Lavadora(220, "Gris", 'C', 35, 50);
        electrodomesticos[8] = new Television(450, "Negro", 'A', 22, 40, true);
        electrodomesticos[9] = new Electrodomestico(320, "Blanco", 'B', 28);
		
		float totalLavadoras = 0;
		float totalTv = 0;
		float totalElectrodomesticos = 0;
		
		String lavadoras = "Lavadoras: \n";
		String televisor = "Televisores: \n";
		int conLav = 0;
		int conTv = 0;
		
		
		for (int i = 0; i < electrodomesticos.length; i++) {
			electrodomesticos[i].precioFinal();
			
			totalElectrodomesticos += electrodomesticos[i].precioFinal();
			
			if (electrodomesticos[i] instanceof Lavadora) {
				totalLavadoras += electrodomesticos[i].precioFinal(); 
				conLav++;
				lavadoras += "lavadora "+conLav+": "+electrodomesticos[i].precioFinal()+" €\n";
			}
			
			if (electrodomesticos[i] instanceof Television) {
				totalTv += electrodomesticos[i].precioFinal(); 
				conTv++;
				televisor += "televisor "+conTv+": "+electrodomesticos[i].precioFinal()+" €\n";
			}
		}
		
		System.out.println(lavadoras);
		System.out.println(televisor);
		
		System.out.println("Precio total de Electrodomesticos: " + totalElectrodomesticos);
        System.out.println("Precio total de Lavadoras: " + totalLavadoras);
        System.out.println("Precio total de Televisiones: " + totalTv);

	}

}
