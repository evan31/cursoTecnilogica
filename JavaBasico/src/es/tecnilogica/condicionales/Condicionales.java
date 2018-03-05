package es.tecnilogica.condicionales;

public class Condicionales {

	public static void main(String[] args) {
		// Variables
		int numero = 5;
		String palabra = "Miercoles";

		// Caso IF - ELSE
		if(numero == 3){
			System.out.println("El numero es 3");
		}else{
			System.out.println("El numero " + numero + " no es 3");
		}

		// Switch
		switch(palabra){
		case "Lunes":
			System.out.println("Hoy es " + palabra);
			break;
		case "Martes":
			System.out.println("Hoy es " + palabra);
			break;
		case "Miercoles":
			System.out.println("Hoy es " + palabra);
			break;
		default:
			System.out.println("Hoy es otro dia");
			break;
		}

	}

}
