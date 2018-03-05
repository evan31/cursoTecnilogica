package com.accenture.fers.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * This class validates data introduced by the user
 *
 * @author Carlos Gonzalez Gonzalez
 * @since 13/02/2018
 * @version 2.0
 */

public class Validator {
	// Constante con las letras del DNI
	private final static String[] LISTA_LETRAS = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D",  "X",  "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E" };

	/**
	 * @author Carlos Gonzalez Gonzalez
	 * @param field String to validate
	 * @param minValue Minimum length
	 * @param maxValue Maximum length
	 * @return length validation between max and min
	 */
	public static boolean validateLength(String field,int minValue,int maxValue){
		boolean valido = false;
		// Comprobamos que esta en el rango adecuado
		if(field.length() >= minValue && field.length() <= maxValue){
			valido = true;// Esta en el rango adecuado
		}
		return valido; // No esta en el rango adecuado
	}

	/**
	 * @author Carlos Gonzalez Gonzalez
	 * @param phoneString Phone number
	 * @return Phone validation
	 */
	public static boolean validatePhone(String phoneString){
		boolean valido = true;

		// Variables de expresiones regulares
		// Patron numero normal
		Pattern normalNumberPattern = Pattern.compile("^[0-9]+$");
		Matcher normalNumberMatcher = normalNumberPattern.matcher(phoneString);
		// Patron numero internacional
		Pattern internacionalNumberPattern = Pattern.compile("(^\\+[0-9]{2})[0-9]+$");
		Matcher internacionalNumberMatcher = internacionalNumberPattern.matcher(phoneString);

		// Validamos la longitud del telefono
		if(!validateLength(phoneString, Restrictions.MIN_PHONE, Restrictions.MAX_PHONE)){
			valido = false;
		}else{
			// Comprobamos que el telefono es correcto
			if(!normalNumberMatcher.find()){ // Numero normal
				if(!internacionalNumberMatcher.find()){ // Numero internacional valido
					valido = false;
				}
			}
		}

		return valido;
	}

	/**
	 * @author Carlos Gonzalez Gonzalez
	 * @param dni Field with dni value
	 * @return DNI validation
	 */
	public static boolean validateDni(String dni){
		boolean valido = true;

		// Expresiones regulares
		Pattern dniPattern = Pattern.compile("^([0-9]{2})\\.([0-9]{3})\\.([0-9]{3})-[A-Z]");
		Matcher dniMatcher = dniPattern.matcher(dni);

		if(!dniMatcher.find()){ // Numero internacional valido
			valido = false;
		}else{
			/*
			 * [0] -> numero del DNI
			 * [1] -> letra del DNI
			 */
			String[] dniAux = dni.split("-");
			// Quitamos los puntos de la parte numerica
			int numDni = Integer.parseInt(dniAux[0].replaceAll("\\.", ""));

			// Comprobamos que la letra es correcta
			if(!LISTA_LETRAS[numDni%23].equals(dniAux[1])){
				valido = false;
			}
		}
		return valido;
	}

	/**
	 * @author Carlos Gonzalez Gonzalez
	 * @param email Field with email value
	 * @return Email validation
	 */
	public static boolean validateEmail(String email){
		boolean valido = true;

		// Expresiones regulares
		// Seccion local tiene al menos un caracter, admite ._- seguido de caracter alfanumerico
		String patronLocal = "^([a-zA-Z]*([0-9]*[a-zA-Z]+))+((\\.|\\-|\\_)[a-zA-Z0-9]+)*";
		// Seccion dominio tiene una unica @, al menos un caracter, un unico punto y una extension entre 2 y 3 caracteres
		String patronDomain = "@[a-zA-Z0-9]+\\.[a-zA-Z]{2,3}$";
		// Patron
		Pattern emailPattern = Pattern.compile(patronLocal + patronDomain);
		Matcher emailMatcher = emailPattern.matcher(email);

		// Validamos la longitud
		if(!validateLength(email, Restrictions.MIN_EMAIL, Restrictions.MAX_EMAIL)){
			valido = false;
		}else{
			if(!emailMatcher.find()){
				valido = false;
			}
		}

		return valido;
	}

	/**
	 * @author Carlos Gonzalez Gonzalez
	 * @param fieldString String to validate
	 * @return Number validation
	 */
	public static boolean validateNumberOnly(String fieldString){
		boolean valido = true;
		// Eliminamos espacios
		fieldString = fieldString.replace(" ", "");
		// Hacemos parseo a Long por la cantidad de digitos y capturamos la excepcion
		try{
			Long.parseLong(fieldString);
		}catch(NumberFormatException nfe){
			valido = false; // No es un numero
		}
		return valido; // Es un numero
	}
}
