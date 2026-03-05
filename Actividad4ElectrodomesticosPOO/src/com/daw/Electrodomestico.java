package com.daw;

public class Electrodomestico {
	
	protected float precio_base;
	protected String color;
	protected char consumo_energetico;
	protected float peso;
	
	private static final String BLANCO = "blanco";
	private static final char ENTREAYF = 'F';
	private static final float BASE = 100.0f;
	private static final float PESO = 5.0f;
	

	public Electrodomestico() {
		this.color = BLANCO;
		this.consumo_energetico = ENTREAYF;
		this.precio_base = BASE;
		this.peso = PESO;
	}
	
	public Electrodomestico(float precio, float peso) {
		this.precio_base = precio;
		this.peso = peso;
		this.color = BLANCO;
		this.consumo_energetico = ENTREAYF;
	}
	
	public Electrodomestico(float precio, String color, char consumoEnergetico, float peso) {
		this.precio_base = precio;
		this.color = comprobarColor(color);
		this.consumo_energetico = comprobarConsumoEnergetico(consumoEnergetico);
		this.peso = peso;
	}
	
	//geters

	public float getPrecio_base() {
		return precio_base;
	}

	public String getColor() {
		return color;
	}

	public char getConsumo_energetico() {
		return consumo_energetico;
	}

	public float getPeso() {
		return peso;
	}

	
	//metodos
	
	private char comprobarConsumoEnergetico(char letra) {
		String consumoPermitido = "ABCDEF";
		if (consumoPermitido.indexOf(letra) != -1) {
			return letra;
		}
		
		return ENTREAYF;
	}
	
	private String comprobarColor(String color) {
		String coloresPermitidos = " blanco negro rojo azul gris ";
		if (coloresPermitidos.indexOf(" "+color.toLowerCase()+" ") != -1) {
			return color;
		}
		
		return BLANCO;
	}
	
	public float precioFinal() {
		char consumo = this.consumo_energetico;
		float precio = 0;
		float peso = this.peso;
		
		switch (consumo) {
		case 'A':
			precio += 100;
			break;
		case 'B':
			precio += 80;
			break;
		case 'C':
			precio += 60;
			break;
		case 'D':
			precio += 50;
			break;
		case 'E':
			precio += 30;
			break;
		case 'F':
			precio += 10;
			break;
		default:
			break;
		}
		
		if (peso >0 && peso<=19) {
			precio += 10;
		}else if (peso >= 20 && peso<=49) {
			precio += 50;
		}else if (peso >=50 && peso<=79) {
			precio += 80;
		}else if (peso > 79) {
			precio += 100;
		}
		
		precio += this.precio_base;
			
		return precio;
		
		
	}

	@Override
	public String toString() {
		return "Electrodomestico [precio_base=" + this.precio_base + ", color=" + this.color + ", consumo_energetico="
				+ this.consumo_energetico + ", peso=" + this.peso + "]";
	}
	

}
