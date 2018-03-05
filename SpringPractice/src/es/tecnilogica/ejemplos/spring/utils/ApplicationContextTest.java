package es.tecnilogica.ejemplos.spring.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.tecnilogica.ejemplos.spring.entities.Event;
import es.tecnilogica.ejemplos.spring.services.EventFacade;
import es.tecnilogica.ejemplos.spring.services.EventServiceImpl;

public class ApplicationContextTest {

	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("applicationConfigXML.xml");

		EventFacade eventService = (EventServiceImpl)context.getBean("eventService");
		for(Event e : eventService.getAllEvents()){
			System.out.println(e.toString());
		}

	}
}
