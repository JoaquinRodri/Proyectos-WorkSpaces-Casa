package com.daw;

import java.util.Comparator;

public class ComparadorPorAutorYTitulo implements Comparator<Material> {

	@Override
	public int compare(Material o1, Material o2) {
		if (o1.getAutor().equals(o2.getAutor())) {
			return - o1.getTitulo().compareTo(o2.getTitulo());
		}else {
			return o1.getAutor().compareTo(o2.getAutor());
		}
		
	}
}
