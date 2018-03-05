package com.accenture.fers.dao;

import java.util.ArrayList;
import java.util.List;

import com.accenture.fers.entity.Event;

/**
*
* EventDAO  Stub Implementation (only by testing)
*
* @author Accenture Technology Solutions
*
* @version 1.0
*/
public class EventDAO implements IEventDAO{

	private static List<Event> events;

	static{
		events = new ArrayList<Event>();
		Event event1 = new Event();
		event1.setEventId(1);
		event1.setName("evento 1");
		event1.setDescription("description 1");
		event1.setEventType("type 1");
		event1.setPlace("place 1");
		event1.setDuration("duration 1");
		event1.setSeatsAvailable(10);

		Event event2 = new Event();
		event2.setEventId(2);
		event2.setName("evento 2");
		event2.setDescription("description 2");
		event2.setEventType("type 2");
		event2.setPlace("place 2");
		event2.setDuration("duration 2");
		event2.setSeatsAvailable(20);

		events.add(event1);
		events.add(event2);
	}

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
