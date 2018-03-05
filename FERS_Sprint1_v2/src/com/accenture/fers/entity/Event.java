package com.accenture.fers.entity;

import com.accenture.fers.exceptions.FERSGenericException;
import com.accenture.fers.utils.Messages;
import com.accenture.fers.utils.Restrictions;
import com.accenture.fers.utils.Validator;


/**
 * @Author Carlos Gonzalez Gonzalez
 * @since 19/02/2018
 * @version v1
 *
 *          Entity class for Event
 */

public class Event {

	private int eventId;
	private String name;
	private String description;
	private String place;
	private String duration;
	private String eventType;
	private int seatsAvailable;

	/**
	 * Default constructor
	 *
	 */
	public Event() {

	}
	/**
	 * Copy constructor
	 * @param event
	 */
	public Event(Event event) {
		if(event != null){
			this.eventId = event.getEventId();
			this.description = event.getDescription();
			this.duration = event.getDuration();
			this.eventType = event.getEventType();
			this.name = event.getName();
			this.seatsAvailable = event.getSeatsAvailable();
			this.place = event.getPlace();
		}else{
			throw new FERSGenericException(Messages.ERM_VACIO);
		}
	}

	/**
	 * Getter del id del evento
	 * @return Devuelve el id del evento
	 */
	public int getEventId() {
		return eventId;
	}

	/**
	 * Setter del id del evento
	 * @param eventId Nuevo id del evento
	 */
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	/**
	 * Getter del nombre del evento
	 * @return Devuelve el nombre del evento
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter del nombre del evento
	 * @param name Nuevo nombre del evento
	 */
	public void setName(String name) {
		if(name != null && Validator.validateLength(name, Restrictions.MIN_EVENTNAME, Restrictions.MAX_EVENTNAME)){
			this.name = name;
		}else{
			throw new FERSGenericException(Messages.ERM_018);
		}
	}

	/**
	 * Getter de la descripcion
	 * @return Descripcion del evento
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Setter de la descripcion del evento
	 * @param description Nueva descripcion del evento
	 */
	public void setDescription(String description) {
		if(description != null && Validator.validateLength(description, Restrictions.MIN_DESCRIPTION, Restrictions.MAX_DESCRIPTION)){
			this.description = description;
		}else{
			throw new FERSGenericException(Messages.ERM_019);
		}
	}

	/**
	 * Getter del lugar del evento
	 * @return Lugar del evento
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * Setter del lugar del evento
	 * @param place Nuevo lugar del evento
	 */
	public void setPlace(String place) {
		if(place != null && Validator.validateLength(place, Restrictions.MIN_PLACE, Restrictions.MAX_PLACE)){
			this.place = place;
		}else{
			throw new FERSGenericException(Messages.ERM_020);
		}
	}

	/**
	 * Getter de la duracion del evento
	 * @return Duracion del evento
	 */
	public String getDuration() {
		return duration;
	}

	/**
	 * Setter de la duracion del evento
	 * @param duration Nueva duracion del evento
	 */
	public void setDuration(String duration) {
		if(duration != null && Validator.validateLength(duration, Restrictions.MIN_DURATION, Restrictions.MAX_DURATION)){
			this.duration = duration;
		}else{
			throw new FERSGenericException(Messages.ERM_021);
		}
	}

	/**
	 * Getter del tipo de evento
	 * @return Tipo de evento
	 */
	public String getEventType() {
		return eventType;
	}

	/**
	 * Setter del tipo de evento
	 * @param eventType Nuevo tipo de evento
	 */
	public void setEventType(String eventType) {
		if(eventType != null && Validator.validateLength(eventType, Restrictions.MIN_EVENTTYPE, Restrictions.MAX_EVENTTYPE)){
			this.eventType = eventType;
		}else{
			throw new FERSGenericException(Messages.ERM_022);
		}
	}

	/**
	 * Getter del numero de plazas
	 * @return Numero de plazas
	 */
	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	/**
	 * Setter del numero de plazas
	 * @param seatsAvailable Nuevo numero de plazas
	 */
	public void setSeatsAvailable(int seatsAvailable) {
		if(seatsAvailable >= 0){
			this.seatsAvailable = seatsAvailable;
		}else{
			throw new FERSGenericException(Messages.ERM_023);
		}

	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + eventId;
		result = prime * result
				+ ((eventType == null) ? 0 : eventType.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result + seatsAvailable;
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (eventId != other.eventId)
			return false;
		if (eventType == null) {
			if (other.eventType != null)
				return false;
		} else if (!eventType.equals(other.eventType))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		if (seatsAvailable != other.seatsAvailable)
			return false;
		return true;
	}



}
