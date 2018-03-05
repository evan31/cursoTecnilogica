package com.accenture.fers.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class EventDAO implements IEventDAO{

	@Autowired
	private List<Event> events;

	public EventDAO(){}

	/**
	 * This method returns a list of all the available events.
	 *
	 * @return A list of events
	 */
	@Override
	public List<Event> showAllEvents() {
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
		for (Event eventL : events) {
			if (eventL.getEventId() == event.getEventId()) {
				eventL = event;
			}
		}
	}

}
