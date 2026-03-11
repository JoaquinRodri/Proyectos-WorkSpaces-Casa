package com.daw;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
		return (getBase()*getAltura())/2;
	}


	public String stringGuardar() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		return "TRIÁNGULO#CÓDIGO:"+super.getCodigo()+"#COLOR:"+super.getColor()+"#FECHA DE REGISTRO:"+super.getFechaRegistro().format(format)+""
				+ "#PESO POR CM2:"+super.getPseCmCuadrado()+"#BASE:"+this.getBase()+"#ALTURA:"+this.getAltura();
		
	}

	@Override
	public String toString() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		 
		return "TRIÁNGULO - CÓDIGO: "+super.getCodigo()+" - COLOR: "+super.getColor()+" - FECHA DE REGISTRO: "+super.getFechaRegistro().format(format)+""
				+ " - PESO POR CM2: "+super.getPseCmCuadrado()+" - BASE: "+this.getBase()+" - ALTURA: "+this.getAltura()+" - AREA: "+this.getArea()+" cm2 - PESO: "+super.getPeso()+" gramos";
	}
	
	

}
