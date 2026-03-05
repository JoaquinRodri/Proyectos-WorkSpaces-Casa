package examen_poo_2025;

public class Cobro extends Apunte{
	
	private String pagador;
	private double penalizacion;
	
	
	public Cobro(String descripcion, Fecha fecha, double importeBase, TipoOperacion tipoOperacion, String pagador,
			double penalizacion) {
		super(descripcion, fecha, importeBase, tipoOperacion);
		this.pagador = pagador;
		this.penalizacion = penalizacion;
	}

	public Cobro(String descripcion, Fecha fecha, double importeBase, TipoOperacion tipoOperacion, String pagador) {
		super(descripcion, fecha, importeBase, tipoOperacion);
		this.pagador = pagador;
		this.penalizacion = 0;
	}

	public String getPagador() {
		return pagador;
	}
	
	@Override
	public Double getImporte() {
		return super.getImporteBase()+penalizacion;
	}

	
	public String toString() {
		return "Cobro: Pagador: "+getPagador()+", Concepto: "+getDescripcion()+", "+getFecha()+", Importe Base: "+
				getImporteBase()+", Penalizacion: "+this.penalizacion+", TOTAL: "+getImporte()+", Tipo Operacion: "+getTipoOperacion();
	}
}
