package com.accenture.fers.utils;



/**
 * This class validates data introduced by the user
 *
 * @author Carlos Gonzalez Gonzalez
 * @since 13/02/2018
 * @version 1.0
 */

public class Validator {
	private final static String[] LISTA_LETRAS = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D",  "X",  "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E" };

	/**
	 * Valida la longitud
	 *
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
	 * Valida el numero de telefono
	 *
	 * @author Carlos Gonzalez Gonzalez
	 * @param phoneString Phone number
	 * @return Phone validation
	 */
	public static boolean validatePhone(String phoneString){
		boolean valido = true;
		// Validamos la longitud del telefono
		if(!validateLength(phoneString, Restrictions.MIN_PHONE, Restrictions.MAX_PHONE)){
			valido = false;
		}else{
			// Comprobamos que no tenga espacios al principio ni al final
			if(phoneString.indexOf(" ") == 0 || phoneString.indexOf(" ") == phoneString.length()-1){
				valido = false;
			}else{
				// Quitamos espacios
				String phoneNoSpaces = phoneString.replace(" ", "");

				// Averiguamos si es un numero internacional
				if(phoneNoSpaces.indexOf("+") == -1){ // No es un numero internacional
					for(int i = 0;i < phoneNoSpaces.length() && valido;i++){
						if(!Character.isDigit(phoneNoSpaces.charAt(i))){
							valido = false;
						}
					}
				}else{ // Es un numero internacional
					// Le pasamos al validador el numero sin el caracter '+'
					String phoneAux = phoneNoSpaces.substring(1, phoneNoSpaces.length());
					for(int i = 0;i < phoneAux.length() && valido;i++){
						if(!Character.isDigit(phoneAux.charAt(i))){
							valido = false;
						}
					}
				}
			}
		}

		return valido;
	}

	/**
	 * Valida el DNI
	 *
	 * @author Carlos Gonzalez Gonzalez
	 * @param dni Field with dni value
	 * @return DNI validation
	 */
	public static boolean validateDni(String dni){
		boolean valido = true;

		/* Partimos el dni en dos para separar la parte numerica de la letra
			[0] -> numero con puntos
			[1] -> letra
		*/
		String[] dniAux = dni.split("-");

		// Validamos la longitud del DNI
		if(!validateLength(dni, Restrictions.MIN_DNI, Restrictions.MAX_DNI)){
			valido = false;
		}else{
			// Comprobamos que los puntos esten donde deben
			for(int i = 0;i < dni.length() && valido ;i++){
				if(dni.charAt(i) == '.'){ // El caracter es un punto
					if(i != 2 && i!= 6){ // El punto no esta donde debe
						valido = false;
					}
				}
			}

			// Continuamos validando solo si la validacion de los puntos es correcta
			if(valido){
				// Validamos que haya un guion alto
				if(dni.charAt(dni.length()-2) != '-'){
					valido = false;
				}else{
					// Validamos el contenido que hay antes del guion y la letra
					/* Separamos las secciones divididas por los puntos.
					   Formato correcto:
						[0] --> xx
						[1] --> xxx
						[2] --> xxx
					*/
					String[] numSplitted = dniAux[0].split("\\.");
					/* 1. Comprobamos que antes del primer punto hay dos digitos,
					  que entre el primero y el segundo hay tres y
					  despues del segundo otros tres*/
					if(numSplitted[0].length() != 2 || numSplitted[1].length() != 3 || numSplitted[2].length() != 3){
						valido = false;
					}else{
						// 2. Validamos que se un numero
						if(!validateNumberOnly(dniAux[0].replaceAll("\\.", ""))){
							valido = false;
						}
					}
					// FIN VALIDACION PARTE NUMERICA

					if(valido){
						// Validamos la letra
						// Obtenemos el numero
						int numDni = Integer.parseInt(dniAux[0].replaceAll("\\.", ""));
						// Comprobamos que la letra es correcta
						if(!LISTA_LETRAS[numDni%23].equals(dniAux[1])){
							valido = false;
						}
						// FIN VALIDACION LETRA
					}

				}
			}
		}

		return valido;
	}

	/**
	 * Valida el Email
	 *
	 * @author Carlos Gonzalez Gonzalez
	 * @param email Field with email value
	 * @return Email validation
	 */
	public static boolean validateEmail(String email){
		boolean valido = true;

		// Validamos la longitud
		if(!validateLength(email, Restrictions.MIN_EMAIL, Restrictions.MAX_EMAIL)){
			valido = false;
		}else{
			// Validamos que solo tenga una @
			int contador = 0;
			for(int i = 0;i < email.length() && contador<2;i++){
				if(email.charAt(i) == (char)64){ // 64 es @ en ascii
					contador++;
				}
				if(contador == 2){
					valido = false;
				}
			}
			// comprobamos que tenga local y dominio
			String[] emailSplitted = email.split("" + ((char)64));
			if(emailSplitted.length != 2){
				valido = false;
			}else{
				String local = emailSplitted[0];
				String domain = emailSplitted[1];

				if(local.equals("") || domain.equals("")){
					valido = false;
				}else{
					if(local.charAt(local.length()-1) == '.'){
						valido = false;
					}else{
						// Comprobamos que la seccion local no contenga ()[]\;:,<> o espacio
						// Array con los caracteres especiales
						char[] caracteresEspeciales = {(char)40,(char)41,(char)91,(char)93,(char)92,(char)59,(char)58,(char)44,(char)60,(char)62,(char)32};
						for(int i = 0; i < local.length() && valido;i++){
							for(char c : caracteresEspeciales){
								if(local.charAt(i) == c){
									valido = false;
								}
							}
						}
					}
				}
			}
		}

		return valido;
	}

	/**
	 * Valida que la cadena no tenga texto
	 *
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
