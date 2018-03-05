package com.codington.module7;

/**
 * Topic: Polymorphism in Java
 * CodingtonRideDetails class for displaying information about Rides hosted in Park and Zoo.
 * The code here depicts how a parent class variable can be used to manipulate objects of various subclasses classes
 * also, how it can  invoke methods on an child object without knowing that object’s type.
 * Instructions: Follow TODO instructions given below
 */

public class CodingtonRideDetails {


	//Main method for entry point of CodingtonRideDetails program

	public static void main(String[] args) {

		// Creamos el parque y llamamos a sus metodos
		RidesHosting parque = new Park();
		parque.assignRideCategory(); // Llamamos a assignRideCategory del padre de parque
		parque.assignRideLocation(); // Llamamos a assignRideLocation del padre de parque

		// Creamos el zoo y llamamos a sus metodos
		RidesHosting zoo = new Zoo();
		zoo.assignRideCategory(); // Llamamos a assignRideCategory del padre de zoo
		zoo.assignRideLocation(); // Llamamos a assignRideLocation del padre de zoo

		// Mostramos lo detalles y la localizacion del parque
		System.out.println("Rides category of PARK: " + parque.getRideDetails()); // Detalles
		System.out.println("Rides location of PARK: " + parque.getRideLocation()); // Localizacion

		// Mostramos los detalles y la localizacion del zoo
		System.out.println("Rides category of ZOO: " + zoo.getRideDetails()); // Detalles
		System.out.println("Rides location of ZOO: " + zoo.getRideLocation()); // Localizacion
	}

}

