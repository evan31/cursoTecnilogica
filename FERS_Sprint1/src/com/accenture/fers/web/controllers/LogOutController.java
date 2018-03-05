package com.accenture.fers.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
* Controlador que gestiona el logout
*
* @author Carlos Gonzalez Gonzalez
* @since 26/02/2018
* @version 1.0
*
*/
@Controller
public class LogOutController implements IController {
	/**
	 * Manda a index.jsp y borra sesion
	 *
	 * @param request Peticion
	 * @param response Respuesta
	 * @return vista Vista a mostrar
	 *
	 */
	@Override
	@RequestMapping("/logOut.do")
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {
		// Nos cargamos la sesion
		request.getSession().invalidate();
		// Retornamos a la pagina de inicio
		return new ModelAndView("index.jsp");
	}

}
