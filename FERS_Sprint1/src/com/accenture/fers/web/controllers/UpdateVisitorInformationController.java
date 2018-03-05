package com.accenture.fers.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.fers.entity.Visitor;
import com.accenture.fers.exceptions.FERSGenericException;
import com.accenture.fers.service.VisitorService;

/**
* Controlador que gestiona la actualizacion de detalles de usuario
*
* @author Carlos Gonzalez Gonzalez
* @since 26/02/2018
* @version 1.0
*
*/
@Controller
@SessionAttributes("usuario")
public class UpdateVisitorInformationController implements IController {
	@Autowired
	VisitorService visitorService;

	/**
	 * Mantiene en updateVisitorInformation.jsp si hay error
	 * Manda a portal.jsp y actualiza sesion si todo es correcto
	 *
	 * @param request Peticion
	 * @param response Respuesta
	 * @return vista Vista a mostrar
	 *
	 */
	@Override
	@RequestMapping("/updateVisitorInformation.do")
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {
		// Pagina a devolver
		//String vista = "";
		ModelAndView vista = null;

		// Cogemos el visitor de la sesion
		HttpSession sesion = request.getSession();
		Visitor visitorSesion =  (Visitor)sesion.getAttribute("usuario");
		try{
			visitorSesion.setFirstName(request.getParameter("firstNameUpdate"));
			visitorSesion.setLastName(request.getParameter("lastNameUpdate"));
			visitorSesion.setUserName(request.getParameter("userNameUpdate"));
			visitorSesion.setDni(request.getParameter("dniUpdate"));
			visitorSesion.setAddress(request.getParameter("addressUpdate"));
			visitorSesion.setEmail(request.getParameter("emailUpdate"));
			visitorSesion.setPhoneNumber(request.getParameter("phoneUpdate"));
		}catch(FERSGenericException fersException){
			vista = new ModelAndView("WEB-INF/updateVisitorInformation.jsp");
			request.setAttribute("errorUpdateVisitor", fersException.getMessage());
		}

		// Se ha creado el visitor correctamente
		if(vista == null){
			// Usamos el servicio para persistir un visitor
			int modificado = visitorService.updateVisitorDetails(visitorSesion);

			// Cambiamos la vista
			if(modificado > 0){ // visitor modificado
				vista = new ModelAndView("WEB-INF/portal.jsp");
				//sesion.setAttribute("usuario", visitorSesion);
				vista.addObject("usuario",visitorSesion);
				request.removeAttribute("errorUpdateVisitor");
			}else{ // visitor no modificado
				vista = new ModelAndView("WEB-INF/updateVisitorInformation.jsp");
				request.setAttribute("errorUpdateVisitor", "No se ha podido modificar el usuario");
			}
		}

		return vista;
	}

}
