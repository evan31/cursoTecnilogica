package es.tecnilogica.ejemplos.spring.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import es.tecnilogica.ejemplos.spring.entities.Event;

@Repository("eventDAO")
public class EventDAOJPA implements IEventDAO{
	@PersistenceContext
	EntityManager entityManager;

	public EventDAOJPA() {
	}

	public List<Event> showAllEvents(){
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
	 * @return the entityManager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * @param entityManager the entityManager to set
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
