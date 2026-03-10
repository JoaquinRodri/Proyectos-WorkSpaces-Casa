package com.daw;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
	
	public String stringGuardar() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		return "CÍRCULO#CÓDIGO;"+super.getCodigo()+"#COLOR;"+super.getColor()+"#FECHA DE REGISTRO;"+super.getFechaRegistro().format(format)+""
				+ "#PESO POR CM2;"+super.getPseCmCuadrado()+"#RADIO;"+this.getRadio();
		
	}
	
	@Override
	public String toString() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		return "CIRCULO - CÓDIGO: "+super.getCodigo()+" - COLOR: "+super.getColor()+" - FECHA DE REGISTRO: "+super.getFechaRegistro().format(format)+""
		+ " - PESO POR CM2: "+super.getPseCmCuadrado()+" - RADIO: "+this.getRadio()+" - AREA: "+this.getArea()+" cm2 - PESO: "+super.getPeso()+" gramos";
		
	}

}
