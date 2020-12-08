
package com.tcs.tallerListas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.tcs.tallerListas.beans.Estudiante;

public class IngresoEstudiantes {

	public static void main(String[] args) {

		System.out.println("################ Ingreso de estudiantes ################");
		// Se crean las listas, para almacenar información, según las condiciones del
		// taller
		List<Estudiante> listEst = new ArrayList<>();
		List<Estudiante> listEstJardin = new ArrayList<>();
		List<Estudiante> listEstPrimero = new ArrayList<>();
		List<Estudiante> listEstSegundo = new ArrayList<>();
		List<Estudiante> listEstTercero = new ArrayList<>();
		List<Estudiante> listEstCuarto = new ArrayList<>();
		List<Estudiante> listEstQuinto = new ArrayList<>();
		List<Estudiante> listEstTi = new ArrayList<>();
		List<Estudiante> lisReprobaron = new ArrayList<>();
		try {
			Scanner data = new Scanner(new File("src/main/resources/data.txt"));
			Estudiante std = null;
			String[] estData = null;
			listEst = new ArrayList<>();
			int contador = 0;
			while (data.hasNextLine()) {
				estData = data.nextLine().split(",");
				std = new Estudiante();
				std.setIdestudiante(estData[0]);
				std.setNombreestudiante(estData[1]);
				std.setEdadestudiante(Integer.parseInt(estData[2]));
				std.setGradoestudiante(estData[3]);
				std.setReprobaron(estData[4]);
				listEst.add(std);
			}
			// Se recorre la lista de estudiantes y se imprime los datos. También se validan
			// algunas condiciones del taller
			for (Estudiante obj : listEst) {
				System.out.println("Id: " + obj.getIdestudiante());
				System.out.println("Nombre: " + obj.getNombreestudiante());
				System.out.println("Edad: " + obj.getEdadestudiante());
				System.out.println("Grado: " + obj.getGradoestudiante());
				System.out.println("Alumno aprobó grado? A O R:" + " " + obj.getReprobaron());
				System.out.println("============================ ");

				if (obj.getEdadestudiante() >= 6 && obj.getEdadestudiante() <= 10) {
					contador++;
				}
				if (obj.getGradoestudiante().equalsIgnoreCase("jardin")) {
					listEstJardin.add(obj);

				} else if (obj.getGradoestudiante().equalsIgnoreCase("primero")) {
					listEstPrimero.add(obj);
				} else if (obj.getGradoestudiante().equalsIgnoreCase("segundo")) {
					listEstSegundo.add(obj);
				} else if (obj.getGradoestudiante().equalsIgnoreCase("tercero")) {
					listEstTercero.add(obj);
				} else if (obj.getGradoestudiante().equalsIgnoreCase("cuarto")) {
					listEstCuarto.add(obj);
				} else {
					listEstQuinto.add(obj);
				}

				if (obj.getIdestudiante().substring(0, 2).equalsIgnoreCase("TI")) {
					listEstTi.add(obj);
				}
				if (obj.getReprobaron().equalsIgnoreCase("R")) {
					lisReprobaron.add(obj);
				}
			}
			System.out.println("Elnúmero total de estudiantes es:" + listEst.size());
			System.out.println("El número de estudiantes entre 6 y 10 años es:" + contador);
			System.out.println("*********Estudiantes grado JARDIN********");
			imprimirLista(listEstJardin);
			System.out.println("*********Estudiantes grado PRIMERO********");
			imprimirLista(listEstPrimero);
			System.out.println("*********Estudiantes grado SEGUNDO********");
			imprimirLista(listEstSegundo);
			System.out.println("*********Estudiantes grado TERCERO********");
			imprimirLista(listEstTercero);
			System.out.println("*********Estudiantes grado CUARTO********");
			imprimirLista(listEstCuarto);
			System.out.println("*********Estudiantes grado QUINTO********");
			imprimirLista(listEstQuinto);
			System.out.println("********* Estudiantes empiezan con “TI”********");
			for (Estudiante obj : listEstTi) {
				System.out.println("Edad: " + obj.getEdadestudiante());
				System.out.println("Grado: " + obj.getGradoestudiante());
			}
			System.out.println("*******Alumnos que reprobaron el año******");
			imprimirLista(lisReprobaron);

		} catch (FileNotFoundException e) {

		} catch (NumberFormatException e) {
			System.out.println("Error convirtiendo la edad en entero " + e);
		}
	}

	// Método que recibe como parametro la lista, según la información solicitada en
	// el taller
	private static void imprimirLista(List<Estudiante> lista) {
		for (Estudiante obj : lista) {
			System.out.println("Id: " + obj.getIdestudiante());
			System.out.println("Nombre: " + obj.getNombreestudiante());
			System.out.println("Edad: " + obj.getEdadestudiante());
			System.out.println("Grado: " + obj.getGradoestudiante());
		}

	}

}
