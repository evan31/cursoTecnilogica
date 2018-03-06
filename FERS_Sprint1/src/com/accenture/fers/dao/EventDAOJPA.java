package com.accenture.fers.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.accenture.fers.entity.Event;

/**
*
* EventDAO  Stub Implementation (only by testing)
*
* @author Accenture Technology Solutions
*
* @version 1.0
*/
@Repository("eventDAO")
public class EventDAOJPA implements IEventDAO{

	@PersistenceContext
	EntityManager entityManager;

	public EventDAOJPA(){}

	/**
	 * This method returns a list of all the available events.
	 *
	 * @return A list of events
	 */
	@Override
	public List<Event> showAllEvents() {
		List<Event> events = null;

		try{
			events = entityManager
						.createQuery("SELECT event FROM Event event",Event.class)
						.getResultList();
		}catch(Exception e){
		}

		return events;
	}

	/**
	 * This method returns an event, if it exists.
	 *
	 * @param eventid: Identity of the required event
	 * @return The Event object, if found
	 */
	@Override
	public Event getEvent(int eventid) {
		Event eventFound = null;

		List<Event> events = showAllEvents();

		for (Event event : events) {
			if (event.getEventId() == eventid) {
				eventFound = event;
			}
		}
		return eventFound;
	}

	/**
	 * This method updates the Event
	 * @param Identity of the changing event.
	 */
	@Override
	public void updateEvent(Event event) {
		List<Event> events = showAllEvents();

		for (Event eventL : events) {
			if (eventL.getEventId() == event.getEventId()) {
				eventL = event;
			}
		}
	}

}
