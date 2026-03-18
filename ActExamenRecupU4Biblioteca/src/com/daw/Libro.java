package com.daw;

import java.time.LocalDate;

public abstract class Libro implements InterfazBiblioteca, Comparable<Libro>{
	
	private String codigo;
	private String titulo;
	private String autor;
	private LocalDate fechaPublicacion;
	private Idioma idioma;
	private Integer numeroPaginas;
	
	public Libro(String codigo, String titulo, String autor, LocalDate fechaPublicacion, Idioma idioma,
			Integer numeroPaginas) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.autor = autor;
		this.fechaPublicacion = fechaPublicacion;
		this.idioma = idioma;
		this.numeroPaginas = numeroPaginas;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public LocalDate getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(LocalDate fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public Idioma getIdioma() {
		return idioma;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	@Override
	public abstract String getDescripcion();
	
	public abstract String formatoImprimir();
	
	public abstract String formatoGuardar();
	
	@Override
	public int compareTo(Libro o) {
		if (this.getTitulo().equals(o.getTitulo())) {
			return - this.getFechaPublicacion().compareTo(o.getFechaPublicacion());
		}
		return this.getTitulo().compareTo(o.getTitulo());
	}
	

}
