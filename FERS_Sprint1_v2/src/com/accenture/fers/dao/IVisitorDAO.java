package com.accenture.fers.dao;


import com.accenture.fers.entity.Event;
import com.accenture.fers.entity.Visitor;
import com.accenture.fers.exceptions.FERSGenericException;
/**
 * VISITORDAO INTERFACE for defining abstract for VISITORDAOIMPLEMENTATION
 *
 * @author Accenture Technology Solutions
 *
 * @version 1.0
 */
public interface IVisitorDAO {
	/**
	 * DAO method to loading visitor details into VISITOR table in database
	 * and validating about existing visitor details.
	 *
	 * @param visitor
	 * @return true(success) /false (fail)
	 * @throws FERSGenericException
	 *
	 */
	boolean insertData(Visitor visitor);

	/**
	 * DAO method to update visitor with additional information
	 *
	 * @param visitor
	 * @return number of rows affected by the query
	 * @throws FERSGenericException
	 */
	int updateVisitor(Visitor visitor);

	/** The searchUser() method searches for a username in database by taking
	 * parameter username . It is used for authenticating a user.
	 * If user exists then the details about the user is populated in a Visitor
	 * object and is returned.
	 * @param visitor (username)
	 * @return  visitor found
	 * @throws FERSGenericException
	 */
	Visitor searchUser(Visitor visitor);

	/**
	 *  DAO method to register visitor for particular events
	 * @param visitor
	 * @param event
	 * @throws FERSGenericException
	 *
	 */
	void registerVisitorToEvent(Visitor visitor, Event event);

	/**
	 *  DAO method to unregister visitor for particular events
	 * @param visitor
	 * @param event
	 * @throws FERSGenericException
	 *
	 */
	void unregisterEvent(Visitor visitor, Event event);

}
