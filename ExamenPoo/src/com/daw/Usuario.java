package com.daw;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	private String id;
	private String nombre;
	private String dni;
	private String email;
	private List<Material> materialesPrestados;
	
	
	
	public Usuario(String id, String nombre, String dni, String email) {
		this.id = id;
		this.nombre = nombre;
		this.dni = dni;
		this.email = email;
		this.materialesPrestados = new ArrayList<Material>();
	}


	public Usuario(String id, String nombre, String dni, String email, ArrayList<Material> materialesPrestados) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dni = dni;
		this.email = email;
		this.materialesPrestados = materialesPrestados;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public List<Material> getMaterialesPrestados() {
		return materialesPrestados;
	}


	public void setMaterialesPrestados(ArrayList<Material> materialesPrestados) {
		this.materialesPrestados = materialesPrestados;
	}
	
	public String toString() {
		String aux = "\nNombre: "+getNombre()+"\r\n"
				+ "Email: "+getEmail()+"\r\n"
				+ "Materiales Pretados :"+materialesPrestados;
		return aux;
		
	}

}
