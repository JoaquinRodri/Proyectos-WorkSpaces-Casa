package pruebasTeam;

public class DivisoresPrimo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 13;
		//int cont = 0;
		
		//for (int i = 1; i <= n; i++) {
			//if (divisoresPrimos(i)) {
			//	cont++;
			//}
		//}
		
		
		int resultado = divisoresPrimos(n);
		System.out.println("La cantidad de divisores primos que tiene es: "+resultado);
		
	}
	static int divisoresPrimos(int n) {
		int cont = 0;
		for (int i = 1; i <= n; i++) {
			if (n%i==0) {
				boolean esprimo=true;
				for (int j = 2; j < i; j++) {
					if (i%j==0) {
						esprimo=false;
					}
					
				}
				if (esprimo) {
					cont++;
				}
			}
			
		}
		
		
		
		return cont;
	}

}
