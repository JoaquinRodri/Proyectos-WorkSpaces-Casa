package com.daw;

public class Piano extends Instrumento{
	
	public Piano() {
		super();
	}

	@Override
	public void interpretar() {
		System.out.println("Notas Piano:");
		for (int i = 0; i < contadorNotas; i++) {
			System.out.print(notasMusicales[i]+ " ");
		}
		System.out.println();
		
	}

}
