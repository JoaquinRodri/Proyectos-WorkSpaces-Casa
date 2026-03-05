package notas_curso;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Asignatura {
	
	private String nombre;
	private List<Integer> notas;
	
	public Asignatura () {
		this.notas = new ArrayList<Integer>();
	}
	
	public Asignatura(String nombre, List<Integer> notas) {
		this.nombre=nombre;
		this.notas = notas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Integer> getNotas() {
		return notas;
	}

	public void setNotas(List<Integer> notas) {
		this.notas = notas;
	}

	@Override
	public String toString() {
		return "Asignatura [nombre=" + nombre + ", notas=" + notas + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asignatura other = (Asignatura) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	
	
	

}
