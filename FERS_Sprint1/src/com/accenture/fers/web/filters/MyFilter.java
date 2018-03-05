package com.accenture.fers.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Filtro para evitar que al hacer LogOut y darle para atras pueda realizar acciones
 *
 * @author Carlos Gonzalez Gonzalez
 * @since 27/02/2018
 * @version 1.0
 *
 */
@WebFilter("*.do")
public class MyFilter implements Filter {
    /**
     * Default constructor.
     */
    public MyFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * Filtro para evitar que al hacer LogOut y volver atras en el navegador el usuario pueda realizar ninguna accion
	 * @author Carlos Gonzalez Gonzalez
	 * @since 27/02/2018
	 *
	 * @param request Peticion
	 * @param response Respuesta
	 * @param chain Cadena de filtros
	 *
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// Obtenemos la sesion
		HttpServletRequest servletRequest = (HttpServletRequest)request;
		HttpSession sesion = servletRequest.getSession();

		// Comprobamos si existe un usuario en la sesion
		if(sesion.getAttribute("usuario") == null){
			// Comprobamos que la peticion a filtrar no sea la de index.jsp ni login.do
			if(!servletRequest.getServletPath().equals("/login.do") && !servletRequest.getServletPath().equals("/register.do")){
				RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
				dispatcher.forward(request, response);
			}else{ // Es index.jsp o login.do (avanzamos a portal)
				chain.doFilter(request, response);
			}
		}else{ // Existe un usuario en la sesion (avanzamos a portal)
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
