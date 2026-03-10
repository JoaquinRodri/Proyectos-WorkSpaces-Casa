package com.daw;

import java.time.LocalDateTime;

public class Triangulo extends Figura{

	private Float base;
	private Float Altura;

	public Triangulo(String codigo, Color color, LocalDateTime fechaRegistro, Float pseCmCuadrado, Float base,
			Float altura) {
		super(codigo, color, fechaRegistro, pseCmCuadrado);
		this.base = base;
		Altura = altura;
	}

	

	public Float getBase() {
		return base;
	}



	public void setBase(Float base) {
		this.base = base;
	}



	public Float getAltura() {
		return Altura;
	}



	public void setAltura(Float altura) {
		Altura = altura;
	}



	@Override
	public Float getArea() {
		return getBase()*getAltura();
	}

}
