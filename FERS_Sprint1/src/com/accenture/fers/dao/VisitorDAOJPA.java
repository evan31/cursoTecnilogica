package com.accenture.fers.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.accenture.fers.entity.Event;
import com.accenture.fers.entity.Visitor;

/**
*
* @author Carlos Gonzalez Gonzalez
* @version 2.0
* @since 06/03/2018
*/
@Repository("visitorDAO")
public class VisitorDAOJPA implements IVisitorDAO{
	@PersistenceContext
	EntityManager entityManager;

	//private static int lastID = 1;

	public VisitorDAOJPA() {
	}

	/**
	 * Añade un visitor
	 *
	 * @param visitor Visitor a añadir
	 * @return Boolean para saber si ha habido un problema
	 */
	@Override
	public boolean insertData(Visitor visitor) {
		boolean flag = true;

		try{
			entityManager.persist(visitor);
		}catch(Exception e){
			flag = false;
		}


		return flag;
	}

	/**
	 * Actualiza un visitor
	 *
	 * @param Visitor Visitor para actualizar
	 * @return Numero para comprobar el exito de la actualizacion
	 */
	@Override
	public int updateVisitor(Visitor visitor) {
		int update = 0;

		try{
			entityManager.merge(visitor);

			update = 1;
		}catch(Exception e){
			update = 0;
		}

		return update;
	}

	/**
	 * Busca un visitor concreto
	 *
	 * @param visitor Visitor a buscar
	 * @return Visitor encontrado
	 */
	@Override
	public Visitor searchUser(Visitor visitor) {
		Visitor visitorFound = null;

		TypedQuery<Visitor> query = entityManager.createQuery("SELECT v FROM Visitor v WHERE username = ?1",Visitor.class);
		query.setParameter(1, visitor.getUserName());

		try{
			visitorFound = query.getSingleResult();
		}catch(Exception e){
		}

		return visitorFound;
	}

	/**
	 * Registra a un visitor en un evento
	 *
	 * @param Visitor Visitor al que añadir el evento
	 * @param Event Event a añadir
	 */
	@Override
	public void registerVisitorToEvent(Visitor visitor, Event event) {
		Visitor visitorFound = entityManager.find(Visitor.class, visitor.getVisitorId());
		visitorFound.getRegisteredEvents().add(event);
	}

	/**
	 * Quita un evento de un visitor
	 *
	 * @param visitor Visitor al que quitar el evento
	 * @param event Event a quitar
	 */
	@Override
	public void unregisterEvent(Visitor visitor, Event event) {
		Visitor visitorFound = entityManager.find(Visitor.class, visitor.getVisitorId());
		visitorFound.getRegisteredEvents().remove(event);
	}
}
