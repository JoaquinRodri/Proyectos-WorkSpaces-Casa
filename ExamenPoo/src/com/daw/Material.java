package com.daw;

public abstract class Material implements Prestable, Comparable<Material>{
	
	private String codigo;
	private String titulo;
	private String autor;
	private Integer anioPublicacion;
	private Boolean disponible;
	
	public Material(String codigo, String titulo, String autor, Integer anioPublicacion, Boolean disponible) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.autor = autor;
		this.anioPublicacion = anioPublicacion;
		this.disponible = disponible;
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

	public Integer getAnioPublicacion() {
		return anioPublicacion;
	}

	public void setAnioPublicacion(Integer anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}

	public Boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}
	
	public String toString() {
		String resp = "No";
		if (isDisponible()) {
			resp = "Si";
		}
		String mostrar = "\r\nCodigo: "+getCodigo()+"\r\n"
				+ "Título: "+getTitulo()+"\r\n"
				+ "Autor: "+getAutor()+"\r\n"
				+ "Año de Publicación: "+getAnioPublicacion()+"\r\n"
				+ "Disponible: "+resp+"";
		return mostrar;
	}

	@Override
	public int compareTo(Material o) {
		
		return this.titulo.compareTo(o.getTitulo());
	}
	
	@Override
	public void prestar(Usuario usuario) {
		usuario.getMaterialesPrestados().add(this);
		setDisponible(false);
	}


	@Override
	public void devolver() {
		this.setDisponible(true);
		
	}


	@Override
	public Boolean estaPrestado() {
		if (isDisponible()) {
			return false;
		}
		return true;
	}
	

}
