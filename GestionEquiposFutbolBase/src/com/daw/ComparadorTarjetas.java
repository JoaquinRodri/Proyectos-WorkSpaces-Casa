package com.daw;

import java.util.Comparator;

public class ComparadorTarjetas implements Comparator<Jugador> {

	@Override
	public int compare(Jugador o1, Jugador o2) {
		if (o1.getTarjetasRojas() == o2.getTarjetasRojas()) {
			return o1.getTarjetasAmarillas().compareTo(o2.getTarjetasAmarillas());
		}
		return o1.getTarjetasRojas().compareTo(o2.getTarjetasRojas());
	}

}
