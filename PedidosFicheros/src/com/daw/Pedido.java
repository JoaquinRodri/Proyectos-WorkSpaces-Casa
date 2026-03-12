package com.daw;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
	
	private Integer id;
	private LocalDate fecha;
	private Cliente cliente;
	private List<LineaPedido> lineaPedido;
	
	public Pedido(Integer id, LocalDate fecha, Cliente cliente) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.cliente = cliente;
		this.lineaPedido = new ArrayList<LineaPedido>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<LineaPedido> getLineaPedido() {
		return lineaPedido;
	}

	public void setLineaPedido(List<LineaPedido> lineaPedido) {
		this.lineaPedido = lineaPedido;
	}
	
	public void addLineaPedido(LineaPedido lineaPedido) {
		this.lineaPedido.add(lineaPedido);
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", fecha=" + fecha + ", cliente=" + cliente + ", \nlineaPedido=" + lineaPedido + "]";
	}
	
	

}
