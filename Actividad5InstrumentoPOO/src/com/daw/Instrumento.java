package com.daw;

public abstract class Instrumento {
	
	protected enumNotas [] notasMusicales;
	protected int contadorNotas;
	
	public Instrumento() {
		this.notasMusicales = new enumNotas[6];
		contadorNotas = 0;
	}
	
	public void add(enumNotas nota) {
		if (contadorNotas<6) {
			notasMusicales[contadorNotas]=nota;
			contadorNotas++;
		}else {
			System.out.println("No se pueden añadir mas notas.");
		}
	}
	
	public abstract void interpretar();

}
