package examen_poo_2025;

public class Pago extends Apunte {
	
	private String destinatario;
	private int descuento;
	
	
	public Pago(String descripcion, Fecha fecha, double importeBase, TipoOperacion tipoOperacion, String destinatario,
			int descuento) {
		super(descripcion, fecha, importeBase, tipoOperacion);
		this.destinatario = destinatario;
		this.descuento = descuento;
	}

	public Pago(String descripcion, Fecha fecha, double importeBase, TipoOperacion tipoOperacion, String destinatario) {
		super(descripcion, fecha, importeBase, tipoOperacion);
		this.destinatario = destinatario;
		this.descuento = 0;
	}

	public String getDestinatario() {
		return destinatario;
	}

	@Override
	public Double getImporte() {
		return -(super.getImporteBase()-(super.getImporteBase()*this.descuento/100));
	}
	
	public String toString() {
		return "Pago: Destinatario: "+getDestinatario()+", Concepto: "+getDescripcion()+", "+getFecha()+", Importe Base: "+
					getImporteBase()+", Descuento: "+this.descuento*getImporteBase()/100+", TOTAL: "+getImporte()+", Tipo Operacion: "+getTipoOperacion();
	}
	
	
	
	

}
