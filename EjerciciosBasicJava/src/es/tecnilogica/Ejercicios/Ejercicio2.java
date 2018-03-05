package es.tecnilogica.Ejercicios;

import java.util.Scanner;

/**
 * Ejercicio 2: Numero multiplo de 10
 *
 * @author Carlos González González
 * @version 1.0
 * @since 02/07/2018
 */
public class Ejercicio2 {

	public static void main(String[] args) {
		// Scanner de lectura
		Scanner sc = new Scanner(System.in);

		// Pedida de valor
		System.out.println("Introduzca un numero para saber si es multiplo de 10:");
		int num = sc.nextInt();
		sc.nextLine();

		// Averiguamos si el numero es par o impar
		if(num%10==0){
			System.out.println("El numero " + num + " es multiplo de 10");
		}else{
			System.out.println("El numero " + num + " no es multiplo de 10");
		}

	}

}
