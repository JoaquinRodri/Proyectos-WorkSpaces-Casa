package videoteca;

import java.util.Comparator;

public class ComparadorPorAnio implements Comparator<Contenido> {

	@Override
	public int compare(Contenido o1, Contenido o2) {
		// TODO Auto-generated method stub
		return - o1.getAnioPublicacion().compareTo(o2.getAnioPublicacion());
	}

}
