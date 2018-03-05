package com.accenture.fers.entity;

import com.accenture.fers.config.Configuration;
import com.accenture.fers.exceptions.FERSGenericException;
import com.accenture.fers.utils.Restrictions;
import com.accenture.fers.utils.Validator;


/**
 * Accenture Technology Solutions
 *
 *
 * @version v1
 *
 *          Entity class for Event
 */

public class Event {

	// Atributos principales
	private int eventId;
	private String name;
	private String description;
	private String place;
	private String duration;
	private String eventType;
	private int seatsAvailable;

	// Fichero de configuracion
		private Configuration configuration = null;
	/**
	 * Default constructor
	 *
	 * @param event
	 *
	 */
	public Event() {
		configuration = Configuration.getInstance();
		configuration.loadConfigurationFile("Configuration.properties");
	}
	/**
	 * Copy constructor
	 *
	 * @param event
	 */
	public Event(Event event) {
		configuration = Configuration.getInstance();
		configuration.loadConfigurationFile("Configuration.properties");
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name != null && Validator.validateLength(name, Restrictions.MIN_EVENTNAME, Restrictions.MAX_EVENTNAME)){
			this.name = name;
		}else{
			throw new FERSGenericException(configuration.getConfigurationMessage("ERM_018"));
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if(description != null && Validator.validateLength(description, Restrictions.MIN_DESCRIPTION, Restrictions.MAX_DESCRIPTION)){
			this.description = description;
		}else{
			throw new FERSGenericException(configuration.getConfigurationMessage("ERM_019"));
		}
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		if(place != null && Validator.validateLength(place, Restrictions.MIN_PLACE, Restrictions.MAX_PLACE)){
			this.place = place;
		}else{
			throw new FERSGenericException(configuration.getConfigurationMessage("ERM_020"));
		}
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		if(duration != null && Validator.validateLength(duration, Restrictions.MIN_DURATION, Restrictions.MAX_DURATION)){
			this.duration = duration;
		}else{
			throw new FERSGenericException(configuration.getConfigurationMessage("ERM_021"));
		}
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		if(eventType != null && Validator.validateLength(eventType, Restrictions.MIN_EVENTTYPE, Restrictions.MAX_EVENTTYPE)){
			this.eventType = eventType;
		}else{
			throw new FERSGenericException(configuration.getConfigurationMessage("ERM_022"));
		}
	}

	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(int seatsAvailable) {
		if(seatsAvailable >= 0){
			this.seatsAvailable = seatsAvailable;
		}else{
			throw new FERSGenericException(configuration.getConfigurationMessage("ERM_03"));
		}

	}


}
