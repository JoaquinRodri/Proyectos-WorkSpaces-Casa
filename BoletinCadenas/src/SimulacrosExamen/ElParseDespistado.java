package SimulacrosExamen;


public class ElParseDespistado {

	public static void main(String[] args) {
		
		String input = "##id:101##_PROD:teclado Mecánico__PRECIO:45.50;;@@id:202@@__prod:Raton GAMING__Precio:25.00;;!!id:303!!_PrOd:Monitor 24 pulg__prECIO:150.99;;";
		
		//productos separados.
		String [] productos = input.split(";;");
		
		for (int i = 0; i < productos.length; i++) {
			productos[i] = productos[i].replaceAll("#", "").replaceAll("@", "").replaceAll("!!", "").replaceAll("__", "_");
		}
		System.out.println("--- REPORTE DE PRODUCTOS ---");
		System.out.println();
		
		for (int i = 0; i < productos.length; i++) {
			String elementos[] = productos[i].split("_");
			for (int j = 0; j < elementos.length; j++) {
				String elemento[] = elementos[j].split(":");
				String titulo = "";
				if (elemento[0].equalsIgnoreCase("id")) {
					titulo = "ID";
				}else if (elemento[0].equalsIgnoreCase("prod")) {
					titulo = "Producto";
				}else if (elemento[0].equalsIgnoreCase("precio")) {
					titulo = "Precio";
				}
				if (!titulo.equals("Precio")) {
					elemento[1] = capitalizarPalabras(elemento[1]);
					System.out.println(titulo+": "+elemento[1]);
				}else {
					double conIva = (Double.parseDouble(elemento[1]) *1.21);
					System.out.println(titulo+": "+elemento[1]+" € (Con IVA: "+conIva+" €)" );
				}
			}
			System.out.println();
		}
		
		
		

	}
	static String capitalizarPalabras(String palabra) {
		palabra.trim();
		String resultado = "";
		if (palabra.contains(" ")) {
			String palabras[] = palabra.split(" ");
			for (String p : palabras) {
				if (!p.equalsIgnoreCase(" ")) {
					resultado += capitalizar(p)+" ";
				}
			}
			resultado = resultado.trim();
		}else {
			resultado = capitalizar(palabra);
		}
		return resultado;
	}
	
	static String capitalizar(String palabra) {
		palabra = palabra.toLowerCase();
		
		return palabra.substring(0,1).toUpperCase()+palabra.substring(1);
	}
	

}
