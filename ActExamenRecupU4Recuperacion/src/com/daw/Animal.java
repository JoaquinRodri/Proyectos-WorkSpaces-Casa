package com.daw;

import java.time.LocalDate;

public abstract class Animal implements Comparable<Animal>, InterfazAnimal{
	
	private String id;
	private String nombre;
	private LocalDate fechaIngreso;
	private Float edad;
	private Genero genero;
	private Boolean vacunado;
	
	public Animal(String id, String nombre, LocalDate fechaIngreso, Float edad, Genero genero, Boolean vacunado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaIngreso = fechaIngreso;
		this.edad = edad;
		this.genero = genero;
		this.vacunado = vacunado;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Float getEdad() {
		return edad;
	}

	public void setEdad(Float edad) {
		this.edad = edad;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Boolean getVacunado() {
		return vacunado;
	}

	public void setVacunado(Boolean vacunado) {
		this.vacunado = vacunado;
	}

		
	public abstract String getDescripcion();
	public abstract String formatGuardar();
	
	@Override
	public int compareTo(Animal o) {
		if (this.getNombre().equals(o.getNombre())) {
			return - this.getEdad().compareTo(o.getEdad());
		}else {
			return this.getNombre().compareTo(o.getNombre());
		}
		
	}

}
