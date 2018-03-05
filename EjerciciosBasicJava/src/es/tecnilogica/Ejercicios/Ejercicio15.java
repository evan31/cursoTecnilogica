package es.tecnilogica.Ejercicios;

import java.util.Scanner;

/**
 * Ejercicio 15: Piramide de numeros
 *
 * @author Carlos González González
 * @version 1.0
 * @since 08/02/2018
 */
public class Ejercicio15 {

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
		int valores = 1;

		// Variable contador
		int contador = 0;

		// Creamos una variable auxiliar inicializada en la base
		for(int i = 0;i < altura ; i++){

			// Pintamos los espacios en blanco
			for(int j = 0; j < espacios;j++){
				System.out.print(" ");
			}
			contador = 0;
			// Pintamos los valores
			for(int k = 0;k < valores;k++){
				// Si es una posicion impar pintamos un espacio
				if(k%2==1){
					System.out.print(" ");
				}else{
					// Posicion par y anterior numero ha sido 0 o es el primero
					if(contador==0){
						System.out.print(1);
					}else{ // Posicion par y anterior numero ha sido 1
						System.out.print(0);
					}
					contador++;
				}

				if(contador>1){
					contador = 0;
				}
			}

			// Salto de linea
			System.out.println();

			// Cambiamos las variables
			espacios -=1; // Quitamos un espacio para la siguiente fila
			valores +=2; // Añadimos dos valores mas a la siguiente fila

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
