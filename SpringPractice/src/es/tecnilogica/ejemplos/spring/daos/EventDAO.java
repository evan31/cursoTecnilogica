package es.tecnilogica.ejemplos.spring.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.tecnilogica.ejemplos.spring.entities.Event;

//@Repository("eventDAO")
public class EventDAO implements IEventDAO {

	@Autowired
    private List<Event> events;

    @Override
    public List<Event> showAllEvents() {
        return events;
    }

	/**
	 * @return the events
	 */
	public List<Event> getEvents() {
		return events;
	}

	/**
	 * @param events the events to set
	 */
	public void setEvents(List<Event> events) {
		this.events = events;
	}


}
