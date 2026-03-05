package hospital_virgen_del_rocio;

import java.util.TreeSet;

public class Medico extends EmpleadoHospital{
	
	private String especialidad;
	private int numGuardias;
	private double precioGuardia;
	private TreeSet<String> certificaciones;
	
	
	
	public Medico(String dni, String nombre, double salarioBase, int antiguedadAnios, String especialidad,
			int numGuardias, double precioGuardia, TreeSet<String> certificaciones) {
		super(dni, nombre, salarioBase, antiguedadAnios);
		this.especialidad = especialidad;
		this.numGuardias = numGuardias;
		this.precioGuardia = precioGuardia;
		this.certificaciones = certificaciones;
	}
	
	public Medico() {
		
	}
	
	

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public int getNumGuardias() {
		return numGuardias;
	}

	public void setNumGuardias(int numGuardias) {
		this.numGuardias = numGuardias;
	}

	public double getPrecioGuardia() {
		return precioGuardia;
	}

	public void setPrecioGuardia(double precioGuardia) {
		this.precioGuardia = precioGuardia;
	}

	public TreeSet<String> getCertificaciones() {
		return certificaciones;
	}

	public void setCertificaciones(TreeSet<String> certificaciones) {
		this.certificaciones = certificaciones;
	}
	
	

	@Override
	public String toString() {
		return "Medico [especialidad=" + especialidad + ", numGuardias=" + numGuardias + ", precioGuardia="
				+ precioGuardia + ", certificaciones=" + certificaciones + ", dni=" + dni
				+ ", nombre=" + nombre + ", salarioBase=" + salarioBase + ", antiguedadAnios=" + antiguedadAnios + "]";
	}
	
	public double totalGuardias() {
		
		return this.precioGuardia*this.numGuardias;
	}

	@Override
	public double calcularNomina() {
		double total = 0;
		total = this.salarioBase+this.totalGuardias()+this.plusAntiguedad();
		return total;
	}
	
	public boolean tieneCertificacion(String codigo) {
		return certificaciones.contains(codigo);
		
	}

}
