package videoJuegos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pc extends VideoJuego{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -384221391919868027L;
	private String requisitosMinimos;
	private Boolean online;
	
	public Pc(String codigo, String titulo, LocalDate fechaAlta, Float precioAlquiler, Estado estado,
			Boolean disponible, String requisitosMinimos, Boolean online) {
		super(codigo, titulo, fechaAlta, precioAlquiler, estado, disponible);
		this.requisitosMinimos = requisitosMinimos;
		this.online = online;
	}

	public String getRequisitosMinimos() {
		return requisitosMinimos;
	}

	public void setRequisitosMinimos(String requisitosMinimos) {
		this.requisitosMinimos = requisitosMinimos;
	}

	public Boolean getOnline() {
		return online;
	}

	public void setOnline(Boolean online) {
		this.online = online;
	}
	
	@Override
	public String getDescripcion() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "PC - "+this.getTitulo()+", requisitos minimos "+this.getRequisitosMinimos()+", online "+(this.getOnline()? "si":"no")+", alta el "+this.getFechaAlta().format(formato)+", precio: "+this.getPrecioAlquiler()+" €/día, estado: "+this.getEstado()+", disponible: "+(this.getDisponible()?"si":"no");
	}
	
	@Override
	public String formatoGuardar() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "PC#CODIGO:"+this.getCodigo()+"#TITULO:"+this.getTitulo()+"#FECHAALTA:"+this.getFechaAlta().format(formato)+"#PRECIO:"+this.getPrecioAlquiler()+"#ESTADO:"+this.getEstado()+"#DISPONIBLE:"+(this.getDisponible()?"si":"no")+"#REQUISITOS:"+this.getRequisitosMinimos()+"#ONLINE:"+(this.getOnline()? "si":"no");
	}
	
	@Override
	public String toString() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "PC - CODIGO: "+this.getCodigo()+" - TITULO: "+this.getTitulo()+"- FECHA ALTA: "+this.getFechaAlta().format(formato)+" - PRECIO: "+this.getPrecioAlquiler()+" - ESTADO: "+this.getEstado()+" - DISPONIBLE: "+(this.getDisponible()?"si":"no")+" - REQUISITOS: "+this.getRequisitosMinimos()+" - ONLINE: "+(this.getOnline()? "si":"no");
	}
	
	@Override
	public String stringDisponibles() {
		// TODO Auto-generated method stub
		return this.getCodigo()+" - "+this.getTitulo()+" - PC - "+this.getPrecioAlquiler();
	}

}
