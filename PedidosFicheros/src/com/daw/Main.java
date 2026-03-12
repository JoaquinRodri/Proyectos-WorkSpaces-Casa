package com.daw;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
	
	static Map<Integer, Pedido> pedidos = new HashMap<Integer, Pedido>();
	static DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	public static void main(String[] args) {
		
		procesarFichero();
		
		System.out.println(pedidos);

	}

	public static void procesarFichero() {
		
		try {
			BufferedReader leer = new BufferedReader(new FileReader("resources/pedidos.txt"));
			String linea = leer.readLine();
			while (linea != null) {
				String [] partes = linea.split(";");
				Integer id_pedido = Integer.valueOf(partes[0]);
				LocalDate fecha = LocalDate.parse(partes[1], formato);
				String id_cliente = partes[2];
				String nombreC = partes[3];
				String id_prod = partes[4];
				String nombre_prod = partes[5];
				String categoria = partes[6];
				Float precio_p = Float.valueOf(partes[7]);
				Integer cantidad_l = Integer.valueOf(partes[8]);
				
				Cliente c = new Cliente(id_cliente, nombreC);
				Producto p = new Producto(id_prod, nombre_prod, categoria, precio_p);
				LineaPedido lP = new LineaPedido(p, cantidad_l);
				Pedido pe = new Pedido(id_pedido, fecha, c, new ArrayList<LineaPedido>());
				
				if (pedidos.containsKey(id_pedido)) {
					
					Pedido pedid = pedidos.get(id_pedido);
					pedid.getLineaPedido().add(lP);
					
				}else {
					pedidos.put(id_pedido, pe);
					pe.getLineaPedido().add(lP);
				}
				
				linea = leer.readLine();
			}
			
			leer.close();
		} catch (FileNotFoundException e) {
			System.out.println("EL fichero no existe.");
		} catch (IOException e) {
			System.out.println("Erro al intentar leer el fichero.");
		}
		
	}

}
