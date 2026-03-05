package examen_poo_2025;

public class Contabilidad {

	public static void main(String[] args) {
		
		Ejercicio e1 = new Ejercicio(2024);
		
		Apunte a1 = new Pago("Electricidad y Gas", new Fecha(2024,01,02), 325.8, TipoOperacion.TARJETA, "Repsol SLU");
		Apunte a2 = new Pago("Electricidad y Gas", new Fecha(2024,02,02), 316.4, TipoOperacion.TARJETA, "Repsol SLU");
		Apunte a3 = new Pago("Electricidad y Gas", new Fecha(2024,03,02), 290.8, TipoOperacion.TARJETA, "Repsol SLU");
		Apunte a4 = new Pago("Electricidad y Gas", new Fecha(2024,04,02), 370.6, TipoOperacion.TARJETA, "Repsol SLU");
		Apunte a5 = new Pago("Tornillos", new Fecha(2024,1,10), 567.25, TipoOperacion.EFECTIVO, "Antonio Tornillos.S.L", 5);
		Apunte a6 = new Pago("Tornillos", new Fecha(2024,2,10), 450.5, TipoOperacion.EFECTIVO, "Antonio Tornillos.S.L");
		Apunte a7 = new Pago("Tornillos", new Fecha(2024,3,15), 399.0, TipoOperacion.EFECTIVO, "Antonio Tornillos.S.L", 5);
		Apunte a8 = new Pago("Tornillos", new Fecha(2024,4,8), 560.5, TipoOperacion.EFECTIVO, "Antonio Tornillos.S.L", 3);
		Apunte a9 = new Cobro("Puertas", new Fecha(2024,01,15), 200D, TipoOperacion.EFECTIVO, "CCAD S.L", 30);
		Apunte a10 = new Cobro("Ventanas", new Fecha(2024,01,15), 750D, TipoOperacion.EFECTIVO, "CCAD S.L", 50);
		Apunte a11 = new Cobro("Puertas", new Fecha(2024,03,15), 200D, TipoOperacion.EFECTIVO, "Construcciones Martinsa S.L");
		
		
		e1.addApunte(a1);
		e1.addApunte(a2);
		e1.addApunte(a3);
		e1.addApunte(a4);
		e1.addApunte(a5);
		e1.addApunte(a6);
		e1.addApunte(a7);
		e1.addApunte(a8);
		e1.addApunte(a9);
		e1.addApunte(a10);
		e1.addApunte(a11);
		
		e1.imprimirApuntesOrdenadosPorFechaAscendente();
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");

		e1.imprimirApuntesOrdenadosPorImporteDescendente();
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		e1.imprimirContabilidadEjercicio();

	}

}
