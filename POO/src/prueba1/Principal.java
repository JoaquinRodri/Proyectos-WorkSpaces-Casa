package prueba1;

public class Principal {

	public static void main(String[] args) {
		
		Persona e = new Empleado();
		System.out.println(e instanceof Empleado);
		System.out.println(e instanceof Persona);
		e.mostrarDatos();

	}

}
