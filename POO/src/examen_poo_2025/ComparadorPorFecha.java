package examen_poo_2025;

import java.util.Comparator;

public class ComparadorPorFecha implements Comparator<Apunte> {

	@Override
	public int compare(Apunte o1, Apunte o2) {
		if (o1.getFecha().getAnyo()== o2.getFecha().getAnyo()) {
			if (o1.getFecha().getMes()== o2.getFecha().getMes()) {
				if (o1.getFecha().getDia()== o2.getFecha().getDia()) {
					return 0;
				}else {
					return o1.getFecha().getDia()- o2.getFecha().getDia();
				}
			}else {
				return o1.getFecha().getMes()- o2.getFecha().getMes();
			}
		}else {
			return o1.getFecha().getAnyo()- o2.getFecha().getAnyo();
		}
		
		
	}

}
