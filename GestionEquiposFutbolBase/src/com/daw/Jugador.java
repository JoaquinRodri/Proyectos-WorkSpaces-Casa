package com.daw;

import java.time.LocalDate;

public abstract class Jugador implements InterfazJugadores{
	
	private String codigo;
	private String nombre;
	private LocalDate fechaNacimiento;
	private Float estatura;
	private Integer partidosJugados;
	private Integer tarjetasAmarillas;
	private Integer tarjetasRojas;
	
	public Jugador(String codigo, String nombre, LocalDate fechaNacimiento, Float estatura, Integer partidosJugados,
			Integer tarjetasAmarillas, Integer tarjetasRojas) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.estatura = estatura;
		this.partidosJugados = partidosJugados;
		this.tarjetasAmarillas = tarjetasAmarillas;
		this.tarjetasRojas = tarjetasRojas;
	}

	
	
	public String getCodigo() {
		return codigo;
	}



	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public Float getEstatura() {
		return estatura;
	}



	public void setEstatura(Float estatura) {
		this.estatura = estatura;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}



	public void setPartidosJugados(Integer partidosJugados) {
		this.partidosJugados = partidosJugados;
	}



	public void setTarjetasAmarillas(Integer tarjetasAmarillas) {
		this.tarjetasAmarillas = tarjetasAmarillas;
	}



	public void setTarjetasRojas(Integer tarjetasRojas) {
		this.tarjetasRojas = tarjetasRojas;
	}



	@Override
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public LocalDate getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	@Override
	public Integer getPartidosJugados() {
		return this.partidosJugados;
	}

	@Override
	public Integer getTarjetasAmarillas() {
		return this.tarjetasAmarillas;
	}

	@Override
	public Integer getTarjetasRojas() {
		return this.tarjetasRojas;
	}

	@Override
	public abstract String getDemarcacion();

	@Override
	public abstract String getEstadisticas();
	
	public abstract String formatoGuardar();
	
	

}
