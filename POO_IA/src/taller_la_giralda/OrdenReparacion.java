package taller_la_giralda;

public class OrdenReparacion {
	
	private Vehiculo vehiculo;
	private float horasManoObra;
	private float precioHora;
	private tipoAveria tipoAveria;
	
	private static final float HORAS_MANO_OBRA = 0;
	private static final float PRECIO_HORA = 0;
	
	public OrdenReparacion() {
		this.vehiculo = new Vehiculo();
		this.horasManoObra = HORAS_MANO_OBRA;
		this.precioHora = PRECIO_HORA;
	}
	
	public OrdenReparacion(Vehiculo vehiculo, float horasManoObra, float precioHora, tipoAveria tipoAveria) {
		this.vehiculo = vehiculo;
		this.horasManoObra = horasManoObra;
		this.precioHora = precioHora;
		this.tipoAveria = tipoAveria;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public float getHorasManoObra() {
		return horasManoObra;
	}

	public void setHorasManoObra(float horasManoObra) {
		this.horasManoObra = horasManoObra;
	}

	public float getPrecioHora() {
		return precioHora;
	}

	public void setPrecioHora(float precioHora) {
		this.precioHora = precioHora;
	}

	public tipoAveria getTipoAveria() {
		return tipoAveria;
	}

	public void setTipoAveria(tipoAveria tipoAveria) {
		this.tipoAveria = tipoAveria;
	}

	@Override
	public String toString() {
		return "OrdenReparacion [vehiculo=" + vehiculo + ", horasManoObra=" + horasManoObra + ", precioHora="
				+ precioHora + ", tipoAveria=" + tipoAveria + "]";
	}
	
	//metodos
	
	public float calcularTotal() {
		float precio = this.vehiculo.calcularCosteRevision();
		float precioRep = this.horasManoObra*this.precioHora;
		
		if (this.vehiculo instanceof Coche) {
			precio += 70;
		}
		if (this.vehiculo instanceof Moto) {
			precio += 35;
		}
		
		switch (this.tipoAveria) {
		case ACEITE:
			precio += 70;
			break;
		case FRENOS:
			precio += 140;
			break;
		case ELECTRICA:
			precio += 300;
			break;
		case RUEDAS:
			precio += 280;
			break;
		}
		
		precio += precioRep;
		
		
		return precio;
	}
	

}
