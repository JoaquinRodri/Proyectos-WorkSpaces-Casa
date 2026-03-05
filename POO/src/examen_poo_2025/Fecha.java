package examen_poo_2025;

public class Fecha {
	
	private int anyo;
	private int mes;
	private int dia;
	
	public Fecha(int anyo, int mes, int dia) {
		this.anyo = anyo;
		this.mes = mes;
		this.dia = dia;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	@Override
	public String toString() {
		return "Fecha: "+dia+"/"+mes+"/"+anyo;
	}
	
	
	
	

}
