package com.daw;

import java.time.LocalDate;

public interface InterfazJugadores {

	String getNombre();
	LocalDate getFechaNacimiento(); //devuelve la fecha formateada 01/12/2000.
	Integer getPartidosJugados();// devuelve el valor de los partidos jugados.
	Integer getTarjetasAmarillas();// devuelve el valor de las tarjetas amarillas.
	Integer getTarjetasRojas(); //devuelve el valor de las tarjetas rojas.
	String getDemarcacion(); //devuelve una cadena con la demarcación (PORTERO o JUGADOR DE CAMPO).
	String getEstadisticas();
	
}
