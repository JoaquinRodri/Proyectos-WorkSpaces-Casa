package flota_reparto;

import java.util.Comparator;

public class ComparadorPorVarios implements Comparator<Envio> {

	@Override
	public int compare(Envio o1, Envio o2) {
		if (o1.getZona().name().equals(o2.getZona().name())) {
			if (o1.calcularCoste()==o2.calcularCoste()) {
				if (o1.getIncidencias().size()==o2.getIncidencias().size()) {
					return 0;
				}else{
					return o1.getIncidencias().size()-o2.getIncidencias().size();
				}
			}else{
				return (int) (o2.calcularCoste()-o1.calcularCoste());
			}
		}else {
			return o2.getZona().name().compareTo(o1.getZona().name());
		}
	}

}
