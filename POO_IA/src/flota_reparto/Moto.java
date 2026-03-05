package flota_reparto;

public class Moto extends Transporte {
	
	private int cilindrada;
	private double plusPorCilindrada;

	public Moto(String matricula, double costeKmBase, double capacidadKg, int cilindrada, double plusPorCilindrada) {
		super(matricula, costeKmBase, capacidadKg);
		this.cilindrada = cilindrada;
		this.plusPorCilindrada = plusPorCilindrada;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}
	
	public double getPlusPorCilindrada() {
		return plusPorCilindrada;
	}

	public void setPlusPorCilindrada(double plusPorCilindrada) {
		this.plusPorCilindrada = plusPorCilindrada;
	}


	public boolean aptaParaCentro() {
		if (this.cilindrada<=125) {
			return true;
		}
		return false;
	}
	
	public double recargoPorCilindrada(double km) {
		if (this.cilindrada >500) {
			return km*0.7;
		}else if (this.cilindrada>125) {
			return km*0.4;
		}else {
			return km*0.2;
		}
	}
	
	@Override
	public double calcularCosteViaje(double km, double kg) {
		double plusKg = 0;
		if (kg>5) {
			plusKg = 10;
		}else {
			plusKg = 3;
		}
		
		return super.costeBase(km)+this.recargoPorCilindrada(km)+plusKg;
	}
	
	@Override
	public String toString() {
		return "Moto (matricula "+super.getMatricula()+") |  Cilindrada:" + this.getCilindrada()+" cc";
	}

}
