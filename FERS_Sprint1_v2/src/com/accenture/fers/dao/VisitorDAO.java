package com.accenture.fers.dao;

import java.util.ArrayList;
import java.util.List;

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
public class VisitorDAO implements IVisitorDAO{

	private static List<Visitor> visitors = new ArrayList<Visitor>();
	private static int lastID = 1;
	static {
		Visitor visitor = new Visitor();
		visitor.setVisitorId(1);
		visitor.setUserName("angeles");
		visitor.setPassword("aaaaaa");
		visitor.setFirstName("Angeles");
		visitor.setLastName("Gonzalez");
		visitor.setEmail("test@a.com");
		visitor.setDni("11.111.111-H");
		visitor.setPhoneNumber("11111111111");
		visitor.setAddress("asdf");
		visitors.add(visitor);
	}

	public VisitorDAO() {

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
		lastID++;
		visitor.setVisitorId(lastID);
		flag=visitors.add(visitor);
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
		for (Visitor visitor2 : visitors) {
			if (visitor2.getVisitorId() == visitor.getVisitorId()){
				visitor2.setAddress(visitor.getAddress());
				visitor2.setEmail(visitor.getEmail());
				visitor2.setFirstName(visitor.getFirstName());
				visitor2.setLastName(visitor.getLastName());
				visitor2.setPhoneNumber(visitor.getPhoneNumber());
				visitor2.setDni(visitor.getDni());
				visitor2.setPassword(visitor.getPassword());
				visitor2.setRegisteredEvents(visitor.getRegisteredEvents());
				update = 1;
			}
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
		for (Visitor visitorF : visitors) {
			if (visitorF.getUserName().equals(visitor.getUserName())){
				visitorFound = visitorF;
			}
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
		for (Visitor visitor2 : visitors) {
			if (visitor2.getVisitorId() == visitor.getVisitorId()) {
				visitor2.getRegisteredEvents().add(event);
			}
		}

	}

	/**
	 * This event removes a visitor's registered event from its collection
	 *
	 * @param Visitor that has to be unregistered to an event
	 * @param Event to remove
	 */
	@Override
	public void unregisterEvent(Visitor visitor, Event event) {
		for (Visitor visitor2 : visitors) {
			if (visitor2.getVisitorId() == visitor.getVisitorId()) {
				visitor2.getRegisteredEvents().remove(event);
			}
		}
	}

}
