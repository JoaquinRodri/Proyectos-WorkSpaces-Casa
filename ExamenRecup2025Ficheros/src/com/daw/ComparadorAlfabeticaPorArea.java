package com.daw;

import java.util.Comparator;

public class ComparadorAlfabeticaPorArea implements Comparator<Figura> {

	@Override
	public int compare(Figura o1, Figura o2) {
		if (o1.getClass().getSimpleName().compareToIgnoreCase(o2.getClass().getSimpleName())==0) {
			return - o1.getArea().compareTo(o2.getArea());
		}else {
			return o1.getClass().getSimpleName().compareToIgnoreCase(o2.getClass().getSimpleName());
		}
		
	}

}
