package examenExamen1;


import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Por favor, introduzca dos números:");
		int num1 = 0;
		int num2 = 0;

		do {
			num1 = sc.nextInt();
			num2 = sc.nextInt();
			if (num1 > 0 && num2 > 0) {
				break;
			} else {
				System.out.println("Los dos numeros deben de ser possitivos.");
			}
		} while (true);
		int opcion = 0;
		do {
			System.out.println("Por favor, seleciones la operacion a realizar:");
			System.out.println("1-Calcular el resultado de dividir el primer numero entre el segundo.");
			System.out.println("2-Determinar si la suma de los dos números es un numero par o impar.");
			System.out.println("3-Determinar si la suma de los dos numeros es un primo.");
			System.out.println("4-Calcular la potencia del primer numero elevado al segundo (usando recursividad).");
			System.out.println("5-Salir.");
			
			opcion = sc.nextInt();

			switch (opcion) {
			case 1:
				dividirNum(num1, num2);
				break;
			case 2:
				SumaImparOPar(num1, num2);
				break;
			case 3:
				primo(num1, num2);
				break;
			case 4:
				System.out.println(recursividad(num1, num2)); 
				break;
			case 5:
				System.out.println("Salir...");
				break;

			default:
				System.out.println("Opcion incorrecta, vuelva a inroducir una opcion.");
				break;
			}

		} while (opcion != 5);
		sc.close();

	}
	static int recursividad(int n1,int n2) {
		
		if (n2 == 1) {
			return n1;
		} else {
			return n1 * recursividad(n1, n2-1);
		}
	}
	
	static void primo(int n1, int n2) {
		int sumaTotal = n1+n2;
		boolean primo = true;
		for (int i = 2; i < sumaTotal; i++) {
			if (sumaTotal%i==0) {
				primo = false;
			}
		}
		if (primo) {
			System.out.println("La suma de los dos numeros es un numero primo");
		}else {
			System.out.println("La suma de los dos numeros no es un numero primo");
		}
	}
	
	static void SumaImparOPar(int n1, int n2) {
		int sumaTotal = n1+n2;
		if (sumaTotal%2==0) {
			System.out.println("La suma de los dos numeros es par");
		} else {
			System.out.println("La suma de los dos numeros es impar");
		}
	}
	
	static void dividirNum(int n1, int n2) {
		float resultado = (float)n1/n2;
		System.out.println("El resultado de la division es: "+resultado);
	}

}
