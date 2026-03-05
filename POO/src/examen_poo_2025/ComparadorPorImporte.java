package examen_poo_2025;

import java.util.Comparator;

public class ComparadorPorImporte implements Comparator<Apunte> {

	@Override
	public int compare(Apunte o1, Apunte o2) {
		if (o1.getImporte()>o2.getImporte()) {
			return -1;
		}else if (o1.getImporte()<o2.getImporte()) {
			return 1;
		}else {
			return 0;
		}
		
		
	}

}
