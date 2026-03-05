package com.daw;

public class Ej3CompresionTextoConteo {

	public static void main(String[] args) {
		
		String cadena = "aaBBBccDAA";
		
		String comprimida = comprimir(cadena);
		System.out.println("Comprimida: "+comprimida);
		
		String descomprimida = descomprimir(comprimida);
		System.out.println("Descomprimida: "+descomprimida);
		
		

	}
	static String descomprimir(String comprimida) {
		if (comprimida.length() == 1) {
			return comprimida;
		}
		String resultado = "";
		for (int i = 0; i < comprimida.length(); i++) {
			if (i+1<comprimida.length() && Character.isDigit(comprimida.charAt(i+1))) {
				int digito = Character.getNumericValue(comprimida.charAt(i+1));
				char c = comprimida.charAt(i);
				for (int j = 0; j < digito; j++) {
					resultado+=c;
				}
				i++;
			}else {
				resultado+=comprimida.charAt(i);
			}
		}
		
		return resultado;
	}
	
	static String comprimir(String cadena) {
		String unico = "";
		for (int i = 0; i < cadena.length(); i++) {
			if (unico.indexOf(cadena.charAt(i)) == -1) {
				unico+=cadena.charAt(i);
			}
		}
		
		String resultado = "";
		for (int i = 0; i < unico.length(); i++) {
			int cont = 0;
			for (int j = 0; j < cadena.length(); j++) {
				if (unico.charAt(i) == cadena.charAt(j)) {
					cont++;
				}
			}
			if (cont>1) {
				resultado+=unico.charAt(i)+String.valueOf(cont);
			}else {
				resultado+=unico.charAt(i);
			}
		}
		
		return resultado;
	}

}
