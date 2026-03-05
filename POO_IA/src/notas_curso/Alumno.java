package notas_curso;

public class Alumno implements Comparable<Alumno>{
	
	private String nombre;
	private String apellido;
	private String curso;
	
	public Alumno() {
		
	}

	public Alumno(String nombre, String apellido, String curso) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.curso = curso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellido=" + apellido + ", curso=" + curso + "]";
	}

	@Override
	public int compareTo(Alumno o) {
		if (this.nombre.equalsIgnoreCase(o.nombre)) {
			return this.apellido.compareToIgnoreCase(o.apellido);
		}else {
			
			return this.nombre.compareToIgnoreCase(o.nombre);
		}
	}
	
	
	
	
	

}
