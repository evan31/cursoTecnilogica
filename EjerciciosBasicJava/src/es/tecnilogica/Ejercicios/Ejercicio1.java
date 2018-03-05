package es.tecnilogica.Ejercicios;

import java.util.Scanner;
/**
 * Ejercicio 1: Numero par/impar
 *
 * @author Carlos González González
 * @version 1.0
 * @since 02/07/2018
 */
public class Ejercicio1 {

	public static void main(String[] args) {
		// Scanner de lectura
		Scanner sc = new Scanner(System.in);

		// Pedida de valor
		System.out.println("Introduzca un numero para saber si es par o impar:");
		int num = sc.nextInt();
		sc.nextLine();

		// Averiguamos si el numero es par o impar
		if(num%2==0){
			System.out.println("El numero " + num + " es par");
		}else{
			System.out.println("El numero " + num + " es impar");
		}

	}
}
