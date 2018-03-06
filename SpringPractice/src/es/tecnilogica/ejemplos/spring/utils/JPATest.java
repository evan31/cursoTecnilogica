package es.tecnilogica.ejemplos.spring.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.tecnilogica.ejemplos.spring.entities.Event;

public class JPATest {

	public static void main(String[] args) {
		// Creamos el EntityManagerFactory
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("SpringPractice");
		// Creamos el EntityManager
		EntityManager em = emf.createEntityManager();

		// Iniciamos la transaccion 1
		em.getTransaction().begin();

		Event event = new Event();
		event.setDescription("Descripcion test");
		event.setDuration("duration test");
		event.setEventType("Type test");
		event.setName("Nombre test");
		event.setPlace("Place test");
		event.setSeatsAvailable(30);

		em.persist(event);

		em.getTransaction().commit();
		// Fin transaccion 1

		// Iniciamos la transaccion 2
		em.getTransaction().begin();
		Event eventFound = em.find(Event.class, event.getEventid());

		eventFound.setDuration("New Duration");

		em.merge(eventFound);
		em.getTransaction().commit();
		// Fin transaccion 2

		// Iniciamos transaccion 3
		em.getTransaction().begin();

		eventFound = em.find(Event.class, event.getEventid());
		if(eventFound != null){
			em.remove(eventFound);
		}else{
			System.out.println("No se ha encontrado el objeto");
		}

		em.getTransaction().commit();
		// Fin transaccion 3
	}

}
