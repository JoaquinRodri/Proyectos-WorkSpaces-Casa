package taller_la_giralda;

public class Moto extends Vehiculo{
	
	private int cilindradas;
	private static final int CILINDRADAS = 49;
	
	public Moto() {
		super();
		this.cilindradas = CILINDRADAS;
	}
	
	public Moto(String matricula, String marca, int anyo, float kms, int cilindradas) {
		super(matricula, marca, anyo, kms);
		this.cilindradas = cilindradas;
	}

	public int getCilindradas() {
		return cilindradas;
	}

	public void setCilindradas(int cilindradas) {
		this.cilindradas = cilindradas;
	}

	@Override
	public String toString() {
		return "Moto [cilindradas=" + cilindradas + ", getMatricula()=" + getMatricula() + ", getMarca()=" + getMarca()
				+ ", getAnyo()=" + getAnyo() + ", getKms()=" + getKms() + "]";
	}
	
	//metodos
	
	
	

	@Override
	public float calcularCosteRevision() {
		float precio = super.calcularCosteRevision();
		
		if (this.kms > 30000) {
			precio += 50;
		}
		
		if (this.cilindradas >1000) {
			precio +=110;
		}else if (this.cilindradas >500) {
			precio += 80;
		}else if (this.cilindradas > 125) {
			precio += 60;
		}else {
			precio += 40;
		}
		
		if (super.getAnyo()>2016) {
			precio += 50;
		}
		
		
		return precio;
	}

}
