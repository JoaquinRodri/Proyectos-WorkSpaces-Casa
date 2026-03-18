package videoJuegos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Consola extends VideoJuego{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1311214422901866571L;
	private Plataforma plataforma;
	private Boolean multijugador;
	
	public Consola(String codigo, String titulo, LocalDate fechaAlta, Float precioAlquiler, Estado estado,
			Boolean disponible, Plataforma plataforma, Boolean multijugador) {
		super(codigo, titulo, fechaAlta, precioAlquiler, estado, disponible);
		this.plataforma = plataforma;
		this.multijugador = multijugador;
	}
	
	

	public Plataforma getPlataforma() {
		return plataforma;
	}



	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}



	public Boolean getMultijugador() {
		return multijugador;
	}



	public void setMultijugador(Boolean multijugador) {
		this.multijugador = multijugador;
	}



	@Override
	public String getDescripcion() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "CONSOLA - "+this.getTitulo()+", plataforma "+this.getPlataforma()+", multijugador "+(this.getMultijugador()? "si":"no")+", alta el "+this.getFechaAlta().format(formato)+", precio: "+this.getPrecioAlquiler()+" €/día, estado: "+this.getEstado()+", disponible: "+(this.getDisponible()?"si":"no");
	}



	@Override
	public String formatoGuardar() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "CONSOLA#CODIGO:"+this.getCodigo()+"#TITULO:"+this.getTitulo()+"#FECHAALTA:"+this.getFechaAlta().format(formato)+"#PRECIO:"+this.getPrecioAlquiler()+"#ESTADO:"+this.getEstado()+"#DISPONIBLE:"+(this.getDisponible()?"si":"no")+"#PLATAFORMA:"+this.getPlataforma()+"#MULTIJUGADOR:"+(this.getMultijugador()? "si":"no");
	}
	
	@Override
	public String toString() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "CONSOLA - CODIGO: "+this.getCodigo()+" - TITULO: "+this.getTitulo()+"- FECHA ALTA: "+this.getFechaAlta().format(formato)+" - PRECIO: "+this.getPrecioAlquiler()+" - ESTADO: "+this.getEstado()+" - DISPONIBLE: "+(this.getDisponible()?"si":"no")+" - PLATAFORMA: "+this.getPlataforma()+" - MULTIJUGADOR: "+(this.getMultijugador()? "si":"no");
	}



	@Override
	public String stringDisponibles() {
		// TODO Auto-generated method stub
		return this.getCodigo()+" - "+this.getTitulo()+" - CONSOLA - "+this.getPrecioAlquiler();
	}


	
	

}
