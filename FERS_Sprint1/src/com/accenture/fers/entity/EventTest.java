package com.accenture.fers.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.function.Consumer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.accenture.fers.utils.Messages;

public class EventTest {

	Event evento = new Event();

	@Before
	public void setUp() throws Exception {
		evento.setEventId(1);
		evento.setName("Marathon");
		evento.setDescription("Run");
		evento.setPlace("Park");
		evento.setDuration("4 hours");
		evento.setEventType("Sports");
		evento.setSeatsAvailable(2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEventEventPositive() {
		Event e2 = new Event(evento);
		assertEquals(e2, evento);
	}
	@Test
	public void testEventEventNegative() {
		Consumer<Event> consumer = dato -> new Event(dato);

		assertFail(consumer,null,Messages.ERM_VACIO);
	}

	@Test
	public void testGetName() {
		assertEquals("Marathon", evento.getName());
	}

	@Test
	public void testSetNamePositive() {
		// Caso longitud = min
		evento.setName("a");
		assertEquals("a", evento.getName());

		// Caso longitud = max
		evento.setName(cadenaString("a",45));
		assertEquals(cadenaString("a",45), evento.getName());
	}

	// Version 1
	/*@Test
	public void testSetNameNegative() {
		try{
			evento.setName(null);
			fail("Deberia haber saltado una excepcion");
		}catch(Exception e){
			assertEquals(Messages.ERM_018, e.getMessage());
		}
	}*/
	// Version 2 - Consumer
	@Test
	public void testSetNameNegative() {
		Consumer<String> consumer = dato -> evento.setName(dato);

		// consumer, valor de testeo, mensaje que espero
		// Caso null
		assertFail(consumer,null,Messages.ERM_018);
		// Caso length < min
		assertFail(consumer, "", Messages.ERM_018);
		// Caso length > max
		assertFail(consumer, cadenaString("a", 46), Messages.ERM_018);
	}

	@Test
	public void testGetDescription() {
		assertEquals("Run", evento.getDescription());
	}

	@Test
	public void testSetDescriptionPositive() {
		// Caso longitud = min
		evento.setDescription("a");
		assertEquals("a", evento.getDescription());

		// Caso longitud = max
		evento.setDescription(cadenaString("a",45));
		assertEquals(cadenaString("a",45), evento.getDescription());
	}
	@Test
	public void testSetDescriptionNegative() {
		Consumer <String> consumer = dato -> evento.setDescription(dato);

		// Caso null
		assertFail(consumer,null,Messages.ERM_019);
		// Caso length < min
		assertFail(consumer,"",Messages.ERM_019);
		// Caso length > max
		assertFail(consumer,cadenaString("a", 46),Messages.ERM_019);
	}

	@Test
	public void testGetPlace() {
		assertEquals("Park", evento.getPlace());
	}

	@Test
	public void testSetPlacePositive() {
		// Caso longitud = min
		evento.setPlace("a");
		assertEquals("a", evento.getPlace());

		// Caso longitud = max
		evento.setPlace(cadenaString("a",45));
		assertEquals(cadenaString("a",45), evento.getPlace());
	}
	@Test
	public void testSetPlaceNegative() {
		Consumer<String> consumer = dato -> evento.setPlace(dato);

		// Caso null
		assertFail(consumer,null,Messages.ERM_020);
		// Caso length < min
		assertFail(consumer,"",Messages.ERM_020);
		// Caso length > max
		assertFail(consumer,cadenaString("a", 46),Messages.ERM_020);
	}

	@Test
	public void testGetDuration() {
		assertEquals("4 hours", evento.getDuration());
	}

	@Test
	public void testSetDurationPositive() {
		// Caso longitud = min
		evento.setDuration("a");
		assertEquals("a", evento.getDuration());

		// Caso longitud = max
		evento.setDuration(cadenaString("a",45));
		assertEquals(cadenaString("a",45), evento.getDuration());
	}
	@Test
	public void testSetDurationNegative() {
		Consumer<String> consumer = dato -> evento.setDuration(dato);

		// Caso null
		assertFail(consumer,null,Messages.ERM_021);
		// Caso length < min
		assertFail(consumer,"",Messages.ERM_021);
		// Caso length > max
		assertFail(consumer,cadenaString("a", 46),Messages.ERM_021);
	}

	@Test
	public void testGetEventType() {
		assertEquals("Sports", evento.getEventType());
	}

	@Test
	public void testSetEventTypePositive() {
		// Caso longitud = min
		evento.setEventType("a");
		assertEquals("a", evento.getEventType());

		// Caso longitud = max
		evento.setEventType(cadenaString("a",45));
		assertEquals(cadenaString("a",45), evento.getEventType());
	}
	@Test
	public void testSetEventTypeNegative() {
		Consumer<String> consumer = dato -> evento.setEventType(dato);

		// Caso null
		assertFail(consumer,null,Messages.ERM_022);
		// Caso length < min
		assertFail(consumer,"",Messages.ERM_022);
		// Caso length > max
		assertFail(consumer,cadenaString("a", 46),Messages.ERM_022);
	}

	@Test
	public void testGetSeatsAvailable() {
		assertEquals(2, evento.getSeatsAvailable());
	}

	@Test
	public void testSetSeatsAvailablePositive() {
		// Caso plazas = 0
		evento.setSeatsAvailable(0);
		assertEquals(0, evento.getSeatsAvailable());
	}
	@Test
	public void testSetSeatsAvailableNegative() {
		Consumer<Integer> consumer = dato -> evento.setSeatsAvailable(dato);

		// Caso plazas = 0
		assertFail(consumer,-1,Messages.ERM_023);
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
