package com.daw;

import java.util.Comparator;

public class ComparadorfechaYPeso implements Comparator<Figura>{

	@Override
	public int compare(Figura o1, Figura o2) {
		if (o1.getFechaRegistro().equals(o2.getFechaRegistro())) {
			return - o1.getPeso().compareTo(o2.getPeso());
		}else {
			return - o1.getFechaRegistro().compareTo(o2.getFechaRegistro());
		}
		
	}

}
