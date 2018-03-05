package com.accenture.fers.service;

import java.util.List;

import com.accenture.fers.dao.EventDAO;
import com.accenture.fers.dao.IEventDAO;
import com.accenture.fers.entity.Event;


/**
*
* EventService Implementation
*
* @author Accenture Technology Solutions
*
* @version 1.0
*
*/
public class EventService implements EventFacade{

	IEventDAO eventDAO = new EventDAO();

	/**
	 * This method returns a list of all the available events.
	 *
	 * @return A list of events
	 */
	@Override
	public List<Event> getAllEvents() {
		//Return all available events
		return eventDAO.showAllEvents();
	}

}
