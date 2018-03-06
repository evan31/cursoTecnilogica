package com.accenture.fers.web.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.accenture.fers.service.EventFacade;
import com.accenture.fers.service.EventService;

/**
 * Listener que carga los eventos en el contexto
 *
 * @author Carlos Gonzalez Gonzalez
 * @since 26/02/2018
 * @version 1.0
 *
 */
@WebListener
public class MyListener implements ServletContextListener {

    /**
     * Default constructor.
     */
    public MyListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  {
         // TODO Auto-generated method stub
    }

	/**
     *
     * Carga los eventos en el contexto
     * @author Carlos Gonzalez Gonzalez
	 * @since 27/02/2018
	 *
	 * @param servlet Contexto del servlet
     *
     *
     */
    public void contextInitialized(ServletContextEvent servlet)  {
    	ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servlet.getServletContext());
    	EventFacade service = (EventFacade)applicationContext.getBean("eventService");
    	servlet.getServletContext().setAttribute("eventos", service.getAllEvents());
    }

}
