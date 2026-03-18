package com.daw;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NovelaInfantil extends Libro{
	
	private String genero;

	public NovelaInfantil(String codigo, String titulo, String autor, LocalDate fechaPublicacion, Idioma idioma,
			Integer numeroPaginas, String genero) {
		super(codigo, titulo, autor, fechaPublicacion, idioma, numeroPaginas);
		this.genero = genero;
	}
	
	

	public String getGenero() {
		return genero;
	}



	public void setGenero(String genero) {
		this.genero = genero;
	}



	@Override
	public String getDescripcion() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return this.getTitulo()+" de "+this.getAutor()+" publicado el "+this.getFechaPublicacion().format(formato)+" tipo de genero "+this.getGenero();
	}

	@Override
	public String formatoImprimir() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "NOVELA INFANTIL - CÓDIGO: "+this.getCodigo()+" - TÍTULO: "+this.getTitulo()+" - AUTOR: "+this.getAutor()+" - FECHA PUBLICACIÓN: "+this.getFechaPublicacion().format(formato)+" - IDIOMA: "+this.getIdioma()+" - PÁGINAS: "+this.getNumeroPaginas()+" - GENERO: "+this.getGenero();
	}

	@Override
	public String formatoGuardar() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "NOVELA INFANTIL#CODIGO:"+this.getCodigo()+"#TITULO:"+this.getTitulo()+"#AUTOR:"+this.getAutor()+"#FECHA PUBLICACIÓN:"+this.getFechaPublicacion().format(formato)+"#IDIOMA:"+this.getIdioma()+"#NÚMERO PÁGINAS:"+this.getNumeroPaginas()+"#TIPO GENERO:"+this.getGenero();
	}

}
