package com.daw;

import java.time.LocalDate;

public class Jugador_Campo extends Jugador{
	
	private Integer goles;
	private Integer asistencias;
	
	
	public Jugador_Campo(String codigo, String nombre, LocalDate fechaNacimiento, Float estatura,
			Integer partidosJugados, Integer tarjetasAmarillas, Integer tarjetasRojas, Integer goles,
			Integer asistencias) {
		super(codigo, nombre, fechaNacimiento, estatura, partidosJugados, tarjetasAmarillas, tarjetasRojas);
		this.goles = goles;
		this.asistencias = asistencias;
	}

	

	public Integer getGoles() {
		return goles;
	}



	public void setGoles(Integer goles) {
		this.goles = goles;
	}



	public Integer getAsistencias() {
		return asistencias;
	}



	public void setAsistencias(Integer asistencias) {
		this.asistencias = asistencias;
	}



	@Override
	public String getDemarcacion() {
		return "JUGADOR DE CAMPO";
	}


	@Override
	public String getEstadisticas() {
		return this.getNombre()+" Demarcación: "+this.getDemarcacion()+" Goles marcados: "+this.getGoles()+" Tarjetas amarillas: "+this.getTarjetasAmarillas()+" Tarjetas rojas: "+this.getTarjetasRojas()+" Asistencias: "+this.getAsistencias()+"\n";

	}
	
	@Override
	public String formatoGuardar() {
		
		return "#CODIGO:"+this.getCodigo()+"#NOMBRE:"+this.getNombre()+"#FECHA_NACIMIENTO:"+this.getFechaNacimiento().format(Main.formato)+"#ESTATURA:"+this.getEstatura()+"#DEMARCACION:"+this.getDemarcacion()+"#PARTIDOS_JUGADOS:"+this.getPartidosJugados()+"#TARJETAS_AMARILLAS:"+this.getTarjetasAmarillas()+"#TARJETAS_ROJAS:"+this.getTarjetasRojas()+"#GOLES:"+this.getGoles()+"#ASISTENCIAS:"+this.getAsistencias();
	}

}
