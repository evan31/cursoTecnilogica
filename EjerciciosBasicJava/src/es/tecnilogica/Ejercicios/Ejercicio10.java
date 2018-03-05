package es.tecnilogica.Ejercicios;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Ejercicio 10: Pedir frase y pasar a un array los caracteres
 *
 * @author Carlos González González
 * @version 1.0
 * @since 08/02/2018
 */
public class Ejercicio10 {

	public static void main(String[] args) {
		// Scanner de lectura
		Scanner sc = new Scanner(System.in);

		// Pedimos el valor
		System.out.print("Introduce una frase:");
		String cadena = sc.nextLine();

		// Creamos el array para guardar los caracteres
		char[] listaCaracteres = new char[cadena.length()];

		// Introducimos los valores
		for(int i = 0; i < cadena.length();i++){
			listaCaracteres[i] = cadena.charAt(i);
		}

		// Mostramos el resultado
		System.out.println(Arrays.toString(listaCaracteres));
	}
}
