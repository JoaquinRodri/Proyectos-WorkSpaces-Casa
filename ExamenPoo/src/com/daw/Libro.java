package com.daw;

public class Libro extends Material {
	
	private String isbn;
	private Integer numeroPaginas;
	private Formato formato;
	
	
	public Libro(String codigo, String titulo, String autor, Integer anioPublicacion, Boolean disponible, String isbn,
			Integer numeroPaginas, Formato formato) {
		super(codigo, titulo, autor, anioPublicacion, disponible);
		this.isbn = isbn;
		this.numeroPaginas = numeroPaginas;
		this.formato = formato;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}


	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}


	public Formato getFormato() {
		return formato;
	}


	public void setFormato(Formato formato) {
		this.formato = formato;
	}
	
	public String toString() {
		String aux = "\nISBN: "+getIsbn()+"\r\n"
				+ "Número de páginas: "+getNumeroPaginas()+"\r\n"
				+ "Formato: "+getFormato()+"";
		return super.toString()+aux;
	}


	

	

}
