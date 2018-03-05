package es.tecnilogica.Ejercicios;

import java.util.Scanner;

/**
 * Ejercicio 3: Numero entre 1 y 30 es primo
 *
 * @author Carlos González González
 * @version 1.0
 * @since 02/07/2018
 */
public class Ejercicio3 {

	public static void main(String[] args) {
		// Scanner de lectura
		Scanner sc = new Scanner(System.in);

		// Pedida de valor
		System.out.println("Introduzca un numero entre 1 y 30");
		int num = sc.nextInt();
		sc.nextLine();

		// Comprobamos si es mayor que cero
		if(num<1){
			System.out.println("Debe introducir un numero mayor o igual que uno");
		}else{
			// Comprobamos que sea menor o igual que 30
			if(num>30){
				System.out.println("Debe introducir un valor menor o igual que 30");
			}else{
				// Creamos una variable bandera
				boolean esPrimo = true;
				// Hacemos un bucle hasta el numero introducido asegurandonos
				// de que no es multiplo de ningun otro numero hasta él mismo
				for(int i = 1;i<=num && esPrimo;i++){
					if(num%i==1){
						esPrimo = false;
					}
				}

				// Respuesta
				if(esPrimo){
					System.out.println("El numero " + num + " es primo");
				}else{
					System.out.println("El numero " + num + " no es primo");
				}

			}
		}
	}

}
