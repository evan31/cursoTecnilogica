package com.codington.module6;

/**
 * This is an abstract class which contains Fare details.
 * @author Carlos Gonzalez Gonzalez
 * @version 1.0
 * @since 12/02/2018
 */
public abstract class Fare {
	// Constantes
	private final double BASE_FARE = 1000.2;

	// Atributos
	protected double serviceTax = 0.0;

	// Constructor Vacio
	public Fare(double serviceTax){
		super();
		this.serviceTax = serviceTax;
	}

	// Metodo para calcular la tarifa
	public final double calculeFare(){
		double total = BASE_FARE + serviceTax;
		return total;
	}

	// Setters
	/**
	 * @param serviceTax the serviceTax to set
	 */
	public void setServiceTax(double serviceTax) {
		this.serviceTax = serviceTax;
	}


}
