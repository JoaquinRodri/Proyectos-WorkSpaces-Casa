package videoJuegos;

import java.time.LocalDate;

public interface InterfazVideoJuego {

	String getCodigo();
	String getTitulo();
	LocalDate getFechaAlta();
	Float getPrecioAlquiler();
	String getDescripcion();
	
}
