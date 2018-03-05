package com.accenture.fers.entity;

import java.util.Set;

import com.accenture.fers.exceptions.FERSGenericException;
import com.accenture.fers.utils.Messages;
import com.accenture.fers.utils.Restrictions;
import com.accenture.fers.utils.Validator;

/**
 * @Author Carlos Gonzalez Gonzalez
 * @since 19/02/2018
 * @version v1
 *
 *          Entity class for Visitor
 */

public class Visitor extends People {


	private int visitorId;
	private String userName;
	private String password;
	private Set<Event> registeredEvents;

	/**
	 * Constructor vacio
	 */
	public Visitor() {

	}

	/**
	 * Constructor de copa
	 * @param visitor Objeto a copiar
	 */
	public Visitor(Visitor visitor) {
		super(visitor);
		if(visitor != null){
			this.visitorId = visitor.getVisitorId();
			this.userName = visitor.getUserName();
			this.password = visitor.getPassword();
			this.registeredEvents = visitor.getRegisteredEvents();
		}else{
			throw new FERSGenericException(Messages.ERM_VACIO);
		}
	}

	/**
	 * Getter de id de visitor
	 * @return Id de visitor
	 */
	public int getVisitorId() {
		return visitorId;
	}

	/**
	 * Setter de id de visitor
	 * @param visitorId Nuevo id del visitor
	 */
	public void setVisitorId(int visitorId) {
		this.visitorId = visitorId;
	}

	/**
	 * Getter de nombre de usuario
	 * @return Nombre de usuario
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Setter de nombre de usuario
	 * @param userName Nuevo nombre de usuario
	 */
	public void setUserName(String userName) {
		if(userName != null && Validator.validateLength(userName, Restrictions.MIN_USERNAME, Restrictions.MAX_USERNAME)){
			this.userName = userName;
		}else{
			throw new FERSGenericException(Messages.ERM_013);
		}
	}

	/**
	 * Getter de contraseña
	 * @return Contraseña
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter de contraseña
	 * @param password Nueva contraseña
	 */
	public void setPassword(String password) {
		if(password != null && Validator.validateLength(password, Restrictions.MIN_PASSWORD, Restrictions.MAX_PASSWORD)){
			this.password = password;
		}else{
			throw new FERSGenericException(Messages.ERM_014);
		}
	}

	/**
	 * Getter de los eventos a los que se ha registrado
	 * @return Eventos registrados
	 */
	public Set<Event> getRegisteredEvents() {
		return registeredEvents;
	}

	/**
	 * Setter de los eventos en los que esta registrado
	 * @param registeredEvents Nuevos eventos en los que se ha registrado
	 */
	public void setRegisteredEvents(Set<Event> registeredEvents) {
		this.registeredEvents = registeredEvents;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime
				* result
				+ ((registeredEvents == null) ? 0 : registeredEvents.hashCode());
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + visitorId;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visitor other = (Visitor) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (registeredEvents == null) {
			if (other.registeredEvents != null)
				return false;
		} else if (!registeredEvents.equals(other.registeredEvents))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (visitorId != other.visitorId)
			return false;
		return true;
	}

}
