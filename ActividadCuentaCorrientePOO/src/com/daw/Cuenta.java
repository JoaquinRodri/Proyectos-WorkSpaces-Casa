package com.daw;

public class Cuenta {
	
	//ATRIBUTOS
	private String titular;
	private double cantidad;
	
	//CONSTRUCTORES
	public Cuenta(String titular) {
		this.titular = titular;
	}


	public Cuenta(String titular, double cantidad) {
		super();
		this.titular = titular;
		if (cantidad>0) {
			this.cantidad = cantidad;
		}
		
	}

	//GET Y SET
	public String getTitular() {
		return titular;
	}


	public void setTitular(String titular) {
		this.titular = titular;
	}


	public double getCantidad() {
		return cantidad;
	}


	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	
	@Override
	public String toString() {
		
		return "titular: "+this.titular+"\nSaldo actual: "+this.cantidad+" euros.";
		
	}
	
	//METODOS
	
	public void ingresar(double cantidad) {
		if (cantidad>0) {
			this.cantidad += cantidad;
			System.out.println("Cantidad ingresada correctamente.");
		}else {
			System.out.println("Ingreso no valido, no se puede ingresar una cantidad negativa.");
		}
		System.out.println();
	}
	
	public void retirar(double cantidad) {
		if (this.cantidad>0) {
			if (this.cantidad-cantidad < 0) {
				this.cantidad = 0;
			}else {
				this.cantidad -= cantidad;
			}
			System.out.println("Cantidad retirada correctamente");
		}else {
			System.out.println("No se puede retirar dinero la cuenta esta a 0");
		}
		System.out.println();
		
	}
	
	
	

}
