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
import com.accenture.fers.service.VisitorFacade;

/**
*
* Controlador que gestiona el login
*
* @author Carlos Gonzalez Gonzalez
* @since 26/02/2018
* @version 1.0
*
*/
@Controller
@SessionAttributes("usuario")
public class LoginController implements IController {
	@Autowired
	VisitorFacade visitorService;
	/**
	 * Mantiene en login.jsp si hay error
	 * Manda a portal.jsp y crea sesion si todo es correcto
	 *
	 * @param request Peticion
	 * @param response Respuesta
	 * @return vista Vista a mostrar
	 *
	 */
	@Override
	@RequestMapping("/login.do")
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {
		// Declaramos el ModelAndView a devolver
		ModelAndView vista = null;

		// Obtenemos los datos
		String user = request.getParameter("visitorName");
		String pass = request.getParameter("passLogin");

		// Creamos el visitor
		Visitor visitor = null;
		try{
			visitor = new Visitor();
			visitor.setUserName(user);
			visitor.setPassword(pass);
		}catch(FERSGenericException ferException){
			vista = new ModelAndView("index.jsp");
			request.setAttribute("errorLogin", ferException.getMessage());
		}

		// Se crea el visitor correctamente
		if(vista == null){
			// Buscamos visitor por nombre y pass
			//VisitorFacade visitorService = (VisitorService)context.getBean("visitorService");
			try{
				Visitor visitorFound = visitorService.searchUser(visitor);

				// Cambiamos pagina de respuesta
				if(visitorFound != null){ // visitor encontrado
					vista = new ModelAndView("WEB-INF/portal.jsp");
					request.removeAttribute("errorLogin");
					// Añadimos el visitor a la sesion
					vista.addObject("usuario",visitorFound);
				}else{ // visitor no encontrado
					vista = new ModelAndView("index.jsp");
					request.setAttribute("errorLogin","No se encuentra el usuario");
				}
			}catch(FERSGenericException ferException){
				vista = new ModelAndView("index.jsp");
				request.setAttribute("errorLogin", ferException.getMessage());
			}
		}

		return vista;
	}

}
