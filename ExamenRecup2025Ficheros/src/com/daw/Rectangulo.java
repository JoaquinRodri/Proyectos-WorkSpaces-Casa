package com.daw;

import java.time.LocalDateTime;

public class Rectangulo extends Figura{
	
	private Float base;
	private Float altura;

	public Rectangulo(String codigo, Color color, LocalDateTime fechaRegistro, Float pseCmCuadrado, Float base,
			Float altura) {
		super(codigo, color, fechaRegistro, pseCmCuadrado);
		this.base = base;
		this.altura = altura;
	}


	public Float getBase() {
		return base;
	}



	public void setBase(Float base) {
		this.base = base;
	}



	public Float getAltura() {
		return altura;
	}



	public void setAltura(Float altura) {
		this.altura = altura;
	}



	@Override
	public Float getArea() {
		return getBase()*getAltura();
	}

}
