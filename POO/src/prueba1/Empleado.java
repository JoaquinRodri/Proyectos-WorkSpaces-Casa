package prueba1;

public class Empleado extends Persona {
	
	double salario;
	
	
	
	public Empleado(String nombre, int edad, double estatura, double salario) {
		super(nombre, edad, estatura);
		this.salario = salario;
	}



	public Empleado() {
		
	}


	void despedirEmpleado() {
		System.out.println("Despedido");
	}
	
	void mostrarDatos() {
		System.out.println(nombre+edad+estatura+salario+"EmpleADO");
	}

}
