package com.daw;

import java.util.Comparator;

public class ComparadorPorAnio implements Comparator<Material> {

	@Override
	public int compare(Material o1, Material o2) {
		
		return - o1.getAnioPublicacion().compareTo(o2.getAnioPublicacion());
	}

}
