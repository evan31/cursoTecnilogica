package es.tecnilogica.ejemplos.spring.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.tecnilogica.ejemplos.spring.entities.Event;
import es.tecnilogica.ejemplos.spring.services.EventFacade;
import es.tecnilogica.ejemplos.spring.services.EventServiceImpl;

@Controller
@SessionAttributes("eventos")
public class MostrarEventosController {
	private EventFacade eventService;

	@RequestMapping(value="/mostrarEvents.do")
	public ModelAndView process(HttpServletRequest request,HttpServletResponse response){
		// Creamos el contexto
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationConfig.xml");
		// Creamos instancia ModelAndView
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/VisualizaEventos.jsp");
		// Obtenemos los eventos
		EventFacade eventService = (EventServiceImpl)context.getBean("eventServiceImpl");
		List<Event> eventos = eventService.getAllEvents();
		// Guardamos los eventos en modelAndView
		modelAndView.addObject("eventos", eventos);

		return modelAndView;
	}

	/**
	 * @return the eventService
	 */
	public EventFacade getEventService() {
		return eventService;
	}

	/**
	 * @param eventService the eventService to set
	 */
	public void setEventService(EventFacade eventService) {
		this.eventService = eventService;
	}


}
