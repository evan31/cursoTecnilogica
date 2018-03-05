package es.tecnilogica.Ejercicios;

import java.util.Scanner;

/**
 * Ejercicio 13: Leer por teclado una palabra e invertirla hasta que se introduzca 'fin'
 *
 * @author Carlos González González
 * @version 1.0
 * @since 08/02/2018
 */
public class Ejercicio13 {

	public static void main(String[] args) {
		// Scanner de lectura
		Scanner sc = new Scanner(System.in);

		// Variables
		boolean seguirLeyendo = true; // Variable bandera para seguir leyendo
		String cadena = null; // Contiene lo que introduce el usuario
		StringBuilder sb = new StringBuilder();// Clase para invertir la cadena

		// Bucle para pedir y mostrar la palabra a la inversa
		do{
			// Pedimos la palabra
			System.out.print("Introduzca una palabra:");
			cadena = sc.nextLine();

			// Comprobamos si quiere dejar de introducir
			if(!cadena.equalsIgnoreCase("fin")){// Quiere volver a introducir
				sb.setLength(0);// Reiniciamos el StringBuilder por si ha metido algo anteriormente
				sb.append(cadena); // Insertamos la cadena
				System.out.println(sb.reverse()); // La mostramos al reves
			}else{ // No quiere vovler a introducir
				seguirLeyendo = false;
			}
		}while(seguirLeyendo);
	}

}
