package es.tecnilogica.Ejercicios;

/**
 * Ejercicio 11: Rellenar array bidimensional 10x10 del 1 al 100
 *
 * @author Carlos González González
 * @version 1.0
 * @since 08/02/2018
 */
public class Ejercicio11 {

	private final static int FILAS = 10;
	private final static int COLUMNAS = 10;

	public static void main(String[] args) {
		// Creamos el array bidimensional
		int[][] listaValores = new int[FILAS][COLUMNAS];

		// Creamos un contador que se incrementa con cada iteracion
		int contador = 1;

		// Recorremos las dos secciones y vamos añadiendo valores
		for(int i=0;i<FILAS;i++){
			for(int j=0;j<COLUMNAS;j++){
				listaValores[i][j] = contador;
				contador++;
			}
		}

		// Mostramos el resultado
		for(int i=0;i<FILAS;i++){
			for(int j=0;j<COLUMNAS;j++){
				System.out.print(listaValores[i][j] + " ");
			}
			System.out.println();
		}
	}

}
