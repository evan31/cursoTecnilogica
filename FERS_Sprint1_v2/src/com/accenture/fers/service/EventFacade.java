package com.accenture.fers.service;

import java.util.List;

import com.accenture.fers.entity.Event;
import com.accenture.fers.exceptions.FERSGenericException;
/**
 * EVENTFACADE INTERFACE for defining abstract for EVENTSERVICEIMPLEMENTATION
 *
 * @author Accenture Technology Solutions
 *
* @version 1.0
 */
public interface EventFacade {

	/**
	 *  method for displaying all the FESTIVALEVENTS
	 *
	 * @return collection of all Events
	 * @throws FERSGenericException
	 */
	public List<Event> getAllEvents();

}
