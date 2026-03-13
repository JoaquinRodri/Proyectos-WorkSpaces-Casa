package com.daw;

import java.util.Comparator;

public class ComparadorFechaYEdad implements Comparator<Animal> {

	@Override
	public int compare(Animal o1, Animal o2) {
		if (o1.getFechaIngreso().compareTo(o2.getFechaIngreso()) == 0) {
			return o1.getEdad().compareTo(o2.getEdad());
		}else {
			return - o1.getFechaIngreso().compareTo(o2.getFechaIngreso());
		}
		
	}

}
