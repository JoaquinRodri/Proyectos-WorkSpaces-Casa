package flota_reparto;

import java.util.ArrayList;

public class Envio implements Tarificable, Comparable<Envio>{
	
	private String id;
	private Transporte transporte;
	private double km;
	private double pesoKg;
	private Zona zona;
	private ArrayList<Double> paradasKm;
	private ArrayList<Incidencia> incidencias;
	
	

	public Envio(String id, Transporte transporte, double km, double pesoKg, Zona zona) {
		super();
		this.id = id;
		this.transporte = transporte;
		this.km = km;
		this.pesoKg = pesoKg;
		this.zona = zona;
		this.paradasKm = new ArrayList<Double>();
		this.incidencias = new ArrayList<Incidencia>();
	}

	public Envio(String id, Transporte transporte, double km, double pesoKg, Zona zona, ArrayList<Double> paradasKm,
			ArrayList<Incidencia> incidencias) {
		super();
		this.id = id;
		this.transporte = transporte;
		this.km = km;
		this.pesoKg = pesoKg;
		this.zona = zona;
		this.paradasKm = paradasKm;
		this.incidencias = incidencias;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Transporte getTransporte() {
		return transporte;
	}

	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}

	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		this.km = km;
	}

	public double getPesoKg() {
		return pesoKg;
	}

	public void setPesoKg(double pesoKg) {
		this.pesoKg = pesoKg;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public ArrayList<Double> getParadasKm() {
		return paradasKm;
	}

	public void setParadasKm(ArrayList<Double> paradasKm) {
		this.paradasKm = paradasKm;
	}

	public ArrayList<Incidencia> getIncidencias() {
		return incidencias;
	}

	public void setIncidencias(ArrayList<Incidencia> incidencias) {
		this.incidencias = incidencias;
	}
	
	public double kmReales() {
		double resul = 0;
		if (this.paradasKm.size()>0) {
			for (Double parada : paradasKm) {
				if (parada != null && parada>0) {
					resul += parada;
				}
			}
		}
		
		return resul;
		
	}
	
	public boolean tieneIncidencia(Incidencia inc) {
		for (Incidencia incidencia : incidencias) {
			if (incidencia.name().equals(inc.name())) {
				return true;
			}
		}
		return false;
	}
	
	public int numeroIncidencia() {
		return this.incidencias.size();
	}
	


	@Override
	public double calcularCoste() {
		double suple = 0;
		if (zona.name().equals(Zona.CENTRO.name())) {
			suple += 2;
		}
		for (Incidencia incidencia : incidencias) {
			if (incidencia.name().equals(Incidencia.LLUVIA.name()) || incidencia.name().equals(Incidencia.AVERIA.name())) {
				suple += 4;
			}
			if (incidencia.name().equals(Incidencia.TRAFICO.name()) || incidencia.name().equals(Incidencia.RETRASO.name())) {
				suple += 5;
			}
		}
		return transporte.calcularCosteViaje(this.kmReales(), pesoKg)+suple;
	}

	@Override
	public String desglose() {
		String recargo = "";
		double suple = 0;
		if (transporte instanceof Camion ) {
			Camion c = (Camion) transporte;
			recargo = "2) Recargo por ejes ("+c.getNumEjes()+"): "+c.recargoPorEjes(this.km)+" €\r\n";
			suple = c.recargoPorEjes(this.km);
		}
		if (transporte instanceof Moto ) {
			Moto m = (Moto) transporte;
			recargo = "2) Recargo por cilindrada: ("+m.recargoPorCilindrada(km)+" €\r\n";
			suple = m.recargoPorCilindrada(km);
		}
		if (transporte instanceof Furgoneta ) {
			Furgoneta f = (Furgoneta) transporte;
			recargo = "2) Recargo refrigeración: ("+f.recargoRefrigeracion(this.km)+" €\r\n";
			suple = f.recargoRefrigeracion(this.km);
		}
		
		
		String albaran = "ENVÍO "+this.id+"\r\n"
				+ "Zona: "+this.getZona()+"\r\n"
				+ "Transporte: "+transporte.toString()+"\n"
				+ "Distancia planificada: "+this.getKm()+" km\r\n"
				+ "Distancia real (suma paradas): "+this.kmReales()+" km\r\n"
				+ "Peso: "+this.getPesoKg()+" kg\r\n"
				+ "\r\n"
				+ "1) Coste base transporte: "+this.kmReales()+" x "+transporte.getCosteKmBase()+" = "+transporte.costeBase(this.kmReales())+" €\r\n"
				+ recargo
				+ "COSTE FINAL: "+transporte.costeBase(this.kmReales())+" + "+suple+" + otros = "+this.calcularCoste()+" €";
		return albaran;
	}

	@Override
	public int compareTo(Envio o) {
		
		return this.id.compareTo(o.id);
	}

	@Override
	public String toString() {
		return "\nEnvio [id=" + id + ", transporte=" + transporte + ", km=" + km + ", pesoKg=" + pesoKg + ", zona=" + zona
				+ ", paradasKm=" + paradasKm + ", coste total: "+this.calcularCoste()+", incidencias=" + incidencias + "]";
	}
	
	

}
