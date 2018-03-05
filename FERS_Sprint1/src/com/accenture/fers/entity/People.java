package com.accenture.fers.entity;

import com.accenture.fers.exceptions.FERSGenericException;
import com.accenture.fers.utils.Messages;
import com.accenture.fers.utils.Restrictions;
import com.accenture.fers.utils.Validator;


/**
 *
 * @Author Carlos Gonzalez Gonzalez
 * @since 19/02/2018
 * @version v1
 *
 * People class
 *
 */

public class People {

	private String address;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String dni;

	/**
	 * Constructor vacio
	 */
	public People() {

	}

	/**
	 * Constructor de copia
	 * @param people Objeto a copiar
	 */
	public People(People people) {
		if(people != null){
			this.address = people.getAddress();
			this.firstName = people.getFirstName();
			this.lastName = people.getLastName();
			this.email = people.getEmail();
			this.phoneNumber = people.getPhoneNumber();
			this.dni = people.getDni();
		}
	}

	/**
	 * Getter de direccion
	 * @return Direccion
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Setter de la direccion
	 * @param address Nueva direccion
	 */
	public void setAddress(String address) {
		if(address != null && Validator.validateLength(address, Restrictions.MIN_ADDRESS, Restrictions.MAX_ADDRESS)){
			this.address = address;
		}else{
			if(address == null){
				this.address = address;
			}else{
				throw new FERSGenericException(Messages.ERM_017);
			}
		}

	}

	/**
	 * Getter de Nombre
	 * @return Nombre
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Setter de nombre
	 * @param firstName Nuevo nombre
	 */
	public void setFirstName(String firstName) {
		if(firstName != null && !firstName.equals("") &&
				Validator.validateLength(firstName, Restrictions.MIN_FIRSTNAME, Restrictions.MAX_FIRSTNAME)){
			this.firstName = firstName;
		}else{
			throw new FERSGenericException(Messages.ERM_015);
		}

	}

	/**
	 * Getter de apellido
	 * @return Apellido
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Setter de apellido
	 * @param lastName Nuevo apellido
	 */
	public void setLastName(String lastName) {
		if(lastName != null && !lastName.equals("") &&
				Validator.validateLength(lastName, Restrictions.MIN_LASTNAME, Restrictions.MAX_LASTNAME)){
			this.lastName = lastName;
		}else{
			throw new FERSGenericException(Messages.ERM_016);
		}
	}

	/**
	 * Getter de email
	 * @return Email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter de email
	 * @param email Nuevo email
	 */
	public void setEmail(String email) {
		if(email != null && Validator.validateEmail(email)){
			this.email = email;
		}else{
			throw new FERSGenericException(Messages.ERM_011);
		}
	}

	/**
	 * Getter de numero de telefono
	 * @return Numero de telefono
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Setter de numero de telefono
	 * @param phoneNumber Nuevo numero de telefono
	 */
	public void setPhoneNumber(String phoneNumber) {
		if(phoneNumber != null && Validator.validatePhone(phoneNumber)){
			this.phoneNumber = phoneNumber;
		}else{
			throw new FERSGenericException(Messages.ERM_010); // Telefono mal
		}

	}

	/**
	 * Getter de DNI
	 * @return DNI
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Setter de DNI
	 * @param dni Nuevo DNI
	 */
	public void setDni(String dni) {
		if(dni != null && Validator.validateDni(dni)){
			this.dni = dni;
		}else{
			throw new FERSGenericException(Messages.ERM_012); // DNI mal
		}

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		People other = (People) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}


}
