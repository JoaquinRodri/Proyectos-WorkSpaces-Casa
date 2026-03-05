package notas_curso;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		
		
		Alumno a1 = new Alumno("Joaquin", "Rodriguez", "1ºDAW");
		Alumno a2 = new Alumno("Manuel", "Hans", "1ºDAW");
		
		List<Integer> notasA1Mat = new ArrayList<Integer>();
		notasA1Mat.add(5);
		notasA1Mat.add(6);
		notasA1Mat.add(4);
		notasA1Mat.add(8);
		
		List<Integer> notasA1In = new ArrayList<Integer>();
		notasA1In.add(4);
		notasA1In.add(5);
		notasA1In.add(4);
		notasA1In.add(7);
		
		Asignatura as1 = new Asignatura("Matematica", notasA1Mat);
		Asignatura as2 = new Asignatura("Ingles", notasA1In);
		
		HashSet<Asignatura> asignaturasA1 = new HashSet<Asignatura>();
		asignaturasA1.add(as1);
		asignaturasA1.add(as2);
		
		List<Integer> notasA2Mat = new ArrayList<Integer>();
		notasA2Mat.add(5);
		notasA2Mat.add(6);
		notasA2Mat.add(4);
		notasA2Mat.add(8);
		
		List<Integer> notasA2In = new ArrayList<Integer>();
		notasA2In.add(4);
		notasA2In.add(5);
		notasA2In.add(4);
		notasA2In.add(2);
		
		Asignatura as3 = new Asignatura("Matematica", notasA2Mat);
		Asignatura as4 = new Asignatura("Ingles", notasA2In);
		
		HashSet<Asignatura> asignaturasA2 = new HashSet<Asignatura>();
		asignaturasA2.add(as3);
		asignaturasA2.add(as4);
		
		Map<Alumno, HashSet<Asignatura>> curso = new TreeMap<Alumno, HashSet<Asignatura>>();
		
		curso.put(a1, asignaturasA1);
		curso.put(a2, asignaturasA2);
		
		System.out.println(curso);
		
		for (Alumno al : curso.keySet()) {
			HashSet<Asignatura> asigActual = curso.get(al);
			boolean haySuspenso = false;
			for (Asignatura asignatura : asigActual) {
				List <Integer> notasAct = asignatura.getNotas();
				int suma = 0;
				for (Integer n : notasAct) {
					suma+=n;
				}
				float media = (float)suma/notasAct.size();
				if (media<5) {
					haySuspenso = true;
				}
			}
			if (haySuspenso) {
				System.out.println("EL alumno "+al.getNombre()+" esta suspenso.");
			}else {
				System.out.println("EL alumno "+al.getNombre()+" pasa de curso.");
			}
			
		}
		
		

	}

}
