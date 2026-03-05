package com.daw;



public class Ej2EnmascaradoYValidacion {

	public static void main(String[] args) {
		
		String cadena = "  JuAn PeReZ :  Abc12345  ";
		
		//1
		if (cadena.indexOf(":") != cadena.lastIndexOf(":")) {
			System.out.println("Tiene mas de un ':'");
		}else if (cadena.indexOf(":") == -1) {
			System.out.println("no hay ':'");
		} else {
			String[] usuarioContraseña = verificarYcomprobar(cadena);
			String usuario = usuarioContraseña[0].toLowerCase();
			String contraseña = usuarioContraseña[1];
			System.out.println("Usuario: " + usuario);
			String cEnmascarada = enmascarar(contraseña);
			System.out.println("Password enmascarada: " + cEnmascarada);
			String cumple = "";
			if (contraseña.length()>=8) {
				cumple = "Si";
			} else {
				cumple = "No";
			}
			System.out.println("Cumple longitud>=8: " + cumple);

			// contraseña cumple...
			requisitosContraseña(contraseña);

		}
		
		
		
	}
	static void requisitosContraseña(String contraseña) {
		String digito = "No";
		String mayus = "No";
		String espacios = "No";
		for (int i = 0; i < contraseña.length(); i++) {
			if (Character.isDigit(contraseña.charAt(i))) {
				digito = "Si";
			}else if (Character.isUpperCase(contraseña.charAt(i))) {
				mayus = "Si";
			}else if (Character.isSpaceChar(contraseña.charAt(i))) {
				espacios = "Si";
			}
		}
		
		System.out.println("Contiene digitos: "+digito);
		System.out.println("Contiene mayuscula: "+mayus);
		System.out.println("Contiene espacios: "+espacios);
		
	}
	
	static String enmascarar(String contraseña) {
		for (int i = 0; i < contraseña.length(); i++) {
			contraseña = contraseña.replace(contraseña.charAt(i), '*');
		}
		return contraseña;
	}
	
	static String[] verificarYcomprobar(String cadena) {
		String [] resultado = cadena.split(":");
		resultado[0] = resultado[0].trim().replace(" ", "");
		resultado[1] = resultado[1].trim();
		return resultado;
	}

}
