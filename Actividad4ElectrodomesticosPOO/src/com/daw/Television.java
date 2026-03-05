package com.daw;

public class Television extends Electrodomestico{
	
	private int resolucion;
	private boolean sintonizadorTdt;
	
	private static final int RESOLUCION = 20;
	private static final boolean SINTONIZADOR = false;
	
	public Television() {
		super();
		this.resolucion = RESOLUCION;
		this.sintonizadorTdt = SINTONIZADOR;
	}
	
	public Television(float precio, float peso) {
		super(precio, peso);
		this.resolucion = RESOLUCION;
		this.sintonizadorTdt = SINTONIZADOR;
	}

	public Television(float precio, String color, char consumoEnergetico, float peso, int resolucion,
			boolean sintonizadorTdt) {
		super(precio, color, consumoEnergetico, peso);
		this.resolucion = resolucion;
		this.sintonizadorTdt = sintonizadorTdt;
	}

	public int getResolucion() {
		return resolucion;
	}

	public boolean isSintonizadorTdt() {
		return sintonizadorTdt;
	}
	
	//Metodos.
	
	@Override
	public float precioFinal() {
		float precio = super.precioFinal();
		
		if (this.resolucion > 40) {
			precio += (this.precio_base*0.3);
		}
		if (this.sintonizadorTdt) {
			precio += 50;
		}
		return precio;
		
	}

	@Override
	public String toString() {
		return "Television [resolucion=" + resolucion + ", sintonizadorTdt=" + sintonizadorTdt + ", precio_base="
				+ precio_base + ", color=" + color + ", consumo_energetico=" + consumo_energetico + ", peso=" + peso
				+ "]";
	}
	
	
	

}
