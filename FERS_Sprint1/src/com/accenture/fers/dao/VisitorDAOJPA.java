package com.accenture.fers.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.accenture.fers.entity.Event;
import com.accenture.fers.entity.Visitor;

/**
*
* VisitortDAO  Stub Implementation (only by testing)
*
* @author Accenture Technology Solutions
*
* @version 1.0
*/
@Repository("visitorDAO")
public class VisitorDAOJPA implements IVisitorDAO{
	@PersistenceContext
	EntityManager entityManager;

	//private static int lastID = 1;

	public VisitorDAOJPA() {
	}

	/**
	 * This method adds a new visitor to database if it doesn't already exists
	 *
	 * @param Visitor to add
	 * @return Boolean value to check if the operation was succeed
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
	 * This method updates all the visitor data in the database
	 *
	 * @param Visitor object that has to be updated
	 * @return Integer value to check if operation succeed
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
	 * This method looks for a user in the database
	 *
	 * @param User's name
	 * @param User's password
	 * @return Visitor object if it already exists, null value otherwise
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
	 * This method registers a visitor to a specified event
	 *
	 * @param Visitor that has to be registered to an event
	 * @param Event to register
	 */
	@Override
	public void registerVisitorToEvent(Visitor visitor, Event event) {
		Visitor visitorFound = entityManager.find(Visitor.class, visitor.getVisitorId());
		visitorFound.getRegisteredEvents().add(event);
	}

	/**
	 * This event removes a visitor's registered event from its collection
	 *
	 * @param Visitor that has to be unregistered to an event
	 * @param Event to remove
	 */
	@Override
	public void unregisterEvent(Visitor visitor, Event event) {
		Visitor visitorFound = entityManager.find(Visitor.class, visitor.getVisitorId());
		visitorFound.getRegisteredEvents().remove(event);
	}
}
