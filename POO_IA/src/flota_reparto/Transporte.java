package flota_reparto;

public abstract class Transporte {
	
	private String matricula;
	private double costeKmBase;
	private double capacidadKg;
	
	public Transporte(String matricula, double costeKmBase, double capacidadKg) {
		this.matricula = matricula;
		this.costeKmBase = costeKmBase;
		this.capacidadKg = capacidadKg;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public double getCosteKmBase() {
		return costeKmBase;
	}

	public void setCosteKmBase(double costeKmBase) {
		this.costeKmBase = costeKmBase;
	}

	public double getCapacidadKg() {
		return capacidadKg;
	}

	public void setCapacidadKg(double capacidadKg) {
		this.capacidadKg = capacidadKg;
	}
	
	public abstract double calcularCosteViaje(double km, double kg);
	
	public boolean admitecarga(double kg) {
		if (kg <= this.capacidadKg) {
			return true;
		}
		return false;
	}
	
	public double costeBase(double km) {
		return km*this.costeKmBase;
	}

	public String fichaTransporte() {
		return "Transporte: matricula=" + matricula + ", costeKmBase=" + costeKmBase + ", capacidadKg=" + capacidadKg;
	}
	
	public abstract String toString();
	
	

}
