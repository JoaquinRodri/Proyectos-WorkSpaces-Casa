package com.daw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Biblioteca {
	
	private List<Material> materiales;
	private List<Usuario> usuarios;
	
	public Biblioteca() {
		this.materiales = new ArrayList<Material>();
		this.usuarios = new ArrayList<Usuario>();
	}
	
	
	
	public List<Material> getMateriales() {
		return materiales;
	}



	public void setMateriales(List<Material> materiales) {
		this.materiales = materiales;
	}



	public List<Usuario> getUsuarios() {
		return usuarios;
	}



	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}



	public void agregarMaterial(Material material) {
		boolean esta = false;
		for (Material materi : materiales) {
			if (materi.getCodigo().equals(material.getCodigo())) {
				esta = true;
			}
		}
		
		if (!esta) {
			materiales.add(material);
		}else {
			System.out.println("El material indicado ya existe");
		}
	}
	
	public void registrarUsuario(Usuario usuario) {
		boolean esta = false;
		for (Usuario u : usuarios) {
			if (u.getDni().equals(usuario.getDni())) {
				esta = true;
			}
		}
		
		if (!esta) {
			usuarios.add(usuario);
		}else {
			System.out.println("El usuario indicado ya existe");
		}
		
	}
	
	public Material buscarMaterialPorCodigo(String codigo) {
		Material m = null;
		for (Material material : materiales) {
			if (material.getCodigo().equals(codigo)) {
				m = material;
			}
		}
		return m;
	}
	
	public List<Material> obtenerMaterialDisponible(){
		List <Material> aux = new ArrayList<Material>();
		for (Material material : materiales) {
			if (!material.estaPrestado()) {
				aux.add(material);
			}
			
		}
		return aux;
	}
	
	public List<Material> obtenerMaterialesOrdenados(Comparator<Material> comparador){
		List<Material>aux = materiales;
		Collections.sort(aux, comparador);
		return aux;
	}
	
	public void generarReporte() {
		System.out.println("numero total de materiales: "+materiales.size());
		System.out.println("Materiales prestados:");
		for (Usuario u : usuarios) {
			System.out.println(u);
			System.out.println(u.getMaterialesPrestados());
		}
	}

}
