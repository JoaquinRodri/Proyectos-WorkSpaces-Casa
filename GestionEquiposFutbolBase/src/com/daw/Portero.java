package com.daw;

import java.time.LocalDate;

public class Portero extends Jugador{
	
	private Integer golesEncajados;
	private Integer penaltisParados;
	
	
	public Portero(String codigo, String nombre, LocalDate fechaNacimiento, Float estatura, Integer partidosJugados,
			Integer tarjetasAmarillas, Integer tarjetasRojas, Integer golesEncajados, Integer penaltisParados) {
		super(codigo, nombre, fechaNacimiento, estatura, partidosJugados, tarjetasAmarillas, tarjetasRojas);
		this.golesEncajados = golesEncajados;
		this.penaltisParados = penaltisParados;
	}

	
	
	public Integer getGolesEncajados() {
		return golesEncajados;
	}



	public void setGolesEncajados(Integer golesEncajados) {
		this.golesEncajados = golesEncajados;
	}



	public Integer getPenaltisParados() {
		return penaltisParados;
	}



	public void setPenaltisParados(Integer penaltisParados) {
		this.penaltisParados = penaltisParados;
	}



	@Override
	public String getDemarcacion() {
		return "PORTERO";
	}


	@Override
	public String getEstadisticas() {
		return this.getNombre()+" Demarcación: "+this.getDemarcacion()+" Goles encajados: "+this.getGolesEncajados()+" Tarjetas amarillas: "+this.getTarjetasAmarillas()+" Tarjetas rojas: "+this.getTarjetasRojas()+" Penaltis parados: "+this.getPenaltisParados()+"\n";

	}


	@Override
	public String formatoGuardar() {
		
		return "#CODIGO:"+this.getCodigo()+"#NOMBRE:"+this.getNombre()+"#FECHA_NACIMIENTO:"+this.getFechaNacimiento().format(Main.formato)+"#ESTATURA:"+this.getEstatura()+"#DEMARCACION:"+this.getDemarcacion()+"#PARTIDOS_JUGADOS:"+this.getPartidosJugados()+"#TARJETAS_AMARILLAS:"+this.getTarjetasAmarillas()+"#TARJETAS_ROJAS:"+this.getTarjetasRojas()+"#GOLES_ENCAJADOS:"+this.getGolesEncajados()+"#PENALTIS_PARADOS:"+this.getPenaltisParados();
	}
	
	

}
