package es.tecnilogica.Ejercicios;

import java.util.Scanner;

/**
 * Ejercicio 14: Piramide de asteriscos
 *
 * @author Carlos González González
 * @version 1.0
 * @since 08/02/2018
 */
public class Ejercicio14 {

	public static void main(String[] args) {
		// Scanner de lectura
		Scanner sc = new Scanner(System.in);

		// Pedimos la altura de la piramide
		System.out.print("Introduce la altura de la piramide:");
		int altura = sc.nextInt();
		sc.nextLine();

		// Obtenemos la base
		int base = calcularBase(altura);

		// Variables para pintar
		int espacios = base/2;
		int asteriscos = 1;

		// Creamos una variable auxiliar inicializada en la base
		for(int i = 0;i < altura ; i++){
			// Pintamos los espacios en blanco
			for(int j = 0; j < espacios;j++){
				System.out.print(" ");
			}
			// Pintamos los asteriscos
			for(int k = 0;k < asteriscos;k++){
				System.out.print("*");
			}
			// Salto de linea
			System.out.println();

			// Cambiamos las variables
			espacios -=1; // Quitamos un espacio para la siguiente fila
			asteriscos +=2; // Añadimos dos asteriscos a la siguiente fila

		}
	}

	/**
	 * Funcion para obtener la base
	 *
	 * @autor Carlos Gonzalez Gonzalez
	 * @param altura
	 * @return base de la piramide
	 */
	public static int calcularBase(int altura){
		return (altura+(altura-1));
	}

}
