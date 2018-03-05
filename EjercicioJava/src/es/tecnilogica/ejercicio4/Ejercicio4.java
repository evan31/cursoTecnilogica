package es.tecnilogica.ejercicio4;

import java.util.Scanner;

/**
 * Ejercicio 4: Indica el dia de la semana
 *
 * @author Carlos González González
 * @version 1.0
 * @since 07/02/2018
 *
 */
public class Ejercicio4 {

	public static void main(String[] args) {
		// Scanner de lectura
		Scanner sc = new Scanner(System.in);

		// Pedida de dato
		System.out.println("Introduzca el numero del dia de la semana a buscar:");
		int numero = sc.nextInt();
		sc.nextLine();

		// Array con los dias de las semana
		String[] semana = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};

		// Respuesta
		System.out.println("El dia de la semana correspondiente al numero " + numero +
				" es: " + semana[numero-1]);
	}
}
