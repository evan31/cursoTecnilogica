package com.accenture.fers.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.accenture.fers.entity.Event;

/**
*
* @author Carlos Gonzalez Gonzalez
* @version 2.0
* @since 06/03/2018
*/
@Repository("eventDAO")
public class EventDAOJPA implements IEventDAO{

	@PersistenceContext
	EntityManager entityManager;

	public EventDAOJPA(){}

	/**
	 * Devuelve todos los eventos
	 *
	 * @return Lista de eventos
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
	 * Devuelve un evento
	 *
	 * @param eventid Id del evento a buscar
	 * @return Evento encontrado, null si no encuentra nada
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
	 * Actualiza un evento
	 * @param event Evento a actualizar
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
