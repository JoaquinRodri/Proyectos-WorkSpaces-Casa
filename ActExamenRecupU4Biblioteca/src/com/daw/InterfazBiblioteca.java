package com.daw;

import java.time.LocalDate;

public interface InterfazBiblioteca {
	
	String getCodigo();
	String getTitulo();
	String getAutor();
	LocalDate getFechaPublicacion();
	String getDescripcion();

}
