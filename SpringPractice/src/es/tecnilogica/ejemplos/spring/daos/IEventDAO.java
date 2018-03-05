package es.tecnilogica.ejemplos.spring.daos;


import java.util.List;

import es.tecnilogica.ejemplos.spring.entities.Event;

public interface IEventDAO {

	List<Event> showAllEvents();


}
