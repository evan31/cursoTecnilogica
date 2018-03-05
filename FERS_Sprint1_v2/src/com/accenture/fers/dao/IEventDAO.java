package com.accenture.fers.dao;

import java.util.List;

import com.accenture.fers.entity.Event;
import com.accenture.fers.exceptions.FERSGenericException;

/**
 * EVENTDAO INTERFACE for defining abstract for EVENTDAOIMPLEMENTATION
 *
 * @author Accenture Technology Solutions
 *
 * @version 1.0
 */
public interface IEventDAO {

	/**
	 * DAO for displaying all the FESTIVALEVENTS in EVENT TABLE
	 * @return collection of all Events
	 * @throws FERSGenericException
	 */
	List<Event> showAllEvents();

	/**
	 * This method fetch the event on basis of eventId
	 * @param eventId
	 * @return event found
	 * @throws FERSGenericException
	 */
	Event getEvent(int eventid);

	/**
	 * This method update an event
	 * @param event
	 * @throws FERSGenericException
	 */
	void updateEvent(Event event);
}
