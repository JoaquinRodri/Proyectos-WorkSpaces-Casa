package videoteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Videoteca {
	
	private List<Contenido> contenidos;
	private List<Cliente> clientes;
	private Map<String, Contenido> indicePorCodigo;
	private Map<String, Cliente> indicePorIdCliente;
	private Set<String> codigoEnUso;
	private Map<String, Integer> contadorAlquileresPorContenido;
	
	public Videoteca() {
		this.contenidos = new ArrayList<Contenido>();
		this.clientes = new ArrayList<Cliente>();
		this.indicePorCodigo = new TreeMap<String, Contenido>();
		this.indicePorIdCliente = new TreeMap<String, Cliente>();
		this.codigoEnUso = new TreeSet<String>();
		this.contadorAlquileresPorContenido = new TreeMap<String, Integer>();
	}

	public List<Contenido> getContenidos() {
		return contenidos;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public Map<String, Contenido> getIndicePorCodigo() {
		return indicePorCodigo;
	}

	public Map<String, Cliente> getIndicePorIdCliente() {
		return indicePorIdCliente;
	}

	public Set<String> getCodigoEnUso() {
		return codigoEnUso;
	}

	public Map<String, Integer> getContadorAlquileresPorContenido() {
		return contadorAlquileresPorContenido;
	}
	
	public void agregarContenido(Contenido c) {
		if (this.codigoEnUso.contains(c.getCodigo())) {
			System.out.println("El contenido indicado ya existe.");
		}else {
			this.contenidos.add(c);
			this.codigoEnUso.add(c.getCodigo());
			this.indicePorCodigo.put(c.getCodigo(), c);
		}
		
	}
	
	public void registrarCliente(Cliente cliente) {
		
		if (this.indicePorIdCliente.containsKey(cliente.getId())) {
			System.out.println("El cliente indicado ya existe.");
		}else {
			this.clientes.add(cliente);
			this.indicePorIdCliente.put(cliente.getId(), cliente);
		}
		
	}

	public Contenido buscarContenidoPorCodigo(String codigo) {
		Contenido c = null;
		if (this.indicePorCodigo.containsKey(codigo)) {
			c = this.indicePorCodigo.get(codigo);
		}
		
		return c;
	}
	
	public List<Contenido> obtenerContenidosDisponibles(){
		List<Contenido> disponibles = new ArrayList<Contenido>();
		for(Contenido c : this.contenidos) {
			if (c.getDisponible()) {
				disponibles.add(c);
			}
		}
		
		return disponibles;
	}
	
	public void procesarMovimiento(String id_cliente, String codigoContenido, String accion) {
		
		if (this.indicePorIdCliente.containsKey(id_cliente) && this.indicePorCodigo.containsKey(codigoContenido)) {
			if (accion.equals("ALQUILAR")) {
				this.indicePorCodigo.get(codigoContenido).alquilar(this.indicePorIdCliente.get(id_cliente));
				if (!this.contadorAlquileresPorContenido.containsKey(codigoContenido)) {
					this.contadorAlquileresPorContenido.put(codigoContenido, 1);
				}else {
					this.contadorAlquileresPorContenido.put(codigoContenido, this.contadorAlquileresPorContenido.get(codigoContenido)+1);
				}
				
			}else if (accion.equals("DEVOLVER")) {
				this.indicePorCodigo.get(codigoContenido).devolver(this.indicePorIdCliente.get(id_cliente));
			}
			
		}else {
			System.out.println("Datos inválidos: cliente o contenido inexistente.");
		}
		
	}
	
	public List<Contenido> obtenerContenidosOrdenador(Comparator<Contenido> comparador){
		List<Contenido> contenidoOrdenado = this.contenidos;
		Collections.sort(contenidoOrdenado, comparador);
		
		return contenidoOrdenado;
	}
	
}
