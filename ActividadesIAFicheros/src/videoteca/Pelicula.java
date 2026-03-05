package videoteca;

public class Pelicula extends Contenido {
	
	private Integer duracionMin;
	private Genero genero;
	
	
	public Pelicula(String codigo, String titulo, String director, Integer anioPublicacion, Boolean disponible,
			Integer duracionMin, Genero genero) {
		super(codigo, titulo, director, anioPublicacion, disponible);
		this.duracionMin = duracionMin;
		this.genero = genero;
	}


	public Integer getDuracionMin() {
		return duracionMin;
	}


	public void setDuracionMin(Integer duracionMin) {
		this.duracionMin = duracionMin;
	}


	public Genero getGenero() {
		return genero;
	}


	public void setGenero(Genero genero) {
		this.genero = genero;
	}


	@Override
	public String toString() {
		String resul = "\n Duracion: "+this.duracionMin+"\n"
				+ "Genero: "+this.genero.name();
		return super.toString()+resul;
	}
	
	
	
	

}
