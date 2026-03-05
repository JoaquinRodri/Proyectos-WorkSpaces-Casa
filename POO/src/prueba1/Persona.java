package prueba1;

public class Persona {
	
	String nombre;
	int edad;
	double estatura;
	
	public Persona() {
		
	}
	
	public Persona(String nombre, int edad, double estatura) {
		this.nombre = nombre;
		this.edad = edad;
		this.estatura = estatura;
	}



	void mostrarDatos() {
		System.out.println(nombre+edad+estatura);
	}

}
