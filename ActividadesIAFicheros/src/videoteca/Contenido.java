package videoteca;

public abstract class Contenido implements Alquilable, Comparable<Contenido>{
	
	private String codigo;
	private String titulo;
	private String director;
	private Integer anioPublicacion;
	private Boolean disponible;
	
	
	public Contenido(String codigo, String titulo, String director, Integer anioPublicacion, Boolean disponible) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.director = director;
		this.anioPublicacion = anioPublicacion;
		this.disponible = disponible;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDirector() {
		return director;
	}


	public void setDirector(String director) {
		this.director = director;
	}


	public Integer getAnioPublicacion() {
		return anioPublicacion;
	}


	public void setAnioPublicacion(Integer anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}


	public Boolean getDisponible() {
		return disponible;
	}


	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}


	@Override
	public String toString() {
		String resul = "Codigo: "+this.codigo+"\n"
				+ "Título: "+this.titulo+"\n"
				+ "Director: "+this.director+"\n"
				+ "Año de Publicación: "+this.anioPublicacion+"\n"
				+ "Disponible: "+(this.disponible? "SI":"NO");
		return resul;
	}
	
	@Override
	public void alquilar(Cliente cliente) {
		if (this.disponible) {
			cliente.getAlquileresActivos().add(this.codigo);
			this.disponible = false;
			cliente.getHistorialMovimientos().add(this.codigo+"-"+"ALQUILAR");
		}else {
			System.out.println("El contenido no está disponible");
		}
		
	}
	
	public void devolver(Cliente cliente) {
		if (this.disponible) {
			System.out.println("El contenido ya esta devuelto.");
		}else {
			cliente.getAlquileresActivos().remove(this.codigo);
			this.disponible = true;
			cliente.getHistorialMovimientos().add(this.codigo+"-"+"DEVOLVER");
		}
	}
	
	public boolean estaAlquilado() {
		
		if (this.disponible) {
			return false;
		}else {
			System.out.println("El contenido no esta disponible.");
			return true;
		}
		
	}


	@Override
	public int compareTo(Contenido o) {
		// TODO Auto-generated method stub
		return this.titulo.compareTo(o.getTitulo());
	}
	
	

}
