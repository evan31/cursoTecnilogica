package com.codington.module7;



 /**
 * The Zoo class can be used to represent zoo at the NewCodington city.
 * It inherits its properties from the RidesHosting interface
 */

public class Zoo implements RidesHosting {

	// Variables
	private int numberOfAnimals = 0;
	private int zooRide = 0;
	private int zooRideLocation = 0;
	String[] animalNames = null;
	private Safari safari = null;


	public void assignRideCategory() {
		zooRide = HIGH_THRILL;
	}

	/**
	 * Method to display ride details based on ride type
	 */
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

	/**
	 * Method for assigning RIDETYPE based on the zooRide
	 */
	public void assignRideLocation() {
		zooRideLocation = VIRTUAL;
	}


	/**
	 * Method for getting RIDETYPE based on the parkRide
	 */
	public String getRideLocation() {
		String rideTypeDetails = null;
		if(zooRideLocation == INDOOR){
			rideTypeDetails = "Indoor Ride";
		}else{
			if(zooRideLocation == OUTDOOR){
				rideTypeDetails = "Outdoor Ride";
			}else{
				if(zooRideLocation == VIRTUAL){
					rideTypeDetails = "Virtual Ride";
				}
			}
		}
		return rideTypeDetails;
	}


	// Getters & Setters
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
}

