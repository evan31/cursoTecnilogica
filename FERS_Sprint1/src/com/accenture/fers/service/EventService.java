package com.accenture.fers.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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
@EnableTransactionManagement
@Service("eventService")
public class EventService implements EventFacade{
	@Autowired
	IEventDAO eventDAO;

	/**
	 * This method returns a list of all the available events.
	 *
	 * @return A list of events
	 */
	@Override
	@Transactional
	public List<Event> getAllEvents() {
		//Return all available events
		return eventDAO.showAllEvents();
	}

}
