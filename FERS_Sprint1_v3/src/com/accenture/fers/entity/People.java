package com.accenture.fers.entity;

import com.accenture.fers.config.Configuration;
import com.accenture.fers.exceptions.FERSGenericException;
import com.accenture.fers.utils.Restrictions;
import com.accenture.fers.utils.Validator;


/**
 *
 * Accenture Technology Solutions
 *
 *
 * @version v1
 *
 */

public class People {

	// Atributos principales
	private String address;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String dni;

	// Fichero de configuracion
	protected Configuration configuration = null;

	public People() {
		configuration = Configuration.getInstance();
		configuration.loadConfigurationFile("config.properties");
	}

	public People(People people) {
		configuration = Configuration.getInstance();
		configuration.loadConfigurationFile("config.properties");
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if(address != null && Validator.validateLength(address, Restrictions.MIN_ADDRESS, Restrictions.MAX_ADDRESS)){
			this.address = address;
		}else{
			if(address == null){
				this.address = address;
			}else{
				throw new FERSGenericException(configuration.getConfigurationMessage("ERM_017"));
			}
		}

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if(firstName != null && !firstName.equals("")){
			this.firstName = firstName;
		}else{
			throw new FERSGenericException(configuration.getConfigurationMessage("ERM_015"));
		}

	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if(lastName != null && !lastName.equals("")){
			this.lastName = lastName;
		}else{
			throw new FERSGenericException(configuration.getConfigurationMessage("ERM_016"));
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if(email != null && Validator.validateEmail(email)){
			this.email = email;
		}else{
			throw new FERSGenericException(configuration.getConfigurationMessage("ERM_011"));
		}
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		if(phoneNumber != null && Validator.validatePhone(phoneNumber)){
			this.phoneNumber = phoneNumber;
		}else{
			throw new FERSGenericException(configuration.getConfigurationMessage("ERM_010"));
		}

	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		if(dni != null && Validator.validateDni(dni)){
			this.dni = dni;
		}else{
			throw new FERSGenericException(configuration.getConfigurationMessage("ERM_012"));
		}

	}


}
