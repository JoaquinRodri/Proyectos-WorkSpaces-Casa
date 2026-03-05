package flota_reparto;

public class Camion extends Transporte {
	
	private int numEjes;
	private double plusPorEjes;

	public Camion(String matricula, double costeKmBase, double capacidadKg, int numEjes, double plusPorEjes) {
		super(matricula, costeKmBase, capacidadKg);
		this.numEjes = numEjes;
		this.plusPorEjes = plusPorEjes;
	}
	
	

	public int getNumEjes() {
		return numEjes;
	}



	public void setNumEjes(int numEjes) {
		this.numEjes = numEjes;
	}



	public double getPlusPorEjes() {
		return plusPorEjes;
	}



	public void setPlusPorEjes(double plusPorEjes) {
		this.plusPorEjes = plusPorEjes;
	}



	@Override
	public double calcularCosteViaje(double km, double kg) {
		
		return super.costeBase(km)+this.recargoPorEjes(km);
	}
	
	public double recargoPorEjes(double km) {
		if (numEjes>4) {
			return km*(this.numEjes*this.plusPorEjes);
		}else {
			return 0;
		}
	}
	
	public boolean esCamionPesado() {
		if (numEjes>4) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Camion (matricula "+super.getMatricula()+") |  Ejes:" + this.getNumEjes();
	}

}
