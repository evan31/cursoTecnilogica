package es.tecnilogica.Ejercicios;

import java.util.Scanner;

/**
 * Ejercicio 8: Programa que muestra las letras de una palabra una debajo de otra
 *
 * @author Carlos González González
 * @version 1.0
 * @since 08/02/2018
 */
public class Ejercicio8 {

	public static void main(String[] args) {
		// Scanner de lectura
		Scanner sc = new Scanner(System.in);

		// Pedida de valor
		System.out.print("Introduzca una palabra:");
		String cadena = sc.nextLine();

		// Mostramos las letras una debajo de otra
		for(int i = 0;i < cadena.length();i++){
			System.out.println(cadena.charAt(i));
		}
	}
}
