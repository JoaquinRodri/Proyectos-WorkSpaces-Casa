package com.daw;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Gato extends Animal{
	
	private Boolean esPelirrojo;
	private Boolean conViveConOtros;
	
	public Gato(String id, String nombre, LocalDate fechaIngreso, Float edad, Genero genero, Boolean vacunado,
			Boolean esPelirrojo, Boolean conViveConOtros) {
		super(id, nombre, fechaIngreso, edad, genero, vacunado);
		this.esPelirrojo = esPelirrojo;
		this.conViveConOtros = conViveConOtros;
	}

	public Boolean getEsPelirrojo() {
		return esPelirrojo;
	}

	public void setEsPelirrojo(Boolean esPelirrojo) {
		this.esPelirrojo = esPelirrojo;
	}

	public Boolean getConViveConOtros() {
		return conViveConOtros;
	}

	public void setConViveConOtros(Boolean conViveConOtros) {
		this.conViveConOtros = conViveConOtros;
	}

	@Override
	public String getDescripcion() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return this.getNombre()+" - ID: "+this.getId()+" - NOMBRE: "+this.getNombre()+" - GÉNERO: "+this.getGenero()+" - INGRESO: "+this.getFechaIngreso().format(formato)
				+ " - EDAD: "+this.getEdad()+" años - VACUNADO: "+(this.getVacunado()? "Si":"No")+ " - PELIRROJO: "+this.getEsPelirrojo()+" - CONVIVE: "+(this.getConViveConOtros()? "Si":"No");
	}
	
	

}
