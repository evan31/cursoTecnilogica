package com.accenture.fers.service;

import java.util.Set;

import com.accenture.fers.entity.Event;
import com.accenture.fers.entity.Visitor;
import com.accenture.fers.exceptions.FERSGenericException;

/**
 * VISITORFACADE INTERFACE for defining abstract for VISITORSERVICEIMPLEMENTATION
 *
 * @author Accenture Technology Solutions
 *
* @version 1.0
 */
public interface VisitorFacade {
	/**
	 * This service creates a new Visitor
	 * if the visitor already exists returns false
	 * else it creates the visitor and returns true
	 * @param visitor
	 * @return boolean
	 * @throws FERSGenericException
	 */
	public boolean createVisitor(Visitor visitor);

	/**
	 * This method search a Visitor by username and
	 * test if the new password is correct
	 * @param visitor (username)
	 * @return visitor found
	 * @throws FERSGenericException
	 */
	public Visitor searchUser(Visitor visitor);

	/**
	 * This service register a Visitor to an event:
	 * if the visitor is already registered or the event doesn't have any available seat its throws a ServiceException
	 * the method  increases the number of available seats of the event after the register
	 * @param visitor
	 * @param event id
	 * @return
	 * @throws FERSGenericException
	 */
	public void registerVisitorToEvent(Visitor visitor, int eventid);
	/**
	 * This method gets the list of registered events for the visitor
	 * @param visitor
	 * @return
	 * @throws FERSGenericException
	 */
	public Set<Event> showRegisteredEvents(Visitor visitor);

	/**
	 * This service updates the visitor information
	 * @param visitor
	 * @return  1 if the visitor was updated/0 otherwise
	 * @throws  FERSGenericException
	 */
	public int updateVisitorDetails(Visitor visitor);

	/**
	 * This service updates the visitor password
	 * @param visitor
	 * @return  1 if the visitor was updated/0 otherwise
	 * @throws  FERSGenericException
	 */
	public int changePassword(Visitor visitor);
	/**
	 * This service unregister a Visitor to an event and increases the number of available seats of the event
	 * @param visitor
	 * @param event id
	 * @return
	 * @throws FERSGenericException
	 */
	public void unregisterVisitorToEvent(Visitor visitor, int eventid);
	/**
	 * This method check if exits a visitor with the username provided
	 * @param visitor (username)
	 * @return visitor found
	 * @throws FERSGenericException
	 */
	public boolean searchUserName(String userName);
}
