package taller_la_giralda;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		
		Coche coche1 = new Coche("1234ABC", "Seat", 2018, 85000, 5, true);

		Coche coche2 = new Coche("5678DEF", "Toyota", 2020, 42000, 3, false);

		Coche coche3 = new Coche("9012GHI", "BMW", 2016, 150000, 5, true);

		// MOTOS
		Moto moto1 = new Moto("M1111", "Yamaha", 2019, 30000, 125);

		Moto moto2 = new Moto("M2222", "Honda", 2017, 65000, 500);

		Moto moto3 = new Moto("M3333", "Kawasaki", 2021, 18000, 750);
		
		Vehiculo [] vehiculos = new Vehiculo[6];
		
		vehiculos[0] = coche1;
		vehiculos[1] = coche2;
		vehiculos[2] = coche3;
		vehiculos[3] = moto1;
		vehiculos[4] = moto2;
		vehiculos[5] = moto3;
		
		OrdenReparacion orden1 = new OrdenReparacion(coche1, 5.5f, 35f, tipoAveria.ELECTRICA);
		OrdenReparacion orden2 = new OrdenReparacion(moto1, 3f, 30f, tipoAveria.ACEITE);
		OrdenReparacion orden3 = new OrdenReparacion(coche2, 4f, 35f, tipoAveria.RUEDAS);
		OrdenReparacion orden4 = new OrdenReparacion(coche3, 4f, 35f, tipoAveria.RUEDAS);
		OrdenReparacion orden5 = new OrdenReparacion(moto3, 4f, 35f, tipoAveria.RUEDAS);
		OrdenReparacion orden6 = new OrdenReparacion(moto2, 4f, 35f, tipoAveria.RUEDAS);
		
		OrdenReparacion [] ordenes = {orden1, orden2, orden3, orden4, orden5, orden6};	

		//apartado 1.
		muestratotalOrdenes(ordenes);

		//apartado 2.
		calculaMediaOrdenes(ordenes);

		//apartado 3.
		vehiculoMayorCoste(ordenes);
		
		//apartado 4.
		System.out.println("El tipo de averia mas frecuente entre las ordenes es "+averiasMasFrecuentes(ordenes));
		
		
		//Apartado extra 1: Devolver los datos de la moto con mayor cilindrada.
		Moto MayorCilindrada = mayorCC(vehiculos);
		System.out.println("La moto con mayor cilindradas es: "+MayorCilindrada);
		
		//Apartado extra 2: Meter más ordenes (hasta 6). Llamar a método del apartado 4. 
		//Modificar la matrícula de los vehículos cuyo tipo de averia es la del apartado 4. Añadir "-" entre los números y letras.
		//Ejemplo: 1234AAA cambia a: 1234-AAA y M1234 cambia a M-1234
		modificarMatricula(ordenes);
		
		System.out.println(Arrays.toString(ordenes));
		
		

	}
	public static void modificarMatricula(OrdenReparacion[] ordenes) {
		
		for (int i = 0; i < ordenes.length; i++) {
			if (ordenes[i].getTipoAveria().name().equals(averiasMasFrecuentes(ordenes))) {
				if (ordenes[i].getVehiculo() instanceof Coche) {
					Coche c = (Coche) ordenes[i].getVehiculo();
					c.setMatricula(c.getMatricula().substring(0,4)+"-"+c.getMatricula().substring(4));
				}
				if (ordenes[i].getVehiculo() instanceof Moto) {
					Moto m = (Moto) ordenes[i].getVehiculo();
					m.setMatricula(m.getMatricula().substring(0,1)+"-"+m.getMatricula().substring(1));
				}
			}
		}
		
	}
	
	public static Moto mayorCC(Vehiculo[] vehiculos) {
		int posicionMoto = 0;
		int ccc = 0;
		for (int i = 0; i < vehiculos.length; i++) {
			if (vehiculos[i] instanceof Moto) {
				Moto m = (Moto) vehiculos[i];
				if (m.getCilindradas()>ccc) {
					posicionMoto = i;
					ccc = m.getCilindradas();
				}
			}
		}
		
		return (Moto) vehiculos[posicionMoto];
	}
	public static String averiasMasFrecuentes(OrdenReparacion[] ordenes) {
		int [] numeroAverias = new int [4];
		String [] nAverias = new String [4];
		nAverias [0] = "ELECTRICA";
		nAverias [1] = "ACEITE";
		nAverias [2] = "RUEDAS";
		nAverias [3] = "FRENOS";
		
		for (int i = 0; i < nAverias.length; i++) {
			int contador = 0;
			for (int j = 0; j < ordenes.length; j++) {
				if (nAverias[i].equals(ordenes[j].getTipoAveria().name())) {
					contador++;
					
				}
			}
			numeroAverias[i]= contador;
		}
		
		
		
		int numMaximoA = 0;
		String averia = "";
		for (int i = 0; i < numeroAverias.length; i++) {
			if (numeroAverias[i]>numMaximoA) {
				numMaximoA = numeroAverias[i];
				averia = nAverias[i];
			}
		}
		
		return averia;
		
	}
	
	public static void vehiculoMayorCoste(OrdenReparacion[] ordenes) {
		float mayorCoste = 0;
		Vehiculo masCaro = new Vehiculo();
		
		for (int i = 0; i < ordenes.length; i++) {
			if (ordenes[i].calcularTotal()>mayorCoste) {
				mayorCoste = ordenes[i].calcularTotal();
				masCaro = ordenes[i].getVehiculo();
			}
		}
		
		System.out.println("El vehiculo con la reparacion mas cara es: "+masCaro);
	}

	public static void calculaMediaOrdenes(OrdenReparacion[] ordenes) {
		float sumaOrdenes = 0;
		float media = 0;
		for (int i = 0; i < ordenes.length; i++) {
			sumaOrdenes += ordenes[i].calcularTotal();
		}
		media = sumaOrdenes/ordenes.length;
		System.out.println("La media del coste de las ordenes es: "+media);
	}

	public static void muestratotalOrdenes(OrdenReparacion[] ordenes) {
		for (int i = 0; i < ordenes.length; i++) {
			System.out.println(ordenes[i].calcularTotal());
		}
	}

}
