package com.daw;

import java.time.LocalDateTime;

public class Circulo extends Figura{
	
	private Float radio;
	
	public Circulo(String codigo, Color color, LocalDateTime fechaRegistro, Float pseCmCuadrado, Float radio) {
		super(codigo, color, fechaRegistro, pseCmCuadrado);
		this.radio = radio;
	}



	public Float getRadio() {
		return radio;
	}



	public void setRadio(Float radio) {
		this.radio = radio;
	}



	@Override
	public Float getArea() {
		// TODO Auto-generated method stub
		return (float) (Math.PI * (getRadio()*getRadio()));
	}

}
