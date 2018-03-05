package es.tecnilogica.Ejercicios;

import java.util.Scanner;

/**
 * Ejercicio 6: Programa que tome 3 numeros y :
 * 				1 - Tercer numero = a*b
 * 				2 - Tercer numero = a/b
 * 				3 - Tercer numero = (a%b)
 *
 * @author Carlos González González
 * @version 1.0
 * @since 08/02/2018
 */
public class Ejercicio6 {

	public static void main(String[] args) {
		// Scanner de lectura
		Scanner sc = new Scanner(System.in);
		// Creamos el array para guardar los valores
		int[] numeros = new int[3];
		// Variable que vamos a usar para leer los datos
		int num = Integer.MIN_VALUE;

		// Pedimos los numeros y los insertamos en el array
		for(int i = 0;i<numeros.length;i++){
			System.out.print("Introduzca el numero " + (i+1) + " :");
			num = sc.nextInt();
			sc.nextLine();

			numeros[i] = num;
		}

		// Primer apartado: c = a*b
		if(compruebaSiEsResMultiplicacion(numeros)){
			System.out.println(numeros[2] + " es el resultado de multiplicar " +
					numeros[0] + "x" + numeros[1]);
		}else{
			System.out.println(numeros[2] + " no es el resultado de multiplicar " +
					numeros[0] + "x" + numeros[1]);
		}
		// Segundo apartado: c = a/b
		if(compruebaSiEsResDivision(numeros)){
			System.out.println(numeros[2] + " es el cociente de dividir " +
					numeros[0] + "/" + numeros[1]);
		}else{
			System.out.println(numeros[2] + " no es el cociente de dividir " +
					numeros[0] + "/" + numeros[1]);
		}
		// Tercer apartado: c = (a%b)
		if(compruebaSiEsModulo(numeros)){
			System.out.println(numeros[2] + " es el modulo de " +
					numeros[0] + "%" + numeros[1]);
		}else{
			System.out.println(numeros[2] + " no es el modulo de " +
					numeros[0] + "%" + numeros[1]);
		}
	}

	/**
	 * Obtiene si el tercer numero es el resultado de multiplcar los dos primeros
	 *
	 * @param numeros
	 * @return true, si el tercer numero es la multiplicacion de los dos primeros; false, si no lo es
	 */
	public static boolean compruebaSiEsResMultiplicacion(int[] numeros){
		if(numeros[2] == (numeros[0]*numeros[1])){
			return true;
		}
		return false;
	}

	/**
	 * Obtiene si el tercer numero es el resultado de dividir los dos primeros
	 *
	 * @param numeros
	 * @return true, si el tercer numero es el cociente de los dos primeros; false, si no lo es
	 */
	public static boolean compruebaSiEsResDivision(int[] numeros){
		if(numeros[2] == (numeros[0]/numeros[1])){
			return true;
		}
		return false;
	}

	/**
	 * Obtiene si el tercer numero es el modulo de los dos primeros
	 *
	 * @param numeros
	 * @return true, si el tercer numero es el modulo de los dos primeros; false, si no lo es
	 */
	public static boolean compruebaSiEsModulo(int[] numeros){
		if(numeros[2] == (numeros[0]%numeros[1])){
			return true;
		}
		return false;
	}
}
