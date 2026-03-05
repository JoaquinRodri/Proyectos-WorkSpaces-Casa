package taller_la_giralda;

public class Vehiculo {
	
	private String matricula;
	private String marca;
	private int anyo;
	protected float kms;
	private static final float PRECIO_REVISION = 100;
	private static final String MATRICULA = "0000AAA";
	private static final String MARCA = "";
	private static final int ANYO = 1900;
	private static final float KMS = 0;
	
	
	public Vehiculo() {
		this.matricula = MATRICULA;
		this.marca = MARCA;
		this.anyo = ANYO;
		this.kms = KMS;
		
	}
	
	public Vehiculo(String matricula, String marca, int anyo, float kms) {
		this.matricula = matricula;
		this.marca = marca;
		this.anyo = anyo;
		this.kms = kms;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public float getKms() {
		return kms;
	}

	public void setKms(float kms) {
		this.kms = kms;
	}
	
	//metodos
	public float calcularCosteRevision() {
		return PRECIO_REVISION;
	}

	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", marca=" + marca + ", anyo=" + anyo + ", kms=" + kms + "]";
	}
	
	

}
