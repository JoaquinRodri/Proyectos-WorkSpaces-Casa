package hospital_virgen_del_rocio;

public abstract class EmpleadoHospital implements Comparable{
	
	protected String dni;
	protected String nombre;
	protected double salarioBase;
	protected int antiguedadAnios;
	
	
	public EmpleadoHospital(String dni, String nombre, double salarioBase, int antiguedadAnios) {
		this.dni = dni;
		this.nombre = nombre;
		this.salarioBase = salarioBase;
		this.antiguedadAnios = antiguedadAnios;
	}


	public EmpleadoHospital() {
		
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getSalarioBase() {
		return salarioBase;
	}


	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}


	public int getAntiguedadAnios() {
		return antiguedadAnios;
	}


	public void setAntiguedadAnios(int antiguedadAnios) {
		this.antiguedadAnios = antiguedadAnios;
	}


	@Override
	public String toString() {
		return "EmpleadoHospital [dni=" + dni + ", nombre=" + nombre + ", salarioBase=" + salarioBase
				+ ", antiguedadAnios=" + antiguedadAnios + "]";
	}
	
	//metodos
	
	public abstract double calcularNomina();
	
	public double plusAntiguedad() {
		if (this.antiguedadAnios>10) {
			return 150;
		}else if (this.antiguedadAnios>5) {
			return 50;
		}else if (this.antiguedadAnios>2) {
			return 30;
		}
		
		return 0;
		
	}
	
	@Override
	public int compareTo(Object o) {
		String letra = ""+this.dni.charAt(this.dni.length()-1);
		String letraO = ""+((EmpleadoHospital) o).getDni().charAt(getDni().length()-1);
		return letra.compareTo(letraO);
	}

}
