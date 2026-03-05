package com.daw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Integer opcion;
		List<Integer> temperaturas = new ArrayList<Integer>();
		System.out.println(temperaturas);
		
		do {
			System.out.println("Menu de estacion meteorologica:");
			System.out.println("1- Nuevo registro.");
			System.out.println("2- Listar los registros.");
			System.out.println("3- Mostrar estadisticas.");
			System.out.println("4- Salir.");
			opcion = Integer.valueOf(sc.nextLine());
			
			switch (opcion) {
			case 1:
				Date fecha = new Date();
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy HH:mm");
				String fechaFormateada = formato.format(fecha);
//				String dia;
//				String mes;
//				String anyo;
//				String hora;
//				String minutos;
				String valor;
//				System.out.println("Introduce un nuevo registro:");
//				System.out.println("Introduce el dia (dd):");
//				dia = sc.nextLine();
//				System.out.println("Introduce el mes (mm):");
//				mes = sc.nextLine();
//				System.out.println("Introduce el año (yyyy):");
//				anyo = sc.nextLine();
//				System.out.println("Introduce la hora (hh):");
//				hora = sc.nextLine();
//				System.out.println("Introduce los minutos (mm):");
//				minutos = sc.nextLine();
				System.out.println("Introduce le valor de la temperatura:");
				valor = sc.nextLine();
				String resul = fechaFormateada+"|@|"+valor;
				
				try {
					BufferedWriter escribir = new BufferedWriter(new FileWriter("resources/registro.txt", true));
					escribir.write(resul);
					escribir.newLine();
					
					escribir.close();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
			case 2:
				
				 
				try {
					BufferedReader leer = new BufferedReader(new FileReader("resources/registro.txt"));
					String linea;
					linea = leer.readLine();
					while (linea!=null) {
						String [] partes = linea.split("@");
						System.out.println("Fecha: "+partes[0].replace("|", "")+" Valor: "+partes[1].replace("|", "")+"°C");
						linea = leer.readLine();
					}
					leer.close();
				}catch (FileNotFoundException e) {
					System.out.println("Error el fichero no existe o no se puede abrir.");
				}catch (IOException e) {
					System.out.println("Error al intentar leer el fichero.");
				}
				
				break;
			case 3:
				try {
					BufferedReader leer = new BufferedReader(new FileReader("resources/registro.txt"));
					String linea;
					linea = leer.readLine();
					while (linea!=null) {
						String [] partes = linea.split("@");
						temperaturas.add(Integer.valueOf(partes[1].replace("|", "")));
						linea = leer.readLine();
					}
					leer.close();
				}catch (FileNotFoundException e) {
					System.out.println("Error el fichero no existe o no se puede abrir.");
				}catch (IOException e) {
					System.out.println("Error al intentar leer el fichero.");
				}
				System.out.println("Resultado de estadisticas:");
				int may = temperaturas.getFirst();
				int min = temperaturas.getFirst();
				int sumaTemp = 0;
				for (Integer temp : temperaturas) {
					sumaTemp+=temp;
					if (temp > may) {
						may=temp;
					}
					if (temp<min) {
						min=temp;
					}
				}
				
				System.out.println("Temperatura maxima de los registros: "+may+"°C");
				System.out.println("Temperatura minima de los registros: "+min+"°C");
				System.out.println("Temperatura promedio de los registros: "+((float)sumaTemp/temperaturas.size())+"°C");
				
				break;
			case 4:
				System.out.println("Saliendo....");
				break;

			default:
				System.out.println("Opcion no valida");
				break;
			}
			
			
		} while (opcion!=4);
		
		sc.close();

	}

}
