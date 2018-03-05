package com.codington.module6;

public class RidesDetails {

		/**
		 *
		 * Topic: Inheritance in Java
		 * Activity to implement inheritance concepts.		 *
		 * Instructions:Code as per TODOs.
		 */

		// Main method for entry point of RidesDetails program.
		public static void main(String[] args){
			// Zoo
			Zoo zoo = new Zoo(12.45);
			zoo.setNumberOfAnimals(6); // Cambiamos el numero de animales
			// Añadimos los animales
			String[] names = {"Lion", "African Elephants","Australian Kangaroos",
					"Giraffe","Deer","Rhinoceros"};
			zoo.setAnimalNames(names);
			names = null;

			// Safari
			Safari safari = new Safari();
			safari.setSafariCost(2500); // Cambiamos el coste
			safari.setSafariDescription("Night Safari"); // Cambiamos la descripcion
			safari.setSafariDuration(45); // Cambiamos la duracion
			safari.setSafariName("South Codington Safari"); // Cambiamos el nombre


			zoo.setSafari(safari);// Modificamos el safari del zoo
			zoo.setServiceTax(20.50); // Cambiamos la tarifa

			// Llamamos al metodo assignRideCategory()
			zoo.assignRideCategory();
			// Llamamos al metodo getAnimalNames()
			zoo.getAnimalNames();

			// Salidas por pantalla
            // Mostramos los nombres de los animales
			System.out.println("These are some of the animals you'll find at the Codington zoo:");
			for(String s : zoo.animalNames){
				System.out.println(s);
			}
			System.out.println();

            // Mostramos los detalles del zoo
			System.out.println("Rides category of Zoo: " + zoo.getRideDetails());
			System.out.println();

			// Mostramos los detalles del safari
			System.out.println(zoo.getSafari());
			System.out.println();
			 //Mostramos precio
			System.out.println("Codington Zoo Fare Rates INR: " + zoo.calculeFare());
}
}
