package com.daw;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Perro extends Animal{
	
	private String raza;
	private NivelEnergia nivelEnergia;
	
	public Perro(String id, String nombre, LocalDate fechaIngreso, Float edad, Genero genero, Boolean vacunado,
			String raza, NivelEnergia nivelEnergia) {
		super(id, nombre, fechaIngreso, edad, genero, vacunado);
		this.raza = raza;
		this.nivelEnergia = nivelEnergia;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public NivelEnergia getNivelEnergia() {
		return nivelEnergia;
	}

	public void setNivelEnergia(NivelEnergia nivelEnergia) {
		this.nivelEnergia = nivelEnergia;
	}


	public String formatoImprimir() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "PERRO - ID: "+this.getId()+" - NOMBRE: "+this.getNombre()+" - GÉNERO: "+this.getGenero()+" - INGRESO: "+this.getFechaIngreso().format(formato)
				+ " - EDAD: "+this.getEdad()+" años - VACUNADO: "+(this.getVacunado()? "Si":"No")+ " - RAZA: "+this.getRaza()+" - NIVEL ENERGIA: "+this.getNivelEnergia();
	}
	
	@Override
	public String getDescripcion() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "PERRO - "+this.getNombre()+", "+this.getGenero()+", raza "+this.getRaza()+", nivel de energía: "+this.getNivelEnergia().toString().toLowerCase()+", ingresado el "+this.getFechaIngreso().format(formato)+", edad: "+this.getEdad()+" años, vacunado: "+(this.getVacunado()?"si":"no");
	}

	@Override
	public String formatGuardar() {
		
		return "PERRO#ID: "+this.getId()+" #NOMBRE: "+this.getNombre()+" #FECHA INGRESO: "+this.getFechaIngreso().format(Main.formato)+" #EDAD: "+this.getEdad()+" #GENERO: "+this.getGenero()+" #VACUNADO: "+this.getVacunado()+" #RAZA: "+this.getRaza()+" #ENERGIA: "+this.getNivelEnergia().name().toLowerCase();
	}

	
	
	

}
