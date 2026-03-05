package examenExamen1;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Por favor, seleccione un destino:");
		System.out.println("1-Alemania");
		System.out.println("2-Inglaterra");
		System.out.println("3-Francia");
		System.out.println("4-Portugal");
		int opcion = 0;
		do {
			opcion = sc.nextInt();
			if (opcion < 1 || opcion > 4) {
				System.out.println("Opcion no valida, vuelva a introducirla.");
			}
		} while (opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4);

		System.out.println("Por favor, introduzca el peso del paquete:");
		float pesoPaquete = 0.0f;
		do {
			pesoPaquete = sc.nextFloat();
			if (pesoPaquete < 1) {
				System.out.println("El peso del paquete debe ser positivo.");
			}
		} while (pesoPaquete < 1);
		float resultado = 0;
		float decimal = 0;
		int totalPeso = 0;
		switch (opcion) {
		case 1:
			totalPeso = 0;
			decimal = pesoPaquete%1;
			
			if (decimal>0.0 && pesoPaquete>2.0) {
				totalPeso = (int)pesoPaquete+1;
				System.out.println(totalPeso);
				float pesoAdicional = totalPeso-2; 
				System.out.println(pesoAdicional);
				resultado = 20+((int)pesoAdicional*8);
				
			}else if (pesoPaquete>2.0) {
				int adicional = (int)pesoPaquete-2;
				resultado = 20+(adicional*8);
			} else {
				resultado = 20;
			}
			
			System.out.println("El precio total del envio es: "+resultado+" euros.");
			
			break;
		case 2:
			totalPeso = 0;
			decimal = pesoPaquete%1;
			
			if (decimal>0.0 && pesoPaquete>2.0) {
				totalPeso = (int)pesoPaquete+1;
				
				System.out.println(totalPeso);
				float pesoAdicional = totalPeso-2; 
				System.out.println(pesoAdicional);
				resultado = 18+((int)pesoAdicional*7);
				
			}else if (pesoPaquete>2.0) {
				int adicional = (int)pesoPaquete-2;
				resultado = 18+(adicional*7);
			} else {
				resultado = 18;
			}
			
			System.out.println("El precio total del envio es: "+resultado+" euros.");

			break;
		case 3:
			totalPeso = 0;
			decimal = pesoPaquete%1;
			
			if (decimal>0.0 && pesoPaquete>2.0) {
				totalPeso = (int)pesoPaquete+1;
				System.out.println(totalPeso);
				float pesoAdicional = totalPeso-2; 
				System.out.println(pesoAdicional);
				resultado = 22+((int)pesoAdicional*9);
				
			}else if (pesoPaquete>2.0) {
				int adicional = (int)pesoPaquete-2;
				resultado = 22+(adicional*9);
			} else {
				resultado = 22;
			}
			
			System.out.println("El precio total del envio es: "+resultado+" euros.");

			break;
		case 4:
			totalPeso = 0;
			decimal = pesoPaquete%1;
			
			if (decimal>0.0 && pesoPaquete>2.0) {
				totalPeso = (int)pesoPaquete+1;
				System.out.println(totalPeso);
				float pesoAdicional = totalPeso-2; 
				System.out.println(pesoAdicional);
				resultado = 19+((int)pesoAdicional*(float)7.5);
				
			}else if (pesoPaquete>2.0) {
				int adicional = (int)pesoPaquete-2;
				resultado = 19+(adicional*(float)7.5);
			} else {
				resultado = 19;
			}
			
			System.out.println("El precio total del envio es: "+resultado+" euros.");

			break;

		default:
			break;
		}

		sc.close();

	}

}
