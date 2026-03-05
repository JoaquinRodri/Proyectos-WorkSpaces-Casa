package examen_poo_2025;

public abstract class Apunte implements Comparable<Apunte>, InterfazApunte{
	
	private String descripcion;
	private Fecha fecha;
	private Double importeBase;
	private TipoOperacion tipoOperacion;

	public Apunte(String descripcion, Fecha fecha, double importeBase, TipoOperacion tipoOperacion) {
		super();
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.importeBase = importeBase;
		this.tipoOperacion = tipoOperacion;
	}
	

	public TipoOperacion getTipoOperacion() {
		return tipoOperacion;
	}

	
	public String getDescripcion() {
		return this.descripcion;
	}

	
	public Fecha getFecha() {
		return this.fecha;
	}
	
	public double getImporteBase() {
		return this.importeBase;
	}


	@Override
	public int compareTo(Apunte o) {
		if (this.getFecha().getAnyo()== o.getFecha().getAnyo()) {
			if (this.getFecha().getMes()== o.getFecha().getMes()) {
				if (this.getFecha().getDia()== o.getFecha().getDia()) {
					return 0;
				}else {
					return this.getFecha().getDia()- o.getFecha().getDia();
				}
			}else {
				return this.getFecha().getMes()- o.getFecha().getMes();
			}
		}else {
			return this.getFecha().getAnyo()- o.getFecha().getAnyo();
		}
		
	}
	
	public abstract String toString();

}
