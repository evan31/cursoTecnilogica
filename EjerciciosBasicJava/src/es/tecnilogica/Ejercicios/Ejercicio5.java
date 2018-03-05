package es.tecnilogica.Ejercicios;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Ejercicio 5: Programa que tome 6 numeros y los muestre de menor a mayor
 *
 * @author Carlos González González
 * @version 1.0
 * @since 02/07/2018
 */
public class Ejercicio5 {

	public static void main(String[] args) {
		// Scanner de lectura
		Scanner sc = new Scanner(System.in);

		// Creamos el array para guardar los valores
		int[] numeros = new int[6];
		// Variable que vamos a usar para leer los datos
		int num = Integer.MIN_VALUE;

		// Pedimos los numeros y los insertamos en el array
		for(int i = 0;i<numeros.length;i++){
			System.out.print("Introduzca el numero " + (i+1) + " :");
			num = sc.nextInt();
			sc.nextLine();

			numeros[i] = num;
		}

		// Primer apartado: mostrar el menor de los 6
		mostrarMenor(numeros);
		// Segundo apartado: mostrar el mayor de los 6 numeros
		mostrarMayor(numeros);
		// Tercer apartado: ordenados menor a mayor
		System.out.print("Ordenados de menor a mayor: ");
		ordenarAscendente(numeros);
		// Cuarto apartado: ordenados de mayor a menor
		System.out.print("Ordenados de mayor a menor: ");
		ordenarDescendente(numeros);
	}

	/**
	 * Funcion que muestra el menor de los numeros
	 *
	 * @param numeros
	 * @author Carlos González González
	 * @since 08/02/2018
	 */
	public static void mostrarMenor(int[] numeros){
		Integer menor = null; // Variable que contiene el menor numero
		// Buscamos el numero menor
		for(int i : numeros){
			if(menor == null){
				menor = i;
			}else{
				if(i < menor){
					menor = i;
				}
			}
		}

		// Respuesta primer apartado
		System.out.println("El menor es: " + menor);
	}

	/**
	 * Funcion que muestra el mayor de los numeros
	 *
	 * @param numeros
	 * @author Carlos González González
	 * @since 08/02/2018
	 */
	public static void mostrarMayor(int[] numeros){
		Integer mayor = null; // Variable que contiene el numero mayor
		// Buscamos el mayor
		for(int i : numeros){
			if(mayor == null){
				mayor = i;
			}else{
				if(i > mayor){
					mayor = i;
				}
			}
		}
		// Respuesta segundo apartado
		System.out.println("El mayor es: " + mayor);
	}

	/**
	 * Funcion que ordena de manera ascendente
	 *
	 * @param numeros
	 * @author Carlos González González
	 * @since 08/02/2018
	 */
	public static void ordenarAscendente(int[] numeros){
		// Llamamos a la clase Arrays y al metodo que nos lo ordena de manera ascendete
		Arrays.sort(numeros);
		// Mostramos los datos de manera ascendente
		for(int i : numeros){
			System.out.print(i + " ");
		}

		System.out.println();
	}

	/**
	 * Funcion que ordena de manera descendente
	 *
	 * @param numeros
	 * @author Carlos González González
	 * @since 08/02/2018
	 */
	public static void ordenarDescendente(int[] numeros){
		// Llamamos a la clase Arrays y al metodo que nos lo ordena de manera ascendete
		Arrays.sort(numeros);
		// Mostramos los datos de manera descendente
		for(int i = numeros.length-1;i>=0;i--){
			System.out.print(numeros[i] + " ");
		}

		System.out.println();

	}

}
