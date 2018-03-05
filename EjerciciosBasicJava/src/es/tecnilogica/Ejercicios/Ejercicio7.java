package es.tecnilogica.Ejercicios;

import java.util.Scanner;

/**
 * Ejercicio 7: Programa de cambio de unidades de peso
 *
 * @author Carlos González González
 * @version 1.0
 * @since 08/02/2018
 */
public class Ejercicio7 {

	private final static int HECTOGRAMOS = 10;
	private final static int DECAGRAMOS = 100;
	private final static int GRAMOS = 1000;
	private final static int DECIGRAMOS = GRAMOS*10;
	private final static int CENTIGRAMOS = GRAMOS*100;
	private final static int MILIGRAMOS = GRAMOS*1000;

	public static void main(String[] args) {
		// Scanner de lectura
		Scanner sc = new Scanner(System.in);

		// Pedimos el valor
		System.out.print("Introduce un valor (Kg):");
		int valor = sc.nextInt();
		sc.nextLine();

		// Mostramos el menu
		mostrarMenu();
		int opcionMenu = sc.nextInt();
		sc.nextLine();

		// Convertimos
		convertirPeso(valor,opcionMenu);
	}

	/**
	 * Funcion que muestra el menu de conversion
	 *
	 * @author Carlos Gonzalez Gonzalez
	 * since 08/02/2018
	 */
	public static void mostrarMenu(){
		System.out.println("Elija el cambio de unidad:");
		System.out.println("1- Hectogramos");
		System.out.println("2- Decagramos");
		System.out.println("3- Gramos");
		System.out.println("4- Decigramos");
		System.out.println("5- Centigramos");
		System.out.println("6- Miligramos");
	}
	/**
	 * Funcion que convierte el valor introducido por el usuario al peso indicado
	 *
	 * @author Carlos Gonzalez Gonzalez
	 * since 08/02/2018
	 */
	public static void convertirPeso(int valor, int opcionMenu){
		int valorConvertido = 0;
		String medida = null;

		switch(opcionMenu){
		case 1:
			valorConvertido = valor*HECTOGRAMOS;
			medida = "hectogramos";
			break;
		case 2:
			valorConvertido = valor*DECAGRAMOS;
			medida = "decagramos";
			break;
		case 3:
			valorConvertido = valor*GRAMOS;
			medida = "gramos";
			break;
		case 4:
			valorConvertido = valor*DECIGRAMOS;
			medida = "decigramos";
			break;
		case 5:
			valorConvertido = valor*CENTIGRAMOS;
			medida = "centigramos";
			break;
		case 6:
			valorConvertido = valor*MILIGRAMOS;
			medida = "miligramos";
			break;
		}

		System.out.println(valor + " Kg son " + valorConvertido + " " + medida);
	}
}
