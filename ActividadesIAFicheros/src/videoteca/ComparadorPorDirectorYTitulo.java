package videoteca;

import java.util.Comparator;

public class ComparadorPorDirectorYTitulo implements Comparator<Contenido> {

	@Override
	public int compare(Contenido o1, Contenido o2) {
		if (o1.getDirector().equals(o2.getDirector())) {
			return - o1.getTitulo().compareTo(o2.getTitulo());
		}else {
			return o1.getDirector().compareTo(o2.getDirector());
		}
		
	}

}
