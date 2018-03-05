package com.accenture.fers.entity;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.accenture.fers.utils.Messages;

public class VisitorTest {

	Visitor visitor = new Visitor();
	Set<Event> eventos = new HashSet<Event>();

	@Before
	public void setUp() throws Exception {
		// Cargamos visitor
		visitor.setVisitorId(1);
		visitor.setAddress("Calle Falsa 123");
		visitor.setDni("11.111.111-H");
		visitor.setEmail("a@a");
		visitor.setFirstName("Carlos");
		visitor.setLastName("Gonzalez");
		visitor.setPassword("pass123");
		visitor.setPhoneNumber("1111111111");
		visitor.setUserName("CarlosGG");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testVisitorVisitorPositive() {
		Visitor v2 = new Visitor(visitor);
		assertEquals(v2, visitor);
	}

	@Test
	public void testVisitorVisitorNegative() {
		Consumer<Visitor> consumer = dato -> new Visitor(dato);

		assertFail(consumer, null, Messages.ERM_VACIO);
	}

	@Test
	public void testGetUserName() {
		assertEquals("CarlosGG", visitor.getUserName());
	}

	@Test
	public void testSetUserNamePositive() {
		// Caso length = min
		visitor.setUserName(cadenaString("a", 6));
		// Caso length = max
		visitor.setUserName(cadenaString("a", 12));
	}

	@Test
	public void testSetUserNameNegative() {
		Consumer<String> consumer = dato -> visitor.setUserName(dato);
		// Caso null
		assertFail(consumer,null,Messages.ERM_013);
		// Caso length < min
		assertFail(consumer, "a" , Messages.ERM_013);
		// Caso length > max
		assertFail(consumer, cadenaString("a", 13), Messages.ERM_013);
	}

	@Test
	public void testGetPassword() {
		assertEquals("pass123", visitor.getPassword());
	}

	@Test
	public void testSetPasswordPositive() {
		// Caso length = min
		visitor.setPassword(cadenaString("a", 6));
		assertEquals(cadenaString("a", 6), visitor.getPassword());
		// Caso length = max
		visitor.setPassword(cadenaString("a", 15));
		assertEquals(cadenaString("a", 15), visitor.getPassword());
	}

	@Test
	public void testSetPasswordNegative() {
		Consumer<String> consumer = dato -> visitor.setPassword(dato);

		// Caso null
		assertFail(consumer, null, Messages.ERM_014);
		// Caso length < min
		assertFail(consumer, cadenaString("a", 5), Messages.ERM_014);
		// Caso length > max
		assertFail(consumer, cadenaString("a", 16), Messages.ERM_014);
	}

	@Test
	public void testGetAddress() {
		assertEquals("Calle Falsa 123", visitor.getAddress());
	}

	@Test
	public void testSetAddressPositive() {
		// Caso null
		visitor.setAddress(null);
		assertEquals(null, visitor.getAddress());
		// Caso length = min
		visitor.setAddress("");
		assertEquals("", visitor.getAddress());
		// Caso length = max
		visitor.setAddress(cadenaString("a", 30));
		assertEquals(cadenaString("a", 30), visitor.getAddress());
	}

	@Test
	public void testSetAddressNegative() {
		Consumer<String> consumer = dato -> visitor.setAddress(dato);

		// Caso length > max
		assertFail(consumer,cadenaString("a", 31),Messages.ERM_017);
	}

	@Test
	public void testGetFirstName() {
		assertEquals("Carlos", visitor.getFirstName());
	}

	@Test
	public void testSetFirstNamePositive() {
		// Caso length = min
		visitor.setFirstName("a");
		assertEquals("a", visitor.getFirstName());
		// Caso length = max
		visitor.setFirstName(cadenaString("a", 30));
		assertEquals(cadenaString("a", 30), visitor.getFirstName());
	}

	@Test
	public void testSetFirstNameNegative() {
		Consumer<String> consumer = dato -> visitor.setFirstName(dato);

		// Caso length = null
		assertFail(consumer, null, Messages.ERM_015);
		// Caso length < min
		assertFail(consumer, "", Messages.ERM_015);
		// Caso length > max
		assertFail(consumer, cadenaString("a", 31), Messages.ERM_015);
	}

	@Test
	public void testGetLastName() {
		assertEquals("Gonzalez", visitor.getLastName());
	}

	@Test
	public void testSetLastNamePositive() {
		// Caso length = min
		visitor.setLastName("a");
		assertEquals("a", visitor.getLastName());
		// Caso length = max
		visitor.setLastName(cadenaString("a", 30));
		assertEquals(cadenaString("a", 30), visitor.getLastName());
	}

	@Test
	public void testSetLastNameNegative() {
		Consumer<String> consumer = dato -> visitor.setLastName(dato);

		// Caso length = null
		assertFail(consumer, null, Messages.ERM_016);
		// Caso length < min
		assertFail(consumer, "", Messages.ERM_016);
		// Caso length > max
		assertFail(consumer, cadenaString("a", 31), Messages.ERM_016);
	}

	@Test
	public void testGetEmail() {
		assertEquals("a@a", visitor.getEmail());
	}

	@Test
	public void testSetEmailPositive() {
		/* Caso (right length) + (right nº @) + (local not end .) +
		(local no special char) + (local +0 chars) + (domain +0 chars)*/
		visitor.setEmail("test@test.com");
		assertEquals("test@test.com", visitor.getEmail());
	}

	@Test
	public void testSetEmailNegative() {
		Consumer<String> consumer = dato -> visitor.setEmail(dato);

		// Caso null
		assertFail(consumer, null, Messages.ERM_011);
		// Caso length < min
		assertFail(consumer, "", Messages.ERM_011);
		// Caso length > max
		assertFail(consumer, cadenaString("a", 201), Messages.ERM_011);
		// Caso (rigth length) + (@@)
		assertFail(consumer, "test@@test.com", Messages.ERM_011);
		// Caso (rigth length) + (rigth nº @) + (local end .)
		assertFail(consumer, "test.@test.com", Messages.ERM_011);
		// Caso (rigth length) + (rigth nº @) + (local not end .) + (local special char)
		assertFail(consumer, "te]st@test.com", Messages.ERM_011);
		// Caso (rigth length) + (no local)
		assertFail(consumer, "@test.com", Messages.ERM_011);
		// Caso (rigth length) + (rigth nº @) + (local not end .) + (local special char) + (no domain)
		assertFail(consumer, "test@", Messages.ERM_011);
	}

	//@Test
	public void testGetPhoneNumber() {
		assertEquals("1111111111", visitor.getPhoneNumber());
	}

	@Test
	public void testSetPhoneNumberPositive() {
		// Caso length = max
		visitor.setPhoneNumber(cadenaString("1", 20));
		assertEquals(cadenaString("1", 20), visitor.getPhoneNumber());
		// Caso length = min
		visitor.setPhoneNumber(cadenaString("1", 10));
		assertEquals(cadenaString("1", 10), visitor.getPhoneNumber());

		// Caso numero internacional
		visitor.setPhoneNumber("+346918723451");
		assertEquals("+346918723451", visitor.getPhoneNumber());
		// Caso numero nacional con espacios dentro
		visitor.setPhoneNumber("691 87 23 45 1");
		assertEquals("691 87 23 45 1", visitor.getPhoneNumber());
		// Caso numero internacional con espacios dentro
		visitor.setPhoneNumber("+34 691 87 23 45 1");
		assertEquals("+34 691 87 23 45 1", visitor.getPhoneNumber());
	}

	@Test
	public void testSetPhoneNumberNegative() {
		Consumer<String> consumer = dato -> visitor.setPhoneNumber(dato);

		// Caso null
		assertFail(consumer, null, Messages.ERM_010);
		// Caso length < min
		assertFail(consumer, "", Messages.ERM_010);
		// Caso length > max
		assertFail(consumer, cadenaString("1", 21), Messages.ERM_010);
		// Caso (right length) + (alpha char)
		assertFail(consumer, cadenaString("a", 10), Messages.ERM_010);
		// Caso (right length) + ( no alpha char) + (national number) + (starts with space)
		assertFail(consumer, " 6918723451", Messages.ERM_010);
		// Caso (right length) + ( no alpha char) + (international number) + (starts with space)
		assertFail(consumer, " +346918723451", Messages.ERM_010);
	}

	@Test
	public void testGetDni() {
		assertEquals("11.111.111-H", visitor.getDni());
	}

	@Test
	public void testSetDniPositive() {
		// Caso (right length) + (right format) + (right char)
		visitor.setDni("50.252.285-E");
		assertEquals("50.252.285-E", visitor.getDni());
	}

	@Test
	public void testSetDniNegative() {
		Consumer<String> consumer = dato -> visitor.setDni(dato);

		// Caso null
		assertFail(consumer, null, Messages.ERM_012);
		// Caso length < min
		assertFail(consumer, "1", Messages.ERM_012);
		// Caso length > max
		assertFail(consumer, cadenaString("1", 13), Messages.ERM_012);
		// Caso (right length) + (wrong format)
		assertFail(consumer, "11.111111-H", Messages.ERM_012);
		// Caso (right length) + (right format) + (wrong char)
		assertFail(consumer, "11.111.111-L", Messages.ERM_012);
	}

	// Metodos propios
	private String cadenaString(String letra,int veces){
		StringBuilder palabra = new StringBuilder();
		for(int i = 0;i < veces;i++){
			palabra.append(letra);
		}
		return palabra.toString();
	}

	private <T> void assertFail(Consumer<T> consumer, T dato, String mensaje) {
		try{
			consumer.accept(dato);
			fail("Deberia haber saltado una excepcion");
		}catch(Exception e){
			assertEquals(mensaje, e.getMessage());
		}
	}
}
