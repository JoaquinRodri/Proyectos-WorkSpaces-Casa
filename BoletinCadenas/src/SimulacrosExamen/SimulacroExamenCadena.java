package SimulacrosExamen;



public class SimulacroExamenCadena {

	public static void main(String[] args) {
		
		String texto = "Los programadores crean oso   soluciones eficientes, y "
				+ "los programas deben ser claros y radar mantenibles oso .";
		
		//Normalizacion y limpieza
		String textoNormalizado = normalizarTexto(texto);
		System.out.println(textoNormalizado);

		
		//palabra mas larga
		palabraMasLarga(textoNormalizado);
		
		//deteccion de palindromos dentro del texto
		String [] palabrasPali = palabrasPalindromas(textoNormalizado);
		String aMostrar = "";
		System.out.print("Palindromos encontrados:  ");
		for (String string : palabrasPali) {
			aMostrar+=string+", ";
		}
		
		System.out.println(aMostrar.substring(0, aMostrar.length()-2));
		
		String [] palabras = textoNormalizado.split(" ");
		String fraseNueva = "";
		for (String palabra : palabras) {
			fraseNueva+= primeraMay(palabra)+" ";
			
		}
		System.out.println(fraseNueva);

	}
	static String primeraMay(String palabra) {
		char caracteres[] = palabra.toCharArray();
		
		caracteres[0] = Character.toUpperCase(caracteres[0]);
		String palabraM = String.valueOf(caracteres);
		return palabraM;
	}
	
	static boolean esPalindroma (String palabra) {
		boolean esPalin = false;
		if (palabra.length()>1) {
			esPalin = true;
			for (int i = 0; i < palabra.length(); i++) {
				if (palabra.charAt(i) != palabra.charAt(palabra.length()-1-i)) {
					esPalin = false;
					break;
				}
			}
		}
		
		
		return esPalin;
	}
	
	static String[] palabrasPalindromas(String texto) {
		String[] palabras = texto.split(" ");
		String contenido = "";
		for (String palabra : palabras) {
			if (esPalindroma(palabra)) {
				if (!contenido.contains(palabra)) {
					contenido+=palabra+",";
				}
				
			}
		}
		
		return contenido.split(",");
	}
	
	static void palabraMasLarga(String texto) {
		String palabraXl = "";
		String [] palabras = texto.split(" ");
		for (String palabra : palabras) {
			if (palabra.length()>palabraXl.length()) {
				palabraXl = palabra;
			}
		}
		System.out.println("Palabra: "+palabraXl);
		System.out.println("Longitud: "+palabraXl.length());
		
	}
	
	static String normalizarTexto(String texto) {
		String textoMod = "";
		textoMod = texto.toLowerCase();
		String textLimpio = "";
		char [] caracteres = textoMod.toCharArray();
		for (int i = 0; i < caracteres.length; i++) {
			if (caracteres[i]!=',' && caracteres[i]!='.') {
				if (caracteres[i]!=' ' || caracteres[i-1]!=' ') {
					textLimpio+=caracteres[i];
				}
			}
		}
		
		return textLimpio;
	}

}
