package com.daw;

public class Producto {
	
	private String codigo;
	private String descripcion;
	private Integer stock;
	
	
	public Producto(String codigo, String descripcion, Integer stock) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.stock = stock;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Integer getStock() {
		return stock;
	}


	public void setStock(Integer stock) {
		this.stock = stock;
	}


	@Override
	public String toString() {
		return this.codigo+"#"+this.descripcion+"#"+this.stock;
	}
	
	
	

}
