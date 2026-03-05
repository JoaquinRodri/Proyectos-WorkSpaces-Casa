package com.daw;

public class Jugador {
	
	private String dni;
	private String nombre;
	private Posicion posicion;
	private float estatura;
	
	
	public Jugador(String dni, String nombre, Posicion posicion, float estatura) {
		this.dni = dni;
		this.nombre = nombre;
		this.posicion = posicion;
		this.estatura = estatura;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Posicion getPosicion() {
		return posicion;
	}


	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}


	public float getEstatura() {
		return estatura;
	}


	public void setEstatura(float estatura) {
		this.estatura = estatura;
	}


	@Override
	public String toString() {
		String result = "Jugador:\n"
				+ "\tNombre: "+this.nombre+"\n"
				+ "\tDni: "+this.dni+"\n"
				+ "\tPosicion: "+this.posicion+"\n"
				+ "\tEstatura: "+this.estatura;
		return result;
	}
	
	

}
