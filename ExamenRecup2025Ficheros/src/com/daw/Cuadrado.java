package com.daw;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
	
	public String stringGuardar() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		return "CUADRADO#CÓDIGO;"+super.getCodigo()+"#COLOR;"+super.getColor()+"#FECHA DE REGISTRO;"+super.getFechaRegistro().format(format)+""
				+ "#PESO POR CM2;"+super.getPseCmCuadrado()+"#LADO;"+this.getLado();
		
	}
	
	@Override
	public String toString() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		 
		return "CUADRADO - CÓDIGO: "+super.getCodigo()+" - COLOR: "+super.getColor()+" - FECHA DE REGISTRO: "+super.getFechaRegistro().format(format)+""
				+ " - PESO POR CM2: "+super.getPseCmCuadrado()+" - LADO: "+this.getLado()+" - AREA: "+this.getArea()+" cm2 - PESO: "+super.getPeso()+" gramos";
	}

}
