package com.daw;

public class Revista extends Material{
	
	private Integer numeroEdicion;
	private Mes mes;
	private Integer edadMinima;
	
	
	public Revista(String codigo, String titulo, String autor, Integer anioPublicacion, Boolean disponible,
			Integer numeroEdicion, Mes mes, Integer edadMinima) {
		super(codigo, titulo, autor, anioPublicacion, disponible);
		this.numeroEdicion = numeroEdicion;
		this.mes = mes;
		this.edadMinima = edadMinima;
	}


	public Integer getNumeroEdicion() {
		return numeroEdicion;
	}


	public void setNumeroEdicion(Integer numeroEdicion) {
		this.numeroEdicion = numeroEdicion;
	}


	public Mes getMes() {
		return mes;
	}


	public void setMes(Mes mes) {
		this.mes = mes;
	}


	public Integer getEdadMinima() {
		return edadMinima;
	}


	public void setEdadMinima(Integer edadMinima) {
		this.edadMinima = edadMinima;
	}
	
	public String toString() {
		String aux = "\r\nEdición: "+getNumeroEdicion()+"\r\n"
				+ "Mes: "+getMes()+"\r\n"
				+ "Edad mínima: "+getEdadMinima()+",";
		return super.toString()+aux;
	}
	
}
