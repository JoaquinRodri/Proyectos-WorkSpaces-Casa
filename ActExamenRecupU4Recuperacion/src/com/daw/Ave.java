package com.daw;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Ave extends Animal {
	
	private String especie;
	private Boolean puedeVolar;
	
	public Ave(String id, String nombre, LocalDate fechaIngreso, Float edad, Genero genero, Boolean vacunado,
			String especie, Boolean puedeVolar) {
		super(id, nombre, fechaIngreso, edad, genero, vacunado);
		this.especie = especie;
		this.puedeVolar = puedeVolar;
	}

	

	public String getEspecie() {
		return especie;
	}



	public void setEspecie(String especie) {
		this.especie = especie;
	}



	public Boolean getPuedeVolar() {
		return puedeVolar;
	}



	public void setPuedeVolar(Boolean puedeVolar) {
		this.puedeVolar = puedeVolar;
	}



	@Override
	public String getDescripcion() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "AVE - ID: "+this.getId()+" - NOMBRE: "+this.getNombre()+" - GÉNERO: "+this.getGenero()+" - INGRESO: "+this.getFechaIngreso().format(formato)
				+ " - EDAD: "+this.getEdad()+" años - VACUNADO: "+(this.getVacunado()? "Si":"No")+ " - ESPECIE: "+this.getEspecie()+" - VUELA: "+(this.getPuedeVolar()? "Si":"No");
	}



	@Override
	public String formatGuardar() {
		
		return "AVE#ID: "+this.getId()+" #NOMBRE: "+this.getNombre()+" #FECHA INGRESO: "+this.getFechaIngreso().format(Main.formato)+" #EDAD: "+this.getEdad()+" #GENERO: "+this.getGenero()+" #VACUNADO: "+this.getVacunado()+" #ESPECIE: "+this.getEspecie()+" #VUELA: "+this.getPuedeVolar();
	}

}
