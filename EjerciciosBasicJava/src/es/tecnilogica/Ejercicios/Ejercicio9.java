package es.tecnilogica.Ejercicios;

import java.util.Scanner;

/**
 * Ejercicio 9: Programa que dice si es palindromo
 *
 * @author Carlos González González
 * @version 1.0
 * @since 08/02/2018
 */
public class Ejercicio9 {

	public static void main(String[] args) {
		// Scanner de lectura
		Scanner sc = new Scanner(System.in);

		// Pedimos el valor
		System.out.print("Introduce una palabra o frase:");
		String cadena = sc.nextLine();

		// Creamos un StringBuilder para darle la vuelta a la cadena
		StringBuilder sb = new StringBuilder();
		sb.append(cadena);
		sb.reverse();

		// Comprobamos si es palindromo
		if((cadena.replaceAll("\\s", "")).equalsIgnoreCase(sb.toString().replaceAll("\\s", ""))){
			System.out.println("Es palindromo");
		}else{
			System.out.println("No es palindromo");
		}
	}

}
