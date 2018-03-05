package es.tecnilogica.ejemplos.spring.utils;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import es.tecnilogica.ejemplos.spring.entities.Event;
import es.tecnilogica.ejemplos.spring.services.EventFacade;
import es.tecnilogica.ejemplos.spring.services.EventServiceImpl;

public class BeanFactoryTest {

	public static void main(String[] args) {
		ClassPathResource resource = new ClassPathResource("applicationConfigXML.xml");
		BeanFactory factory = new XmlBeanFactory(resource);

		EventFacade eventService = (EventServiceImpl)factory.getBean("eventService");
		for(Event e : eventService.getAllEvents()){
			System.out.println(e.toString());
		}
	}
}
