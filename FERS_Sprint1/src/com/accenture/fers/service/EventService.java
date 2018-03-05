package com.accenture.fers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service("eventService")
public class EventService implements EventFacade{
	@Autowired
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
