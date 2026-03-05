package pedidos;

public class Pedido {
	
	private int idPedido;
	private String fecha;
	private Cliente cliente;
	private double total;
	
	public Pedido(int idPedido, String fecha, Cliente cliente, double total) {
		this.idPedido = idPedido;
		this.fecha = fecha;
		this.cliente = cliente;
		this.total = total;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return this.idPedido+"#"+this.fecha+"#"+this.cliente+"#"+this.total;
	}
	
	
	

}
