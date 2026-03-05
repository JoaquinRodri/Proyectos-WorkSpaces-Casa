package videoteca;

public interface Alquilable {
	
	void alquilar(Cliente cliente);
	void devolver(Cliente cliente);
	boolean estaAlquilado();

}
