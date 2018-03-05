package com.codington.module6;
/**
 * Interface for implementing common methods for PARK and ZOO classes
 * @author Carlos Gonzalez Gonzalez
 * @version 1.0
 * @since 12/02/2018
 */
public interface RidesHosting {
	// Constantes
	public final int LOW_THRILL = 1;
	public final int HIGH_THRILL = 2;

	// Metodos
	public void assignRideCategory();
	public String getRideDetails();
}
