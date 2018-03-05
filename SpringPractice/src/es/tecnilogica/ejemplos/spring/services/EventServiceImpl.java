package es.tecnilogica.ejemplos.spring.services;


import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.tecnilogica.ejemplos.spring.daos.IEventDAO;
import es.tecnilogica.ejemplos.spring.entities.Event;

@Service
public class EventServiceImpl implements EventFacade {
	@Autowired
	private IEventDAO eventDAO ;

    @Override
	public List<Event> getAllEvents() {
		return eventDAO.showAllEvents();
	}

	/**
	 * @return the eventDAO
	 */
	public IEventDAO getEventDAO() {
		return eventDAO;
	}

	/**
	 * @param eventDAO the eventDAO to set
	 */
	public void setEventDAO(IEventDAO eventDAO) {
		this.eventDAO = eventDAO;
	}



}
