package com.daw;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Conejo extends Animal{
	
	private Double peso;
	private TipoPelaje tipoPelaje;
	
	public Conejo(String id, String nombre, LocalDate fechaIngreso, Float edad, Genero genero, Boolean vacunado,
			Double peso, TipoPelaje tipoPelaje) {
		super(id, nombre, fechaIngreso, edad, genero, vacunado);
		this.peso = peso;
		this.tipoPelaje = tipoPelaje;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public TipoPelaje getTipoPelaje() {
		return tipoPelaje;
	}

	public void setTipoPelaje(TipoPelaje tipoPelaje) {
		this.tipoPelaje = tipoPelaje;
	}

	@Override
	public String formatoImprimir() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "CONEJO - ID: "+this.getId()+" - NOMBRE: "+this.getNombre()+" - GÉNERO: "+this.getGenero()+" - INGRESO: "+this.getFechaIngreso().format(formato)
				+ " - EDAD: "+this.getEdad()+" años - VACUNADO: "+(this.getVacunado()? "Si":"No")+ " - PESO: "+this.getPeso()+" - PELAJE: "+this.getTipoPelaje();
	}
	
	@Override
	public String getDescripcion() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "CONEJO - "+this.getNombre()+", "+this.getGenero()+", peso: "+this.getPeso()+"kg, pelaje: "+this.getTipoPelaje()+", ingresado el "+this.getFechaIngreso().format(formato)+", edad: "+this.getEdad()+" años, vacunado: "+(this.getVacunado()?"si":"no");
	}

	@Override
	public String formatGuardar() {
		
		return "CONEJO#ID: "+this.getId()+" #NOMBRE: "+this.getNombre()+" #FECHA INGRESO: "+this.getFechaIngreso().format(Main.formato)+" #EDAD: "+this.getEdad()+" #GENERO: "+this.getGenero()+" #VACUNADO: "+this.getVacunado()+" #PESO: "+this.getPeso()+" #PELAJE: "+this.getTipoPelaje().name().toLowerCase();
	}
	
	

}
