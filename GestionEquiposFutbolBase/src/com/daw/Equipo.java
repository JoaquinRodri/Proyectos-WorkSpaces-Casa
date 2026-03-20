package com.daw;

import java.util.ArrayList;
import java.util.List;

public class Equipo implements Comparable<Equipo>{
	
	private NombreEquipo nombre;
	private List<Jugador> jugadores;
	
	public Equipo(NombreEquipo nombre) {
		this.nombre = nombre;
		this.jugadores = new ArrayList<>();
	}

	public NombreEquipo getNombre() {
		return nombre;
	}

	public void setNombre(NombreEquipo nombre) {
		this.nombre = nombre;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	
	public void addJugador(Jugador jugador) {
		this.jugadores.add(jugador);
	}

	@Override
	public int compareTo(Equipo o) {
		return - this.getNombre().compareTo(o.getNombre());
	}	

}
