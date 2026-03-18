package com.daw;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cuento extends Libro {
	
	private String tipoIlustracion;

	public Cuento(String codigo, String titulo, String autor, LocalDate fechaPublicacion, Idioma idioma,
			Integer numeroPaginas, String tipoIlustracion) {
		super(codigo, titulo, autor, fechaPublicacion, idioma, numeroPaginas);
		this.tipoIlustracion = tipoIlustracion;
	}
	
	

	public String getTipoIlustracion() {
		return tipoIlustracion;
	}



	public void setTipoIlustracion(String tipoIlustracion) {
		this.tipoIlustracion = tipoIlustracion;
	}



	@Override
	public String getDescripcion() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return this.getTitulo()+" de "+this.getAutor()+" publicado el "+this.getFechaPublicacion().format(formato)+" tipo de ilustracion "+this.getTipoIlustracion();
	}

	@Override
	public String formatoImprimir() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "CUENTO - CÓDIGO: "+this.getCodigo()+" - TÍTULO: "+this.getTitulo()+" - AUTOR: "+this.getAutor()+" - FECHA PUBLICACIÓN: "+this.getFechaPublicacion().format(formato)+" - IDIOMA: "+this.getIdioma()+" - PÁGINAS: "+this.getNumeroPaginas()+" - ILUSTRACIÓN: "+this.getTipoIlustracion();
	}

	@Override
	public String formatoGuardar() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "CUENTO#CODIGO:"+this.getCodigo()+"#TITULO:"+this.getTitulo()+"#AUTOR:"+this.getAutor()+"#FECHA PUBLICACIÓN:"+this.getFechaPublicacion().format(formato)+"#IDIOMA:"+this.getIdioma()+"#NÚMERO PÁGINAS:"+this.getNumeroPaginas()+"#TIPO ILUSTRACIÓN:"+this.getTipoIlustracion();
	}



	

}
