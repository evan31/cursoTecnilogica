package com.codington.module7;
/**
 * The Park class can be used to represent parks at the NewCodington city.
 * It inherits its properties from the RidesHosting interface.
 */

public class Park implements RidesHosting {

	// Variables
	private int parkRide = 0;
	private int parkRideLocation = 0;
	/**
	 * Method for assigning ride category to the park.
	 */
	public void assignRideCategory() {
		parkRide = LOW_THRILL;
	}

	/**
	 * Method for getting RIDEDETAILS based on the parkRide
	 */
	//TODO 4. Override getRideDetails() method of interface RidesHosting.
	@Override
	public String getRideDetails(){
		String rideDetails = "";
		if(parkRide == LOW_THRILL){
			rideDetails = "Low Thrill Rides for Children";
		}else{
			if(parkRide == HIGH_THRILL){
				rideDetails = "High Thrill Rides for Teens and Adults";
			}
		}
		return rideDetails;
	}

	/**
	 * Method for assigning RIDETYPE based on the parkRide
	 */

	public void assignRideLocation() {
		parkRideLocation = OUTDOOR;
	}

	/**
	 * Method for getting RIDETYPE based on the parkRide
	 */
	@Override
	public String getRideLocation() {
		String rideTypeDetails = null;

		if(parkRideLocation == INDOOR){
			rideTypeDetails = "Indoor Ride";
		}else{
			if(parkRideLocation == OUTDOOR){
				rideTypeDetails = "Outdoor Ride";
			}else{
				if(parkRideLocation == VIRTUAL){
					rideTypeDetails = "Virtual Ride";
				}
			}
		}
		return rideTypeDetails;
	}
}
