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
import com.accenture.fers.service.VisitorFacade;

/**
*
* Controlador que gestiona la actualizacion de la contraseņa de usuario
*
* @author Carlos Gonzalez Gonzalez
* @since 26/02/2018
* @version 1.0
*
*/
@Controller
@SessionAttributes("usuario")
public class UpdateVisitorPasswordController implements IController {
	@Autowired
	VisitorFacade visitorService;
	/**
	 * Mantiene en updateVisitorPassword.jsp si hay error
	 * Manda a index.jsp y actualiza sesion si todo es correcto
	 *
	 * @param request Peticion
	 * @param response Respuesta
	 * @return vista Vista a mostrar
	 *
	 */
	@Override
	@RequestMapping("/updateVisitorPassword.do")
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {
		// Vista a devolver
		ModelAndView vista = null;

		// Obtenemos los datos
		String currentPass = request.getParameter("currentPass");
		String newPass = request.getParameter("newPass");
		String newPassRepeat = request.getParameter("newPassRepeat");

		// Obtenemos la contraseņa con la que se ha logeado el usuario
		HttpSession sesion = request.getSession();
		Visitor visitorSession = (Visitor)sesion.getAttribute("usuario");
		String userPass = visitorSession.getPassword();

		// Comprobamos que la contraseņa actual sea correcta
		if(userPass.equals(currentPass)){
			// Comprobamos que las contraseņas coinciden
			if(newPass.equals(newPassRepeat)){
				// Comprobamos que la contraseņa nueva es distitna a la actual
				if(!newPass.equals(userPass)){
					try{
						visitorSession.setPassword(newPass);
					}catch(FERSGenericException ferException){
						vista = new ModelAndView("WEB-INF/updateVisitorPassword.jsp");
						request.setAttribute("errorUpdatePass", ferException.getMessage());
					}

					// Se crea el visitor correctamente
					if(vista == null){
						// Modificamos la contraseņa
						int modificado = visitorService.changePassword(visitorSession);
						// Cambiamos la pagina de respuesta
						if(modificado > 0){
							vista = new ModelAndView("index.jsp");
							vista.addObject("usuario",visitorSession);
							request.removeAttribute("errorUpdatePass");
						}else{
							vista = new ModelAndView("WEB-INF/updateVisitorPassword.jsp");
							request.setAttribute("errorUpdatePass", "No se ha podido cambiar la contraseņa");
						}
					}
				}else{
					vista = new ModelAndView("WEB-INF/updateVisitorPassword.jsp");
					request.setAttribute("errorUpdatePass", "La nueva contraseņa no puede ser igual a la anterior");
				}
			}else{
				vista = new ModelAndView("WEB-INF/updateVisitorPassword.jsp");
				request.setAttribute("errorUpdatePass", "La contraseņa nueva no coincide");
			}
		}else{
			vista = new ModelAndView("WEB-INF/updateVisitorPassword.jsp");
			request.setAttribute("errorUpdatePass", "La contraseņa actual no es correcta");
		}


		return vista;
	}

}
