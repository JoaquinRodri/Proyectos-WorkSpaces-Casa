package videoJuegos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Mesa extends VideoJuego {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer numJugadores;
	private Integer duracionPartida;

	public Mesa(String codigo, String titulo, LocalDate fechaAlta, Float precioAlquiler, Estado estado,
			Boolean disponible, Integer numJugadores, Integer duracionPartida) {
		super(codigo, titulo, fechaAlta, precioAlquiler, estado, disponible);
		this.numJugadores = numJugadores;
		this.duracionPartida = duracionPartida;
	}



	public Integer getNumJugadores() {
		return numJugadores;
	}



	public void setNumJugadores(Integer numJugadores) {
		this.numJugadores = numJugadores;
	}



	public Integer getDuracionPartida() {
		return duracionPartida;
	}



	public void setDuracionPartida(Integer duracionPartida) {
		this.duracionPartida = duracionPartida;
	}



	@Override
	public String getDescripcion() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "MESA - "+this.getTitulo()+", jugadores "+this.getNumJugadores()+", duracion partida "+this.getDuracionPartida()+", alta el "+this.getFechaAlta().format(formato)+", precio: "+this.getPrecioAlquiler()+" €/día, estado: "+this.getEstado()+", disponible: "+(this.getDisponible()?"si":"no");
	}
	
	@Override
	public String formatoGuardar() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "MESA#CODIGO:"+this.getCodigo()+"#TITULO:"+this.getTitulo()+"#FECHAALTA:"+this.getFechaAlta().format(formato)+"#PRECIO:"+this.getPrecioAlquiler()+"#ESTADO:"+this.getEstado()+"#DISPONIBLE:"+(this.getDisponible()?"si":"no")+"#JUGADORES:"+this.getNumJugadores()+"#DURACION:"+this.getDuracionPartida();
	}
	
	@Override
	public String toString() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "MESAS - CODIGO: "+this.getCodigo()+" - TITULO: "+this.getTitulo()+"- FECHA ALTA: "+this.getFechaAlta().format(formato)+" - PRECIO: "+this.getPrecioAlquiler()+" - ESTADO: "+this.getEstado()+" - DISPONIBLE: "+(this.getDisponible()?"si":"no")+" - JUGADORES: "+this.getNumJugadores()+" - DURACION: "+this.getDuracionPartida();
	}

	@Override
	public String stringDisponibles() {
		// TODO Auto-generated method stub
		return this.getCodigo()+" - "+this.getTitulo()+" - MESA - "+this.getPrecioAlquiler();
	}

}
