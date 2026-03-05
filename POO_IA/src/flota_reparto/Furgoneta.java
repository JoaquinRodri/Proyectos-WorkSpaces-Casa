package flota_reparto;

import java.util.ArrayList;

public class Furgoneta extends Transporte {
	
	private boolean refrigerada;
	private double plusRefrigeracion;

	public Furgoneta(String matricula, double costeKmBase, double capacidadKg, boolean refrigerada, double plusRefrigerada) {
		super(matricula, costeKmBase, capacidadKg);
		this.refrigerada = refrigerada;
		this.plusRefrigeracion = plusRefrigerada;
	}
	
	

	public boolean isRefrigerada() {
		return refrigerada;
	}



	public void setRefrigerada(boolean refrigerada) {
		this.refrigerada = refrigerada;
	}



	public double getPlusRefrigeracion() {
		return plusRefrigeracion;
	}



	public void setPlusRefrigeracion(double plusRefrigeracion) {
		this.plusRefrigeracion = plusRefrigeracion;
	}



	@Override
	public double calcularCosteViaje(double km, double kg) {
		double suple = 0;
		if (super.admitecarga(kg)) {
			suple = 30;
		}
		return super.costeBase(km)+this.recargoRefrigeracion(km)+suple;
	}
	
	public double recargoRefrigeracion(double km) {
		if (km >200) {
			return 50;
		}else if (km > 100) {
			return 25;
		}else {
			return 5;
		}
	}
	
	public boolean requiereCadenaFrio(ArrayList<Incidencia> incidencias) {
		for (Incidencia incidencia : incidencias) {
			if (incidencia.name().equals(Incidencia.RETRASO.name())) {
				return true;
			}
		}
		return false;
	}



	@Override
	public String toString() {
		return "Furgoneta (matricula "+super.getMatricula()+") | Refrigerada=" + refrigerada+"coste";
	}
	
	

}
