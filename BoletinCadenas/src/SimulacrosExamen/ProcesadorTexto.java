package SimulacrosExamen;


import java.util.Scanner;

public class ProcesadorTexto {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Por favor, introduzca una frase:");
		String frase = sc.nextLine();
		
		boolean validacion = false;
		while (validacion!=true) {
			if (validacionTexto(frase)) {
				System.out.println("frase valida.");
				validacion = true;
			}else {
				System.out.println("Frase no valida vuelva a introducir una, con al menos 20 caracteres, una vocal y  una consonante:");
				frase = sc.nextLine();
			}
		}
		
		//Apartado 2
		analisisCaracteres(frase);
		
		//Apartado 3
		String textoNormalizado = normalizarTexto(frase);
		System.out.println("\nTexto normalizado:");
		System.out.println(textoNormalizado);
		
		//Apartado 4
		System.out.println("\nNumeros de veces que se repite una palabra:");
		procesamientoArrays(textoNormalizado);
		
		//Apartado 5
		char[] textoC = frase.toCharArray();
		char [] cifrado = cifrarTexto(textoC, 3);
		System.out.println("\ntexto cifrado:");
		System.out.println(new String(cifrado));
		
		//Apartado 6
		if (textoEquilibrado(frase)) {
			System.out.println("\nEs equilibrado");
		}else {
			System.out.println("\nNo es equilibrado");
		}
		
		sc.close();
		

	}
	static char[] cifrarTexto(char[] texto, int desplazamiento) {
		String abecedario = "abcdefghijklmnopqrstuvwxyz";
		for (int i = 0; i < texto.length; i++) {
			char c = texto[i];
			if (Character.isLetter(c)) {
				if (Character.isUpperCase(c)) {
					abecedario = abecedario.toUpperCase();
					
				}else {
					abecedario = abecedario.toLowerCase();
					
				}
				int posicion = abecedario.indexOf(c);
				int pNueva = (posicion + desplazamiento) % 26;
				texto[i] = abecedario.charAt(pNueva);
			}
		}
		return texto;
	}
	
	static boolean textoEquilibrado(String texto) {
		String vocales = "aeiouáéíóúü";
		texto = texto.toLowerCase();
		int cVocales = 0;
		int consonantes = 0;
		for (int i = 0; i < texto.length(); i++) {
			char c = texto.charAt(i);
			if (vocales.indexOf(c)!=-1) {
				cVocales++;
			}else if (Character.isLetter(c) && !Character.isSpaceChar(c)) {
				consonantes++;
			}
		}
		
		if (cVocales == consonantes) {
			return true;
		}
		
		return false;
		
	}
	
	static void procesamientoArrays(String texto) {
		String[] palabras = texto.split(" ");
		String palabrasUnicas = "";
		for (int i = 0; i < palabras.length; i++) {
			if (palabrasUnicas.indexOf(palabras[i]) == -1) {
				palabrasUnicas += palabras[i]+" ";
			}
		}
		
		for (int i = palabras.length-1; i >= 0 ; i--) {
			System.out.println(palabras[i]);
		}
		
		String [] paUnicas = palabrasUnicas.split(" ");
		
		for (int i = paUnicas.length-1; i >= 0 ; i--) {
			int cont = 0;
			for (int j = palabras.length-1; j >= 0; j--) {
				if (paUnicas[i].equals(palabras[j])) {
					cont++;
				}
			}
			System.out.println(paUnicas[i]+" -> "+cont);
		}
		
	}
	
	 static String normalizarTexto(String texto) {
		 texto = texto.trim().toLowerCase();
		 String textoMod = "";
		 boolean espacioAnterior = false; 
		 for (int i = 0; i < texto.length(); i++) {
			char c = texto.charAt(i);
			
			if (Character.isLetter(c) || Character.isDigit(c)) {
				textoMod += c;
				espacioAnterior = false;
			}else if (c == ' ' && !espacioAnterior) {
				textoMod += c;
				espacioAnterior = true;
			}
		}
		 
		 return textoMod;
	 }
	
	static void analisisCaracteres(String texto) {
		char [] caracteres = texto.toCharArray();
		int contLetrasMayu = 0;
		int contLetrasMinus = 0;
		int contDigitos = 0;
		int contSimbolos = 0;
		
		for (char c : caracteres) {
			if (Character.isUpperCase(c)) {
				contLetrasMayu++;
			}else if (Character.isLowerCase(c)) {
				contLetrasMinus++;
			}else if (Character.isDigit(c)) {
				contDigitos++;
			}else if (!Character.isSpaceChar(c)) {
				contSimbolos++;
			}
		}
		
		
		System.out.println("\nAnalisis de caracteres:");
		System.out.println("Numero de caracteres: "+caracteres.length);
		System.out.println("Mayusculas: "+contLetrasMayu);
		System.out.println("Minusculas: "+contLetrasMinus);
		System.out.println("Digitos: "+contDigitos);
		System.out.println("Simbolos: "+contSimbolos);
		
	}
	
	static boolean validacionTexto (String frase) {
		
		if (frase.length()<20) {
			return false;
		}
		String vocales = "aeiouáéíóúü";
		boolean vocal = false;
		boolean consonante = false;
		for (int i = 0; i < frase.length(); i++) {
			if (vocales.indexOf(frase.charAt(i))!=-1) {
				vocal = true;
			}else if (Character.isLetter(frase.charAt(i))) {
				consonante = true;
			}
		}
		
		if (consonante && vocal) {
			return true;
		}
		
		return false;
	}

}
