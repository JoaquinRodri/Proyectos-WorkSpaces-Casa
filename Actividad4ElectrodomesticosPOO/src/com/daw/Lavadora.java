package com.daw;

public class Lavadora extends Electrodomestico{
	
	private float carga;
	private static final float CARGA = 5f;
	
	public Lavadora() {
		super();
		this.carga = CARGA;
	}
	
	public Lavadora(float precio, float peso) {
		super(precio, peso);
		this.carga = CARGA;
	}

	public Lavadora(float precio, String color, char consumoEnergetico, float peso, float carga) {
		super(precio, color, consumoEnergetico, peso);
		this.carga = carga;
	}

	public float getCarga() {
		return carga;
	}
	
	@Override
	public float precioFinal() {
		float precio = super.precioFinal();
		if (this.carga > 30) {
			precio += 50 ;
		}
		return precio;
		
	}

	@Override
	public String toString() {
		return "Lavadora [carga=" + carga + ", precio_base=" + precio_base + ", color=" + color
				+ ", consumo_energetico=" + consumo_energetico + ", peso=" + peso + "]";
	}
	
	
	

}
