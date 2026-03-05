package hospital_virgen_del_rocio;

import java.util.ArrayList;

public class Administrativo extends EmpleadoHospital{
	
	private int nivel;
	private ArrayList<String> tareas;
	
	
	
	public Administrativo(String dni, String nombre, double salarioBase, int antiguedadAnios, int nivel,
			ArrayList<String> tareas) {
		super(dni, nombre, salarioBase, antiguedadAnios);
		this.nivel = nivel;
		this.tareas = tareas;
	}
	
	public Administrativo() {
		
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public ArrayList<String> getTareas() {
		return tareas;
	}

	public void setTareas(ArrayList<String> tareas) {
		this.tareas = tareas;
	}
	
	

	@Override
	public String toString() {
		return "Administrativo [nivel=" + nivel + ", tareas=" + tareas + ", dni=" + dni + ", nombre=" + nombre
				+ ", salarioBase=" + salarioBase + ", antiguedadAnios=" + antiguedadAnios + "]";
	}
	
	/*
	 * calcularNomina()
	Ajusta el salario según nivel y tareas.
	
	agregarTarea(String tarea)
	Añade una tarea al listado.
	
	totalTareas()
	Devuelve cuántas tareas tiene asignadas.
	
	contieneTarea(String palabraClave)
	Comprueba si alguna tarea contiene cierta palabra.
	*/

	@Override
	public double calcularNomina() {
		double aumento = 0;
		if (this.nivel == 3) {
			aumento = 25;
		}else if (this.nivel == 2) {
			aumento = 35;
		}else if (this.nivel == 1) {
			aumento = 50;
		}
		
		if (this.totalTareas()>5) {
			aumento += 25;
		}else if (this.totalTareas()>3) {
			aumento += 15;
		}else if (this.totalTareas()>1) {
			aumento += 5;
		}
		return this.salarioBase+this.plusAntiguedad()+aumento;
	}
	
	public void agregarTarea(String tarea) {
		if (!this.contieneTareas(tarea)) {
			tareas.add(tarea);
		}
	}
	
	public boolean contieneTareas(String tarea) {
		return tareas.contains(tarea);
	}
	
	public int totalTareas() {
		return tareas.size();
	}

}
