package com.daw;

import java.util.HashMap;
import java.util.Map;

public class Alumno {
	
	private Integer codigo;
	private String nombre;
	private String curso;
	private Map<String, Float> asignaturas;
	
	public Alumno(Integer codigo, String nombre, String curso) {
		this.codigo = codigo;
		this.nombre=nombre;
		this.curso=curso;
		this.asignaturas = new HashMap<String, Float>();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Map<String, Float> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(Map<String, Float> asignaturas) {
		this.asignaturas = asignaturas;
	}
	
	public void addNota(String asignatura, Float nota) {
		this.asignaturas.put(asignatura, nota);
	}

	@Override
	public String toString() {
		String respuesta = "";
		respuesta = "Alumno: "+this.getCodigo()+" "+this.getNombre()+": "+this.getCurso()+"\n";
		int contador = 0;
		for (String asig : asignaturas.keySet()) {
			respuesta+= asig+": "+asignaturas.get(asig)+"\n";
			if (asignaturas.get(asig)>5) {
				contador++;
			}
		}
		respuesta+="Asignaturas aprobadas: "+contador+"\n";
		return respuesta;
	}
	
	
	

}
