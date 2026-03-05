package hospital_virgen_del_rocio;

import java.util.ArrayList;

public class Enfermero extends EmpleadoHospital{
	
	private Turno turno;
	private double plusNocturnidad;
	private ArrayList<Integer> pacientesAtendidosPorDia;
	
	public Enfermero(String dni, String nombre, double salarioBase, int antiguedadAnios, Turno turno,
			double plusNocturnidad, ArrayList<Integer> pacientesAtendidosPorDia) {
		super(dni, nombre, salarioBase, antiguedadAnios);
		this.turno = turno;
		this.plusNocturnidad = plusNocturnidad;
		this.pacientesAtendidosPorDia = pacientesAtendidosPorDia;
	}

	public Enfermero() {
		
	}


	public Turno getTurno() {
		return turno;
	}




	public void setTurno(Turno turno) {
		this.turno = turno;
	}




	public double getPlusNocturnidad() {
		return plusNocturnidad;
	}




	public void setPlusNocturnidad(double plusNocturnidad) {
		this.plusNocturnidad = plusNocturnidad;
	}




	public ArrayList<Integer> getPacientesAtendidosPorDia() {
		return pacientesAtendidosPorDia;
	}




	public void setPacientesAtendidosPorDia(ArrayList<Integer> pacientesAtendidosPorDia) {
		this.pacientesAtendidosPorDia = pacientesAtendidosPorDia;
	}


	
	@Override
	public String toString() {
		return "Enfermero [turno=" + turno + ", plusNocturnidad=" + plusNocturnidad + ", pacientesAtendidosPorDia="
				+ pacientesAtendidosPorDia + ", dni=" + dni + ", nombre=" + nombre + ", salarioBase=" + salarioBase
				+ ", antiguedadAnios=" + antiguedadAnios + "]";
	}
	
	/*
	* calcularNomina()
	Incluye plus de nocturnidad si corresponde.
	
	mediaPacientes()
	Calcula la media de pacientes atendidos por día.
	
	maxPacientesEnUnDia()
	Devuelve el máximo de pacientes atendidos en un día.
	
	esTurnoNoche()
	Indica si trabaja de noche.*/

	@Override
	public double calcularNomina() {
		if (this.esTurnoNoche()) {
			return this.salarioBase+this.plusNocturnidad+this.plusAntiguedad();
		}
		
		return this.salarioBase+this.plusAntiguedad();
	}
	
	public boolean esTurnoNoche() {
		return this.turno.name().equals("NOCHE");
	}
	
	public int masPacientesEnUnDia() {
		int maximo = 0;
		for (Integer num : pacientesAtendidosPorDia) {
			if (num>maximo) {
				maximo=num;
			}
		}
		return maximo;
	}
	
	public double mediaPacientes() {
		Integer sumaTodos = 0;
		for (Integer integer : pacientesAtendidosPorDia) {
			sumaTodos+=integer;
		}
		return sumaTodos/pacientesAtendidosPorDia.size();
	}
	

}
