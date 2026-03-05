package videoteca;

public class Serie extends Contenido {
	
	private Integer temporadas;
	private Plataforma plataforma;
	
	
	public Serie(String codigo, String titulo, String director, Integer anioPublicacion, Boolean disponible,
			Integer temporadas, Plataforma plataforma) {
		super(codigo, titulo, director, anioPublicacion, disponible);
		this.temporadas = temporadas;
		this.plataforma = plataforma;
	}


	public Integer getTemporadas() {
		return temporadas;
	}


	public void setTemporadas(Integer temporadas) {
		this.temporadas = temporadas;
	}


	public Plataforma getPlataforma() {
		return plataforma;
	}


	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}


	@Override
	public String toString() {
		String resul = "\nTemporadas: "+this.temporadas+"\n"
				+ "Plataforma: "+this.plataforma.name();
		return super.toString()+resul;
	}
	
	

}
