package videoteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Cliente {
	
	private String id;
	private String nombre;
	private String email;
	private Set<String> alquileresActivos;
	private List<String> historialMovimientos;
	
	
	public Cliente(String id, String nombre, String email, Set<String> alquileresActivos,
			List<String> historialMovimientos) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.alquileresActivos = alquileresActivos;
		this.historialMovimientos = historialMovimientos;
	}


	public Cliente(String id, String nombre, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.alquileresActivos = new TreeSet<String>();
		this.historialMovimientos = new ArrayList<String>();
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Set<String> getAlquileresActivos() {
		return alquileresActivos;
	}


	public void setAlquileresActivos(Set<String> alquileresActivos) {
		this.alquileresActivos = alquileresActivos;
	}


	public List<String> getHistorialMovimientos() {
		return historialMovimientos;
	}


	public void setHistorialMovimientos(List<String> historialMovimientos) {
		this.historialMovimientos = historialMovimientos;
	}


	@Override
	public String toString() {
		String resul = "ID: "+this.getId()+"\n"
				+ "Nombre: "+this.getNombre()+"\n"
				+ "Email: "+this.getEmail()+"\n"
				+ "Alquileres Activos: "+this.getAlquileresActivos()+"\n"
				+ "Historial Movimientos: "+this.getHistorialMovimientos();
		return resul;
	}
	
	
	
	

}
