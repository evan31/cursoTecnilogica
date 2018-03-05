package com.accenture.fers.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Carlos Gonzalez Gonzalez
 * @since 26/02/2018
 * @version 1.0
 *
 */
public interface IController {

	/**
	 * Metodo que procesa la peticion y muestra una pantalla u otra
	 *
	 * @param request Peticion
	 * @param response Respuesta
	 * @return Vista a mostrar
	 */
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response);
}
