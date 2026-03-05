package com.daw;

import java.util.Random;

public class Password {
	
	private int longitud;
	private String contraseña;
	
	public Password() {
		this.longitud = 8;
		generarPassword();
	}
	
	public Password (int longitud) {
		this.longitud = longitud;
		generarPassword();
	}
	
	public boolean esFuerte() {
		int mayus = 0;
		int minus = 0;
		int nums = 0;
		
		for (int i = 0; i < this.longitud; i++) {
			if (Character.isUpperCase(this.contraseña.charAt(i))) {
				mayus++;
			}else if (Character.isLowerCase(this.contraseña.charAt(i))) {
				minus++;
			}else if (Character.isDigit(this.contraseña.charAt(i))) {
				nums++;
			}
		}
		
		if (mayus>2 && minus>1 && nums>5) {
			return true;
		}
		
		return false;
	}
	
	public void generarPassword() {
		String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		
		String password = "";
		
		for (int i = 0; i < this.longitud; i++) {
			int pos = random.nextInt(caracteres.length());
			password += caracteres.charAt(pos);
			
		}
		
		this.contraseña = password;
	}
	
	public String getContraseña() {
		return this.contraseña;
	}
	
	public int getLongitud() {
		return this.longitud;
	}
	
	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

}
