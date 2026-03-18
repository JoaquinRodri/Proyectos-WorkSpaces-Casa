package videoJuegos;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class VideoJuego implements InterfazVideoJuego, Comparable<VideoJuego>, Serializable{
	
	
	private static final long serialVersionUID = 147991852107041899L;
	private String codigo;
	private String titulo;
	private LocalDate fechaAlta;
	private Float precioAlquiler;
	private Estado estado;
	private Boolean disponible;
	
	

	public VideoJuego(String codigo, String titulo, LocalDate fechaAlta, Float precioAlquiler, Estado estado,
			Boolean disponible) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.fechaAlta = fechaAlta;
		this.precioAlquiler = precioAlquiler;
		this.estado = estado;
		this.disponible = disponible;
	}
	
	

	public Estado getEstado() {
		return estado;
	}



	public void setEstado(Estado estado) {
		this.estado = estado;
	}



	public Boolean getDisponible() {
		return disponible;
	}



	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}



	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}



	public void setPrecioAlquiler(Float precioAlquiler) {
		this.precioAlquiler = precioAlquiler;
	}



	@Override
	public String getCodigo() {
		return this.codigo;
	}

	@Override
	public String getTitulo() {
		return this.titulo;
	}

	@Override
	public LocalDate getFechaAlta() {
		return this.fechaAlta;
	}

	@Override
	public Float getPrecioAlquiler() {
		return this.precioAlquiler;
	}

	@Override
	public abstract String getDescripcion();
	
	public abstract String formatoGuardar();
	
	public abstract String toString();
	
	public abstract String stringDisponibles();
	
	@Override
	public int compareTo(VideoJuego o) {
		if (this.getTitulo().equals(o.getTitulo())) {
			return - this.getPrecioAlquiler().compareTo(o.getPrecioAlquiler());
		}else {
			return this.getTitulo().compareTo(o.getTitulo());
		}
		
	}

}
