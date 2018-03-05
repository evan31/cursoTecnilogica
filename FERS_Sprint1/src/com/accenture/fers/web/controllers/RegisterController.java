package com.accenture.fers.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.fers.entity.Visitor;
import com.accenture.fers.exceptions.FERSGenericException;
import com.accenture.fers.service.VisitorFacade;

/**
*
* Controlador que gestiona el registro de usuarios
*
* @author Carlos Gonzalez Gonzalez
* @since 26/02/2018
* @version 1.0
*
*/
@Controller
public class RegisterController implements IController {
	@Autowired
	private VisitorFacade visitorService;
	/**
	 * Mantiene en register.jsp si hay error
	 * Manda a index.jsp si todo es correcto
	 *
	 * @author Carlos Gonzalez Gonzalez
	 * @since 26/02/2018
	 *
	 */
	@Override
	@RequestMapping("/register.do")
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {
		// Pagina a devolver
		ModelAndView vista = null;

		// Averiguamos si la contraseña coincide
		String pass = request.getParameter("passRegister");
		String passConfirm = request.getParameter("passConfirmRegister");

		if(pass.equals(passConfirm)){ // La contraseña coincide
			// Creamos un visitor
			Visitor visitor = new Visitor();
			try{
				visitor.setFirstName(request.getParameter("firstNameRegister"));
				visitor.setLastName(request.getParameter("lastNameRegister"));
				visitor.setUserName(request.getParameter("userNameRegister"));
				visitor.setPassword(pass);
				visitor.setDni(request.getParameter("dniRegister"));
				visitor.setAddress(request.getParameter("addressRegister"));
				visitor.setEmail(request.getParameter("emailRegister"));
				visitor.setPhoneNumber(request.getParameter("phoneRegister"));
			}catch(FERSGenericException fersException){
				vista = new ModelAndView("register.jsp");
				request.setAttribute("errorRegistro", fersException.getMessage());
			}

			// Se ha creado el visitor correctamente
			if(vista == null){
				// Usamos el servicio para persistir un visitor
				//VisitorFacade visitorService = (VisitorService)context.getBean("visitorService");
				boolean creado = visitorService.createVisitor(visitor);

				// Cambiamos la vista
				if(creado){ // visitor creado
					vista = new ModelAndView("index.jsp");
					request.removeAttribute("errorRegistro");
				}else{ // visitor no creado
					vista = new ModelAndView("register.jsp");
					request.setAttribute("errorRegistro", "Ya existe ese usuario");
				}
			}

		}else{ // La contraseña no coincide
			vista = new ModelAndView("register.jsp");
			request.setAttribute("errorRegistro", "Las contraseñas no coinciden");
		}

		return vista;
	}
}
