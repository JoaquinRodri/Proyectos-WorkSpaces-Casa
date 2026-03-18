package videoJuegos;

import java.util.Comparator;

public class ComparadorPorFechaYPrecio implements Comparator<VideoJuego> {

	@Override
	public int compare(VideoJuego o1, VideoJuego o2) {
		if (o1.getFechaAlta().equals(o2.getFechaAlta())) {
			return o1.getPrecioAlquiler().compareTo(o2.getPrecioAlquiler());
		}
		return - o1.getFechaAlta().compareTo(o2.getFechaAlta());
	}

	

}
