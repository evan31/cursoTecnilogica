package com.codington.module4;

public class Event {

	private String eventName;
	private int duration;
	private String location;
	protected String eventDate;

	/**
	 * @return eventName Nombre del evento
	 */
	public String getEventName() {
		return eventName;
	}
	/**
	 * @return duration Duracion
	 */
	public int getDuration() {
		return duration;
	}
	/**
	 * @return location Localizacion
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param eventName El nuevo nombre del evento
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	/**
	 * @param duration La nueva duracion del evento
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	/**
	 * @param location La nueva localizacion del evento
	 */
	public void setLocation(String location) {
		this.location = location;
	}


}
