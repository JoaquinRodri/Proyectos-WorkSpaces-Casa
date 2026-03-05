package com.daw;

import java.util.Arrays;

public class Lista {
	
	private Integer[] tabla;
	private int contador;
	
	public Lista() {
		this.tabla = new Integer[10];
		this.contador = 0;
	}
	
	public Lista(int capacidad) {
		this.tabla = new Integer[capacidad];
		this.contador = 0;
	}

	//Obtener el número de elementos insertados en la lista. 
	public int size() {
		return this.contador;
	}
	
	//Insertar un número al final de la lista. 
	public void add(Integer numero) {
		if(contador!=tabla.length) {
			//hay hueco
			this.tabla[contador]=numero;
			contador++;
		} else {
			aumentarTamanio(1); //Incremento el tamaño en un hueco
			this.tabla[contador]=numero;
			contador++;
		}
	}
	
	private void aumentarTamanio(int huecos) {
		this.tabla = Arrays.copyOf(this.tabla, this.tabla.length+huecos);
	}

	//Insertar un número al principio de la lista.
	public void addFirst(Integer numero) {
		if(contador!=tabla.length) {
			//hay hueco
			for(int i=contador-1;i>=0;i--) {
				tabla[i+1]=tabla[i];
			}
			tabla[0]=numero;
			contador++;
		} else {
			aumentarTamanio(1); //Incremento el tamaño en un hueco
			for(int i=contador-1;i>=0;i--) {
				tabla[i+1]=tabla[i];
			}
			tabla[0]=numero;
			contador++;
		}
	}
	
	//Insertar un número en un lugar de la lista cuyo índice se pasa como parámetro.
	public void add(int posicion, Integer numero) {
		if(posicion<=contador && posicion >=0) {
			if(contador!=tabla.length) {
				for(int i=contador-1;i>=posicion;i--) {
					tabla[i+1]=tabla[i];
				}
				tabla[posicion]=numero;
				contador++;
			} else {
				aumentarTamanio(1); //Incremento el tamaño en un hueco
				for(int i=contador-1;i>=posicion;i--) {
					tabla[i+1]=tabla[i];
				}
				tabla[posicion]=numero;
				contador++;
			}
		}else {
			System.err.println("No se puede insertar en esa posición.");
		}
	}
	
	//Añadir al final de la lista los elementos de otra lista que se pasa como parámetro.
	public boolean add(Lista lista) {
		if (this.tabla.length - this.contador >= lista.contador) {
			for (int i = 0; i < lista.contador; i++) {
				this.tabla[this.contador] = lista.tabla[i];
				this.contador++;
			}
			return true;
			
		}else {
			int espacios = lista.contador - (this.tabla.length-this.contador);
			aumentarTamanio(espacios);
			for (int i = 0; i < lista.contador; i++) {
				this.tabla[this.contador] = lista.tabla[i];
				this.contador++;
			}
			return true;
			
		}
	}
	
	//Eliminar un elemento cuyo índice en la lista se pasa como parámetro.
	public boolean remove(int posicion) {
		if (posicion < contador && posicion >=0) {
			for (int i = posicion; i < contador-1; i++) {
				tabla[i] = tabla[i+1];
			}
			tabla[contador-1]= null;
			contador--;
			return true;
		}else {
			System.out.println("Posicion no valida");
			return false;
		}
		
	}
	
	//Obtener el elemento cuyo índice se pasa como parámetro.
	public Integer get(int posicion) {
		if(posicion<contador) {
			return tabla[posicion];
		} else {
			System.err.println("Posición fuera de rango.");
			return 0;
		}
	}
	
	//Buscar un número en la lista, devolviendo el índice del primer lugar donde se 
	//encuentre. Si no está, devolver -1. 
	public int indexOf(Integer numero) {
		for (int i = 0; i < tabla.length; i++) {
			if (tabla[i]==numero) {
				return i;
			}
		}
		return -1;
	}
	
	//Representar la lista con una cadena de caracteres. 
	public String toString() {
		String array = "la lista es:\n [";
		for (int i = 0; i < tabla.length-1; i++) {
			array += tabla[i]+", ";
		}
		array += tabla[tabla.length-1] + "]";
		return array;
	}

}
