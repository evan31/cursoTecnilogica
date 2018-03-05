package com.codington.module6;

/**
 * Topic: Inheritance
 *
 * Instructions:
 * 	Zoo class overrides the methods inherited from the interface RidesHosting
 * 	Zoo hosts High Thrill rides.
 * 	The variable zooRide is used to represent different types of rides.
 * 	The zooRide value is 1 if the ride is a Low Thrill ride for Children and 2 if the
 *  ride is a High Thrill ride for teens and adults.
 *
 * @author Carlos Gonzalez Gonzalez
 * @version 1.0
 * @since 12/02/2018
 */

public class Zoo extends Fare implements RidesHosting{

	// Variables
	private int numberOfAnimals = Integer.MIN_VALUE;
	private int zooRide = 0;
	String[] animalNames = null;
	private Safari safari = null;

	// Constructor vacio
	public Zoo(double serviceTax){
		super(serviceTax);
	}

	/**
	 * @return the numberOfAnimals
	 */
	public int getNumberOfAnimals() {
		return numberOfAnimals;
	}

	/**
	 * @return the zooRide
	 */
	public int getZooRide() {
		return zooRide;
	}

	/**
	 * @return the animalNames
	 */
	public String[] getAnimalNames() {
		return animalNames;
	}

	/**
	 * @return the safari
	 */
	public Safari getSafari() {
		return safari;
	}

	/**
	 * @param numberOfAnimals the numberOfAnimals to set
	 */
	public void setNumberOfAnimals(int numberOfAnimals) {
		this.numberOfAnimals = numberOfAnimals;
	}

	/**
	 * @param zooRide the zooRide to set
	 */
	public void setZooRide(int zooRide) {
		this.zooRide = zooRide;
	}

	/**
	 * @param animalNames the animalNames to set
	 */
	public void setAnimalNames(String[] animalNames) {
		this.animalNames = animalNames;
	}

	/**
	 * @param safari the safari to set
	 */
	public void setSafari(Safari safari) {
		this.safari = safari;
	}


	/**
	 * Asignacion de la categoria
	 */
	@Override
	public void assignRideCategory() {
		zooRide = HIGH_THRILL;

	}

	/**
	 * Obtiene los detalles
	 */
	@Override
	public String getRideDetails() {
		String rideDetails = null;

		if(zooRide == LOW_THRILL){
			rideDetails = "Low Thrill Rides for Children";
		}else{
			if(zooRide == HIGH_THRILL){
				rideDetails = "High Thrill Rides for Teens and Adults";
			}
		}
		return rideDetails;
	}






}
