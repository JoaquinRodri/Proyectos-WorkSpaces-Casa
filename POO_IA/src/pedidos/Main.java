package pedidos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		Cliente c1 = new Cliente("Juan Perez", "juan@email.com", "Calle Mayor 10");
        Pedido p1 = new Pedido(105, "2026-02-26", c1, 259.99);

        Cliente c2 = new Cliente("Ana Lopez", "ana@email.com", "Avenida Sol 25");
        Pedido p2 = new Pedido(106, "2026-02-27", c2, 120.50);
        
        crearFichero(p1);
        crearFichero(p2);
        
        Pedido Generado1 = generarPedido("pedido105.txt");
        Pedido Generado2 = generarPedido("pedido106.txt");
        
        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(Generado1);
        
        
        totalPedidos(pedidos);
        
        List<Pedido> pedidos1 = new ArrayList<>();
        pedidos1.add(Generado2);
        
        totalPedidos(pedidos1);
		
	}
	public static void crearFichero(Pedido p) {
		Cliente c = p.getCliente();
		
		try {
			BufferedWriter escribir = new BufferedWriter(new FileWriter("pedido"+p.getIdPedido()+".txt"));
			String resul = "ID:"+p.getIdPedido()+"\n"
					+ "FECHA:"+p.getFecha()+"\n"
					+ "CLIENTE:NOMBRE="+c.getNombre()+";EMAIL="+c.getEmail()+";DIRECCION="+c.getDireccion()+"\n"
					+ "TOTAL:"+p.getTotal();
			
			escribir.write(resul);
			escribir.newLine();
			escribir.close();
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static Pedido generarPedido(String nombreF) {
		
		int id = 0;
		String fecha = null;
		String nombre = null;
		String email = null;
		String direccion = null;
		double total= 0.0;
		
		try {
			BufferedReader leer = new BufferedReader(new FileReader(nombreF));
			String linea = leer.readLine();
			while (linea!=null) {
				String [] partes;
				if (linea.startsWith("ID:")) {
					partes = linea.split(":");
					id = Integer.valueOf(partes[1]);
				}else if (linea.startsWith("FECHA:")) {
					partes = linea.split(":");
					fecha = partes[1];
				}else if (linea.startsWith("CLIENTE:")) {
					partes = linea.split(":");
					String pCliente [] = partes[1].split(";");
					for (String string : pCliente) {
						String p [] = string.split("=");
						if (p[0].equals("NOMBRE")) {
							nombre = p[1];
						}else if (p[0].equals("EMAIL")) {
							email = p[1];
						}else if (p[0].equals("DIRECCION")) {
							direccion = p[1];
						}
					}
				}else if (linea.startsWith("TOTAL:")) {
					partes = linea.split(":");
					total = Double.valueOf(partes[1]);
				}
				linea = leer.readLine();
			}
			
			leer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Cliente c = new Cliente(nombre, email, direccion);
		return new Pedido(id, fecha, c, total);
	}
	
	public static void totalPedidos(List<Pedido> pedid) {
		
		try {
			BufferedWriter escribir = new BufferedWriter(new FileWriter("pedidosTotales.txt", true));
			
			for (Pedido p : pedid) {
				Cliente c = p.getCliente();
				String resul = "ID:"+p.getIdPedido()+"\n"
						+ "FECHA:"+p.getFecha()+"\n"
						+ "CLIENTE:NOMBRE="+c.getNombre()+";EMAIL="+c.getEmail()+";DIRECCION="+c.getDireccion()+"\n"
						+ "TOTAL:"+p.getTotal();
				escribir.write(resul);
				escribir.newLine();
				escribir.write("------------------------------------------------------------------------------------------");
				escribir.newLine();
			}
			
			escribir.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
