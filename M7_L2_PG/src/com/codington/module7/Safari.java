package com.codington.module7;
/**
 * POJO class for SAFARI domain object
 */
public class Safari {

	// Encapsulated data fields for SAFARI class
	private String safariName;
	private String safariDescription;
	private int safariCost;
	private int safariDuration;

	// Getters & Setters
	/**
	 * @return the safariName
	 */
	public String getSafariName() {
		return safariName;
	}
	/**
	 * @return the safariDescription
	 */
	public String getSafariDescription() {
		return safariDescription;
	}
	/**
	 * @return the safariCost
	 */
	public int getSafariCost() {
		return safariCost;
	}
	/**
	 * @return the safariDuration
	 */
	public int getSafariDuration() {
		return safariDuration;
	}
	/**
	 * @param safariName the safariName to set
	 */
	public void setSafariName(String safariName) {
		this.safariName = safariName;
	}
	/**
	 * @param safariDescription the safariDescription to set
	 */
	public void setSafariDescription(String safariDescription) {
		this.safariDescription = safariDescription;
	}
	/**
	 * @param safariCost the safariCost to set
	 */
	public void setSafariCost(int safariCost) {
		this.safariCost = safariCost;
	}
	/**
	 * @param safariDuration the safariDuration to set
	 */
	public void setSafariDuration(int safariDuration) {
		this.safariDuration = safariDuration;
	}
	/**
	 * Metodo toString() sobreescrito para mostrar los datos del safari
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Here are de safari details: [safari Name=" + safariName + ", safari Description="
				+ safariDescription + ", safari Cost=" + safariCost
				+ ", safari Duration=" + safariDuration + "]";
	}
}
