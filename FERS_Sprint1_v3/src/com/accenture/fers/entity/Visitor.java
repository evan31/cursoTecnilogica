package com.accenture.fers.entity;

import java.util.Set;

import com.accenture.fers.exceptions.FERSGenericException;
import com.accenture.fers.utils.Restrictions;
import com.accenture.fers.utils.Validator;

/**
 * @Author Coritel
 *
 * @version v1
 *
 *          Entity class for Visitor
 */

public class Visitor extends People {


	private int visitorId;
	private String userName;
	private String password;
	private Set<Event> registeredEvents;

	public Visitor() {

	}

	public Visitor(Visitor visitor) {

	}

	public int getVisitorId() {
		return visitorId;
	}

	public void setVisitorId(int visitorId) {
		this.visitorId = visitorId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		if(userName != null && Validator.validateLength(userName, Restrictions.MIN_USERNAME, Restrictions.MAX_USERNAME)){
			this.userName = userName;
		}else{
			throw new FERSGenericException(configuration.getConfigurationMessage("ERM_013"));
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if(password != null && Validator.validateLength(password, Restrictions.MIN_PASSWORD, Restrictions.MAX_PASSWORD)){
			this.password = password;
		}else{
			throw new FERSGenericException(configuration.getConfigurationMessage("ERM_014"));
		}
	}

	public Set<Event> getRegisteredEvents() {
		return registeredEvents;
	}

	public void setRegisteredEvents(Set<Event> registeredEvents) {
		this.registeredEvents = registeredEvents;
	}



}
