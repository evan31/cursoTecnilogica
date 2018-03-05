package es.tecnilogica.Ejercicios;

import java.util.Scanner;

/**
 * Ejercicio 12: Calcular el cubo de un numero
 *
 * @author Carlos González González
 * @version 1.0
 * @since 08/02/2018
 */
public class Ejercicio12 {

	// Constante del cubo
	private final static int CUBO = 3;

	public static void main(String[] args) {
		// Scanner de lectura
		Scanner sc = new Scanner(System.in);

		// Pedimos el valor
		System.out.print("Introduce un numero:");
		int valor = sc.nextInt();
		sc.nextLine();

		// Respuesta
		System.out.println("El cubo es: " + (int)Math.pow(valor, CUBO));

	}

}
