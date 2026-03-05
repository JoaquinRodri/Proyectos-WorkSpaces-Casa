package com.daw;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		
		List<Integer> lista = new ArrayList<>();
		
		Integer num = (int)(Math.random()*100);
		lista.add(num);
		
		for (int i = 0; i < 19; i++) {
			boolean anadido = false;
			num = (int)(Math.random()*100);
			for (int j = 0; j < i; j++) {
				if (num>lista.get(j)) {
					lista.add(j, num);;
					anadido = true;
					break;
				}
			}
			if (!anadido) {
				lista.add(i, num);
			}
			
		}
		
		System.out.println(lista);

	}

}
