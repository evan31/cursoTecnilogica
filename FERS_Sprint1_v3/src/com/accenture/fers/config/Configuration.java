package com.accenture.fers.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * Esta clase se encarga de comunicar a la aplicacion principal
 * con el fichero de configuracion, que contiene los mensajes
 *
 * @author Carlos Gonzalez Gonzalez
 * @since 14/02/2018
 * @version 1.0
 *
 */
public class Configuration {
	// Instancia de Singleton
	private static Configuration configuration;

	// Atributos
	Properties prop = null;
	InputStream input = null;

	// Constructor
	public Configuration(){
		prop = new Properties();
	}

	// Patron Singleton
	public static Configuration getInstance(){
		if(configuration == null){
			configuration = new Configuration();
		}
		return configuration;
	}

	/**
	 * Carga el fichero de configuracion y controla la excepcion
	 *
	 * @param configurationFile Nombre del fichero
	 * @author Carlos Gonzalez Gonzalez
	 */
	public void loadConfigurationFile(String configurationFile){
		try{
			// Ruta del fichero
			String path = new File("").getAbsolutePath() + "/src/com/accenture/fers/config/" + configurationFile;
			// Creamos el fichero de entrada
			input = new FileInputStream(path);
			// Cargamos el properties
			prop.load(input);
		}catch(FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}

	/**
	 * Devuelve un mensaje segun el id que se le pase
	 *
	 * @author Carlos Gonzalez Gonzalez
	 * @param messageId Id del mensaje
	 * @return Mensaje segun el id introducido
	 */
	public String getConfigurationMessage(String messageId){
		return prop.getProperty(messageId);
	}
}
