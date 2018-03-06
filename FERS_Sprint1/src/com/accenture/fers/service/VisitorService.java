package com.accenture.fers.service;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.accenture.fers.dao.IEventDAO;
import com.accenture.fers.dao.IVisitorDAO;
import com.accenture.fers.entity.Event;
import com.accenture.fers.entity.Visitor;
import com.accenture.fers.exceptions.FERSGenericException;

/**
 *
 * VisitorService Implementation
 *
 * @author Accenture Technology Solutions
 *
 * @version 1.0
 */
@EnableTransactionManagement
@Service("visitorService")
public class VisitorService implements VisitorFacade {
	@Autowired
	private IVisitorDAO visitorDAO;
	@Autowired
	private IEventDAO eventDAO;

	/**
	 * This service creates a new Visitor if the visitor already exists returns
	 * false else it creates the visitor and returns true
	 *
	 * @param visitor to create
	 * @return boolean that informs if operation was succeed
	 */
	@Override
	@Transactional
	public boolean createVisitor(Visitor visitor) {
		boolean flag = false;
		// if there is not a visitor with the same username
		if (visitorDAO.searchUser(visitor) == null) {
			// create a new visitor entry
			flag = visitorDAO.insertData(visitor);

		}
		return flag;
	}

	/**
	 * This method search a Visitor by username and test if the new password is
	 * correct
	 *
	 * @param visitor (username)
	 * @return visitor found
	 */
	@Override
	@Transactional
	public Visitor searchUser(Visitor visitor) {
		// Search visitor by username
		Visitor visitorFound = visitorDAO.searchUser(visitor);

		// if visitor found check passwords
		if (visitorFound != null) {
			if (!visitorFound.getPassword().equals(visitor.getPassword())) {
				// Throw exception
				throw new FERSGenericException("Invalid username/password");
			}

		}
		return visitorFound;
	}

	/**
	 * This service register a Visitor to an event: if the visitor is already
	 * registered or the event doesn't have any available seat its throws a
	 * FERSGenericException. The method increases the number of available seats of
	 * the event after the register
	 *
	 * @param visitor to register to an event
	 * @param eventid of the event to register
	 */
	@Override
	@Transactional
	public void registerVisitorToEvent(Visitor visitor, int eventid) {
		// Get event by id
		Event event = eventDAO.getEvent(eventid);
		// if available seats
		if (event.getSeatsAvailable() > 0) {
			boolean registrado = false;

			// check if the visitor is registered to the event
			Set<Event> eventsRegistered = visitor.getRegisteredEvents();
			if (eventsRegistered != null) {
				for (Event eventVisitor : eventsRegistered) {
					if (eventVisitor.getEventId() == eventid) {
						registrado = true;
					}
				}
			}
			// if visitor is not registered
			if (!registrado) {
				int actual = event.getSeatsAvailable();
				event.setSeatsAvailable(actual - 1);

				// register visitor to event
				visitorDAO.registerVisitorToEvent(visitor, event);

				//update event's seats
				eventDAO.updateEvent(event);
			} else {
				// Throw exception
				throw new FERSGenericException(
						"User already Registered for the EVENT!");
			}
		} else {
			// Throw exception
			throw new FERSGenericException("No available seats");
		}

	}

	/**
	 * This method gets the list of registered events for the visitor
	 *
	 * @param visitor
	 * @return a list of events
	 */
	@Override
	@Transactional
	public Set<Event> showRegisteredEvents(Visitor visitor) {
		// return registered events
		return visitor.getRegisteredEvents();
	}

	/**
	 * This service updates the visitor information
	 *
	 * @param visitor
	 * @return 1 if the visitor was updated/0 otherwise
	 * @throws FERSGenericException
	 */
	@Override
	@Transactional
	public int updateVisitorDetails(Visitor visitor) {
		// update visitor details
		return visitorDAO.updateVisitor(visitor);
	}

	/**
	 * This service updates the visitor password
	 *
	 * @param visitor
	 * @return 1 if the visitor was updated/0 otherwise
	 */
	@Override
	@Transactional
	public int changePassword(Visitor visitor) {
		// update password
		return visitorDAO.updateVisitor(visitor);
	}

	/**
	 * This service unregister a Visitor to an event and increases the number of
	 * available seats of the event
	 *
	 * @param visitor to unregister to the event
	 * @param eventid of the event that is going to be unregistered
	 */
	@Override
	@Transactional
	public void unregisterVisitorToEvent(Visitor visitor, int eventid) {
		// get event by id
		Event event = eventDAO.getEvent(eventid);

		// unregister event
		visitorDAO.unregisterEvent(visitor, event);

		// increase event available seats
		int actual = event.getSeatsAvailable();
		event.setSeatsAvailable(actual + 1);
		eventDAO.updateEvent(event);
	}

	/**
	 * This method check if exits a visitor with the username provided
	 *
	 * @param visitor (username)
	 * @return visitor found
	 */
	@Override
	@Transactional
	public boolean searchUserName(String userName) {
		boolean success = false;
		Visitor visitor = new Visitor();
		visitor.setUserName(userName);
		// find visitor by username
		if (visitorDAO.searchUser(visitor) != null) {
			success = true;
		}
		return success;
	}

}
