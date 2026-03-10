package com.daw;

import java.time.LocalDateTime;

public class Cuadrado extends Figura {

	private Float lado;
	
	public Cuadrado(String codigo, Color color, LocalDateTime fechaRegistro, Float pseCmCuadrado, Float lado) {
		super(codigo, color, fechaRegistro, pseCmCuadrado);
		this.lado = lado;
	}
	
	

	public Float getLado() {
		return lado;
	}



	public void setLado(Float lado) {
		this.lado = lado;
	}



	@Override
	public Float getArea() {
		return getLado()*getLado();
	}

}
