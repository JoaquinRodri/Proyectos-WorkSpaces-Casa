package com.daw;

import java.time.LocalDateTime;

public abstract class Figura implements InterfazFigura{
	
	private String codigo;
	private Color color;
	private LocalDateTime fechaRegistro;
	private Float pseCmCuadrado;
	
	public Figura(String codigo, Color color, LocalDateTime fechaRegistro, Float pseCmCuadrado) {
		this.codigo = codigo;
		this.color = color;
		this.fechaRegistro = fechaRegistro;
		this.pseCmCuadrado = pseCmCuadrado;
	}

	
	
	public Float getPseCmCuadrado() {
		return pseCmCuadrado;
	}



	public void setPseCmCuadrado(Float pseCmCuadrado) {
		this.pseCmCuadrado = pseCmCuadrado;
	}



	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public void setColor(Color color) {
		this.color = color;
	}



	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}



	@Override
	public String getCodigo() {
		// TODO Auto-generated method stub
		return codigo;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return color;
	}

	@Override
	public LocalDateTime getFechaRegistro() {
		// TODO Auto-generated method stub
		return fechaRegistro;
	}

	@Override
	public abstract Float getArea();
	
	public abstract String stringGuardar();

	@Override
	public Float getPeso() {
		return getPseCmCuadrado()*getArea();
	}
	
	

}
