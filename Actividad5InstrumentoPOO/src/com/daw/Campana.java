package com.daw;

public class Campana extends Instrumento{

	
	public Campana() {
		super();
	}
	
	@Override
	public void interpretar() {
		System.out.println("Notas Campana:");
		for (int i = 0; i < contadorNotas; i++) {
			System.out.print(notasMusicales[i]+ " ");
		}
		System.out.println();
		
	}

}
