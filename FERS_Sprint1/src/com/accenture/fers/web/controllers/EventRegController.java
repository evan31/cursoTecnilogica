package com.accenture.fers.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.fers.entity.Visitor;
import com.accenture.fers.exceptions.FERSGenericException;
import com.accenture.fers.service.EventFacade;
import com.accenture.fers.service.VisitorFacade;

/**
 * Controlador para a�adir eventos a un usuario
 *
 * @author Carlos Gonzalez Gonzalez
 * @since 27/02/2018
 * @version 1.0
 *
 */
@Controller
@SessionAttributes("usuario")
public class EventRegController implements IController {
	@Autowired
	VisitorFacade visitorService;
	@Autowired
	EventFacade eventService;
	/**
	 * Metodo principal que a�ade el evento
	 *
	 * @param request Peticion
	 * @param response Respuesta
	 * @return view Vista a la que volvemos
	 */
    @Override
    @RequestMapping("/eventReg.do")
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {
    	// Vista a devolver
    	ModelAndView vista = new ModelAndView("WEB-INF/portal.jsp");

        // Obtenemos el id del evento
        int id = Integer.parseInt(request.getParameter("id"));
        // Cogemos al usuario
        Visitor visitor = (Visitor)request.getSession().getAttribute("usuario");

        // A�adimos el evento al visitor
        try{
        	visitorService.registerVisitorToEvent(visitor, id);
        }catch(FERSGenericException fers){
        	request.setAttribute("errorAddEvent", fers.getMessage());
        }

        // Actualizamos los datos de la sesion
        request.getServletContext().setAttribute("eventos", eventService.getAllEvents()); // Eventos
        vista.addObject("usuario",visitor); // Usuario

        return vista;
    }

}
