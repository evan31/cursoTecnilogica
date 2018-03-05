package com.accenture.fers.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
*
* Controlador que gestiona a que pagina de WEB-INF redirecciona
*
* @author Carlos Gonzalez Gonzalez
* @since 26/02/2018
* @version 1.0
*
*/
@Controller
public class DisplayViewController implements IController {
	/**
	 * Redirecciona a la pagina correspondiente dentro de WEB-INF
	 *
	 * @author Carlos Gonzalez Gonzalez
	 * @since 26/02/2018
	 *
	 */
	@Override
	@RequestMapping("/displayView.do")
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {
		// Vista a redireccionar
		ModelAndView vista = null;
		// Obtenemos el atributo
		String view = request.getParameter("view");

		switch(view){
		case "updateInfo":
			vista = new ModelAndView("WEB-INF/updateVisitorInformation.jsp");
			break;
		case "updatePass":
			vista = new ModelAndView("WEB-INF/updateVisitorPassword.jsp");
			break;
		case "portal":
			vista = new ModelAndView("WEB-INF/portal.jsp");
			break;
		}

		return vista;
	}

}
