package hospital_virgen_del_rocio;

import java.util.ArrayList;

import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * 1.Con una List<EmpleadoHospital> calcula:
		 * 
		 * nómina media, máxima, mínima (usando polimorfismo en calcularNomina()).
		 * 
		 *2. Calcula qué porcentaje de empleados supera un umbral de nómina.
		 * 
		 * 3.Estudio de frecuencias:
		 * 
		 * especialidad médica más frecuente (y recuento).
		 * 
		 * 4Comparator: ordena empleados por criterio múltiple:
		 * 
		 * nómina (desc),
		 * 
		 * antigüedad (desc),
		 * 
		 * nombre (A–Z).
		 */
		
		ArrayList<EmpleadoHospital> empleados = new ArrayList<EmpleadoHospital>();
		
		 TreeSet<String> certM1 = new TreeSet<>();
	        certM1.add("ATLS");
	        certM1.add("ACLS");

	        EmpleadoHospital m1 = new Medico(
	                "12345678A", "Carmen Rojas", 2200.0, 8,
	                "Urgencias", 6, 80.0, certM1
	        );

	        TreeSet<String> certM2 = new TreeSet<>();
	        certM2.add("ECOCARDIO");
	        certM2.add("ACLS");

	        EmpleadoHospital m2 = new Medico(
	                "23456789B", "Antonio Vega", 2400.0, 12,
	                "Cardiología", 4, 95.0, certM2
	        );

	        TreeSet<String> certM3 = new TreeSet<>();
	        certM3.add("PALS");

	        EmpleadoHospital m3 = new Medico(
	                "34567890C", "Lucía Serrano", 2100.0, 4,
	                "Pediatría", 8, 70.0, certM3
	        );

	        // ===== ENFERMEROS (Turno enum) =====
	        ArrayList<Integer> pacE1 = new ArrayList<>();
	        pacE1.add(18); pacE1.add(21); pacE1.add(19); pacE1.add(23); pacE1.add(20); pacE1.add(17); pacE1.add(22);

	        EmpleadoHospital e1 = new Enfermero(
	                "45678901D", "Rafael Molina", 1700.0, 6,
	                Turno.NOCHE, 180.0, pacE1
	        );

	        ArrayList<Integer> pacE2 = new ArrayList<>();
	        pacE2.add(12); pacE2.add(14); pacE2.add(11); pacE2.add(16); pacE2.add(13);

	        EmpleadoHospital e2 = new Enfermero(
	                "56789012E", "María León", 1650.0, 3,
	                Turno.DIA, 0.0, pacE2
	        );

	        // ===== ADMINISTRATIVOS =====
	        ArrayList<String> tareasA1 = new ArrayList<>();
	        tareasA1.add("Gestión de citas");
	        tareasA1.add("Archivo de historiales");
	        tareasA1.add("Atención telefónica");

	        EmpleadoHospital a1 = new Administrativo(
	                "67890123F", "Javier Pineda", 1500.0, 10,
	                2, tareasA1
	        );

	        ArrayList<String> tareasA2 = new ArrayList<>();
	        tareasA2.add("Facturación");
	        tareasA2.add("Tramitación de seguros");
	        tareasA2.add("Informes mensuales");
	        tareasA2.add("Gestión de proveedores");

	        EmpleadoHospital a2 = new Administrativo(
	                "78901234G", "Sara Castillo", 1600.0, 5,
	                3, tareasA2
	        );

	        // ===== AÑADIMOS A LA LISTA =====
	        empleados.add(m1);
	        empleados.add(m2);
	        empleados.add(m3);
	        empleados.add(e1);
	        empleados.add(e2);
	        empleados.add(a1);
	        empleados.add(a2);
	        
	        for (EmpleadoHospital em : empleados) {
	        	System.out.println(em+"\n");
				
			}
	        
	        calculaNominaMinima(empleados);

	}
	public static EmpleadoHospital calculaNominaMinima(ArrayList<EmpleadoHospital> e) {
		EmpleadoHospital elegido = e.getFirst();
		double nominaMasPeque = e.get(0).calcularNomina();
		for (EmpleadoHospital empleado : e) {
			if (empleado.calcularNomina()<nominaMasPeque) {
				nominaMasPeque = empleado.calcularNomina();
				elegido = empleado;
			}
		}
		
		return elegido;
	}

}
