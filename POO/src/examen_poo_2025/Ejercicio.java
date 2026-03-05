package examen_poo_2025;

import java.util.ArrayList;
import java.util.Collections;

public class Ejercicio {
	
	private int anyo;
	private ArrayList<Apunte> apuntes;
	
	
	
	public Ejercicio(int anyo) {
		this.anyo = anyo;
		this.apuntes = new ArrayList<>();
	}

	public void addApunte(Apunte apunte) {
		this.apuntes.add(apunte);
	}
	
	public void imprimirApuntesOrdenadosPorImporteDescendente() {
		ArrayList<Apunte> mod = this.apuntes;
		Collections.sort(mod, new ComparadorPorImporte());
		System.out.println("[");
		for (int i = 0; i < mod.size()-1; i++) {
			System.out.println(mod.get(i)+",");
		}
		System.out.println(mod.getLast()+"]");
		
	}
	
	public void imprimirApuntesOrdenadosPorFechaAscendente() {
		ArrayList<Apunte> mod = this.apuntes;
		Collections.sort(mod);
		System.out.println("[");
		for (int i = 0; i < mod.size()-1; i++) {
			System.out.println(mod.get(i)+",");
		}
		System.out.println(mod.getLast()+"]");
	}

	public void imprimirContabilidadEjercicio() {
		System.out.println("--------------------------------------------------------------");
		System.out.println("Contabilidad año "+anyo);
		System.out.println("--------------------------------------------------------------");
		
		double totalAño = 0;
		
		for (int i = 1; i < 13; i++) {
			String mes = "";
			boolean hay = hayApunte(i);
			double totalMes = 0;
			if (hay) {
				ArrayList<Apunte> apuntesMes= recogerApuntes(i);
				mes = meses(i);
				System.out.println(mes+":\n");
				mostrarMes(apuntesMes);
				totalMes = total(apuntesMes);
				System.out.println("Total "+mes+": "+totalMes+"\n");
				totalAño += totalMes;
			}
			
		}
		System.out.println("--------------------------------------------------------------");
		System.out.println("Total año: "+totalAño);
		System.out.println("--------------------------------------------------------------");
		
	
}

	private double total(ArrayList<Apunte> apuntesMes) {
		double total = 0;
		for (Apunte apunte : apuntesMes) {
			total += apunte.getImporte();
		}
		return total;
	}

	private String meses(int i) {
		switch (i) {
		case 1:
			return "Enero";
		case 2:
			return "Febrero";

		case 3:
			return "Marzo";

		case 4:
			return "Abril";

		case 5:
			return "Mayo";

		case 6:
			return "Junio";

		case 7:
			return "Julio";

		case 8:
			return "Agosto";

		case 9:
			return "Septiembre";

		case 10:
			return "Octubre";

		case 11:
			return "Noviembre";

		case 12:
			return "Diciembre";

		}
		return null;
	}

	private void mostrarMes(ArrayList<Apunte> apuntesMes) {
		Collections.sort(apuntesMes, new ComparadorPorFecha());
		for (Apunte apunte : apuntesMes) {
			System.out.println(apunte+"\n");
			
		}
		
	}

	private ArrayList<Apunte> recogerApuntes(int i) {
		ArrayList<Apunte> resul = new ArrayList<>();
		for (Apunte apunte : this.apuntes) {
			if (apunte.getFecha().getMes() == i) {
				resul.add(apunte);
			}
		}
		return resul;
	}

	private boolean hayApunte(int i) {
		for (Apunte apunte : apuntes) {
			if (i==apunte.getFecha().getMes()) {
				return true;
			}
		}
		return false;
	}

}
