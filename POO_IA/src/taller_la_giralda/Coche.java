package taller_la_giralda;

public class Coche extends Vehiculo {
	
	private int numPuertas;
	private boolean esDiesel;
	private static final int NUM_PUERTAS = 3;
	private static final boolean ES_DIESEL = false;
	
	public Coche() {
		super();
		this.numPuertas = NUM_PUERTAS;
		this.esDiesel = ES_DIESEL;
		
	}
	
	public Coche(String matricula, String marca, int anyo, float kms, int numPuertas, boolean esDiesel) {
		super(matricula, marca, anyo, kms);
		this.numPuertas = numPuertas;
		this.esDiesel = esDiesel;
	}

	public int getNumPuertas() {
		return numPuertas;
	}

	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}

	public boolean isEsDiesel() {
		return esDiesel;
	}

	public void setEsDiesel(boolean esDiesel) {
		this.esDiesel = esDiesel;
	}


	//metodos
	
	@Override
	public float calcularCosteRevision() {
		float precio = super.calcularCosteRevision();
		if (this.esDiesel) {
			precio += 50;
		}
		if (this.kms>200000) {
			precio += 90;
		}else if (this.kms>100000) {
			precio += 70;
		}else {
			precio += 50;
		}
		
		if (this.getAnyo()>2018) {
			precio += 100; 
		}
		
		return precio;
	}

	@Override
	public String toString() {
		return "Coche [numPuertas=" + numPuertas + ", esDiesel=" + esDiesel + ", getMatricula()=" + getMatricula()
				+ ", getMarca()=" + getMarca() + ", getAnyo()=" + getAnyo() + ", getKms()=" + getKms() + "]";
	}

	
	
	
	

}
