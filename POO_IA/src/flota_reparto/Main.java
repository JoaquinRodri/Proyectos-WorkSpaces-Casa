package flota_reparto;

import java.util.ArrayList;
import java.util.Collections;


public class Main {

	public static void main(String[] args) {


		 // ===== TRANSPORTES =====
        Transporte t1 = new Furgoneta("1234-JKL", 0.55, 900.0, true, 0.12);
        Transporte t2 = new Furgoneta("5678-MNP", 0.50, 750.0, false, 0.00);

        Transporte t3 = new Camion("2222-BCD", 0.85, 5000.0, 5, 0.18);
        Transporte t4 = new Camion("3333-CDF", 0.90, 8000.0, 6, 0.22);

        Transporte t5 = new Moto("M-9090", 0.30, 40.0, 125, 0.06);
        Transporte t6 = new Moto("M-8080", 0.35, 60.0, 300, 0.09);

        // ===== ENVIOS =====
        ArrayList<Envio> envios = new ArrayList<>();

        // Envío 1 (Furgoneta refrigerada, centro, con incidencias)
        ArrayList<Double> paradas1 = new ArrayList<>();
        paradas1.add(3.2); paradas1.add(2.4); paradas1.add(1.8); paradas1.add(4.1);

        ArrayList<Incidencia> inc1 = new ArrayList<>();
        inc1.add(Incidencia.TRAFICO);
        inc1.add(Incidencia.RETRASO);

        envios.add(new Envio("E-001", t1, 11.5, 120.0, Zona.CENTRO, paradas1, inc1));


        // Envío 2 (Moto pequeña, centro, sin incidencias)
        ArrayList<Double> paradas2 = new ArrayList<>();
        paradas2.add(2.0); paradas2.add(1.7); paradas2.add(1.9);

        ArrayList<Incidencia> inc2 = new ArrayList<>();

        envios.add(new Envio("E-005", t5, 5.6, 12.0, Zona.CENTRO, paradas2, inc2));


        // Envío 3 (Camión 5 ejes, afueras, incidencia lluvia)
        ArrayList<Double> paradas3 = new ArrayList<>();
        paradas3.add(18.0); paradas3.add(12.5); paradas3.add(9.0);

        ArrayList<Incidencia> inc3 = new ArrayList<>();
        inc3.add(Incidencia.LLUVIA);

        envios.add(new Envio("E-003", t3, 39.5, 1800.0, Zona.AFUERAS, paradas3, inc3));


        // Envío 4 (Furgoneta no refrigerada, afueras, dirección incorrecta + retraso)
        ArrayList<Double> paradas4 = new ArrayList<>();
        paradas4.add(6.0); paradas4.add(7.5); paradas4.add(5.8); paradas4.add(4.9);

        ArrayList<Incidencia> inc4 = new ArrayList<>();
        ArrayList<Incidencia> inc7 = new ArrayList<>();
        inc4.add(Incidencia.DIRECCION_INCORRECTA);
        inc4.add(Incidencia.RETRASO);
        inc7.add(Incidencia.RETRASO);
        
        

        envios.add(new Envio("E-004", t2, 24.2, 260.0, Zona.AFUERAS, paradas4, inc4));
        envios.add(new Envio("E-007", t2, 24.2, 260.0, Zona.AFUERAS, paradas4, inc7));


        // Envío 5 (Moto mediana, afueras, avería + tráfico)
        ArrayList<Double> paradas5 = new ArrayList<>();
        paradas5.add(4.4); paradas5.add(6.1); paradas5.add(3.8); paradas5.add(2.9);

        ArrayList<Incidencia> inc5 = new ArrayList<>();
        inc5.add(Incidencia.AVERIA);
        inc5.add(Incidencia.TRAFICO);

        envios.add(new Envio("E-002", t6, 17.2, 22.0, Zona.AFUERAS, paradas5, inc5)); // <-- ojo: si tu enum es AFUERAS, corrige esta palabra


        // Envío 6 (Camión 6 ejes, afueras, varias incidencias)
        ArrayList<Double> paradas6 = new ArrayList<>();
        paradas6.add(25.0); paradas6.add(18.0); paradas6.add(22.5);

        ArrayList<Incidencia> inc6 = new ArrayList<>();
        inc6.add(Incidencia.TRAFICO);
        inc6.add(Incidencia.RETRASO);
        inc6.add(Incidencia.LLUVIA);

        envios.add(new Envio("E-006", t4, 65.5, 4200.0, Zona.AFUERAS, paradas6, inc6));


        // Ya tienes List<Envio> envios lista para:
        // - costes (Tarificable), medias, max/min
        System.out.println("media:");
        calcularMedia(envios);
        System.out.println("Maximo:");
        calcularMax(envios);
        System.out.println("Minimo:");
        calcularMin(envios);
        costeTotal(envios);
        
        // - coste/kg
        costePorKgMaxYMin8(envios);
        // - frecuencias de incidencias (ahora con List, pueden repetirse si lo permites)
        incidenciaMasFrecuente(envios);
        // - ordenaciones (Comparable/Comparator)
        Collections.sort(envios);
        System.out.println(envios);
        Collections.sort(envios, new ComparadorPorVarios());
        System.out.println(envios);

	}
	
