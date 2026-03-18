package com.daw;

import java.util.Comparator;

public class ComparadorPorFechaYNumPaginas implements Comparator<Libro> {

	@Override
	public int compare(Libro o1, Libro o2) {
		if (o1.getFechaPublicacion().equals(o2.getFechaPublicacion())) {
			return o1.getNumeroPaginas().compareTo(o2.getNumeroPaginas());
		}
		return - o1.getFechaPublicacion().compareTo(o2.getFechaPublicacion());
	}

}
