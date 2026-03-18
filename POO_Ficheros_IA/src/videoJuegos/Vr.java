package videoJuegos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Vr extends VideoJuego{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5319100878605062780L;
	private Integer edadMinima;
	private Boolean necesitaSensores;
	
	public Vr(String codigo, String titulo, LocalDate fechaAlta, Float precioAlquiler, Estado estado,
			Boolean disponible, Integer edadMinima, Boolean necesitaSensores) {
		super(codigo, titulo, fechaAlta, precioAlquiler, estado, disponible);
		this.edadMinima = edadMinima;
		this.necesitaSensores = necesitaSensores;
	}

	public Integer getEdadMinima() {
		return edadMinima;
	}

	public void setEdadMinima(Integer edadMinima) {
		this.edadMinima = edadMinima;
	}

	public Boolean getNecesitaSensores() {
		return necesitaSensores;
	}

	public void setNecesitaSensores(Boolean necesitaSensores) {
		this.necesitaSensores = necesitaSensores;
	}
	
	@Override
	public String getDescripcion() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "VR - "+this.getTitulo()+", edad minima "+this.getEdadMinima()+", sensores "+(this.getNecesitaSensores()? "si":"no")+", alta el "+this.getFechaAlta().format(formato)+", precio: "+this.getPrecioAlquiler()+" €/día, estado: "+this.getEstado()+", disponible: "+(this.getDisponible()?"si":"no");
	}
	
	@Override
	public String formatoGuardar() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "VR#CODIGO:"+this.getCodigo()+"#TITULO:"+this.getTitulo()+"#FECHAALTA:"+this.getFechaAlta().format(formato)+"#PRECIO:"+this.getPrecioAlquiler()+"#ESTADO:"+this.getEstado()+"#DISPONIBLE:"+(this.getDisponible()?"si":"no")+"#EDADMINIMA:"+this.getEdadMinima()+"#SENSORES:"+(this.getNecesitaSensores()? "si":"no");
	}
	
	@Override
	public String toString() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "VR - CODIGO: "+this.getCodigo()+" - TITULO: "+this.getTitulo()+"- FECHA ALTA: "+this.getFechaAlta().format(formato)+" - PRECIO: "+this.getPrecioAlquiler()+" - ESTADO: "+this.getEstado()+" - DISPONIBLE: "+(this.getDisponible()?"si":"no")+" - EDADMINIMA: "+this.getEdadMinima()+" - SENSORES: "+(this.getNecesitaSensores()? "si":"no");
	}
	
	@Override
	public String stringDisponibles() {
		// TODO Auto-generated method stub
		return this.getCodigo()+" - "+this.getTitulo()+" - VR - "+this.getPrecioAlquiler();
	}

}