	public static void incidenciaMasFrecuente(ArrayList<Envio> envios) {
		int contAveria = 0;
		int contLluvia = 0;
		int contTrafico = 0;
		int contRetraso = 0;
		int contdirec = 0;
		int enviosSinIncidencia = 0;
		int max =0;
		String incidencia = "";
		
		for (Envio envio : envios) {
			if (envio.getIncidencias().size() > 0) {
				for (Incidencia inc : envio.getIncidencias()) {
					if (inc.name().equals(Incidencia.AVERIA.name())) {
						contAveria++;
					}
					if (inc.name().equals(Incidencia.DIRECCION_INCORRECTA.name())) {
						contdirec++;
					}
					if (inc.name().equals(Incidencia.LLUVIA.name())) {
						contLluvia++;
					}
					if (inc.name().equals(Incidencia.RETRASO.name())) {
						contRetraso++;
					}
					if (inc.name().equals(Incidencia.TRAFICO.name())) {
						contTrafico++;
					}
				}
			}else {
				enviosSinIncidencia++;
			}
			if (max < contAveria) {
				max = contAveria;
				incidencia = "AVERIA";
			}
			if (max < contdirec) {
				max = contdirec;
				incidencia = "DIRECCION-INCORRECTA";
			}
			if (max < contLluvia) {
				max = contLluvia;
				incidencia = "LLUVIA";
			}
			if (max < contRetraso) {
				max = contRetraso;
				incidencia = "RETRASO";
			}
			if (max < contTrafico) {
				max = contTrafico;
				incidencia = "TRAFICO";
			}
		}
		
		System.out.println("La incidencia mas frecuente es: "+incidencia+", "+max+" veces");
		System.out.println("Numero de envios sin incidencia: "+enviosSinIncidencia);
		
		
		
	}

	public static void costePorKgMaxYMin8(ArrayList<Envio> envios) {
		double max = 0;
		double min = envios.getFirst().calcularCoste()/envios.getFirst().getPesoKg();
		Envio maxP = null;
		Envio minP = null;
		for (Envio envio : envios) {
			double e = envio.calcularCoste()/envio.getPesoKg();
			if (max < e) {
				max = e;
				maxP = envio;
			}
			if (min > e) {
				min = e;
				minP = envio;
			}
		}
		
		System.out.println("El envio maximo es "+maxP.getId()+"con coste por Kg: "+max);
		System.out.println("El envio minimo es "+minP.getId()+"con coste por Kg: "+min);
		
	}

	public static void costeTotal(ArrayList<Envio> envios) {
		double total = 0;
		for (Envio envio : envios) {
			total += envio.calcularCoste();
		}
		
		System.out.println("Coste total: "+total);
	}

	public static void calcularMedia(ArrayList<Envio> envios) {
		double total = 0;
		for (Envio envio : envios) {
			total += envio.calcularCoste();
		}
		double media = total/envios.size();
		System.out.println("La media de los envios es: "+media);
		
	}
	
	public static void calcularMax(ArrayList<Envio> envios) {
		double max = 0;
		for (Envio envio : envios) {
			if (envio.calcularCoste()>max) {
				max = envio.calcularCoste();
			}
		}
		
		System.out.println("el envio mas caro es: "+max);
		
	}
	
	public static void calcularMin(ArrayList<Envio> envios) {
		double min = envios.getFirst().calcularCoste();
		Envio e = null;
		for (Envio envio : envios) {
			if (envio.calcularCoste()<min) {
				min = envio.calcularCoste();
				 e = envio;
			}
		}
		
		System.out.println("el envio mas barato es: "+min+"con el id:"+e.getId());
		
	}

}
