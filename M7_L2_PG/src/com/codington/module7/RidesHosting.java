package com.codington.module7;

/**
 * Interface for implementing common methods for PARK and ZOO classes
 */
public interface RidesHosting {

	// Constantes
	public final int LOW_THRILL = 1;
	public final int HIGH_THRILL = 2;
	public final int INDOOR = 3;
	public final int OUTDOOR = 4;
	public final int VIRTUAL = 5;

	// Metodos
	public void assignRideCategory();
	public String getRideDetails();
	public void  assignRideLocation();
	public String getRideLocation();

}
