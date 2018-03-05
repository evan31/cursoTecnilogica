package com.codington.module4;

public class CodintonEventDetails {
	// Enumeracion de las localizaciones
	private enum EventLocation{NORTH,SOUTH};

	public static void main(String[] args) {
		// Instanciamos el evento 1
		Event event1 = new Event();
		// Insertamos los atributos del evento 1
		event1.setEventName("Royal Codington Show");
		event1.setDuration(1);
		event1.setLocation(EventLocation.NORTH.toString());
		event1.eventDate = "Wednesday, NOV 25, 2015 at 11:00 hrs";

		// Instanciamos el evento 2
		Event event2 = new Event();
		// Insertamos los atributos del evento 2
		event2.setEventName("Science Alive");
		event2.setDuration(2);
		event2.setLocation(EventLocation.SOUTH.toString());
		event2.eventDate = "Wednesday, NOV 25, 2015 at 16:00 hrs";

		// Mostramos el mensade "Hello Visitors!!"
		System.out.println("Hello Visitors!!\n\n");

		// Mostramos los datos del evento 1
		System.out.println("Event Name = " + event1.getEventName());
		System.out.println("Duration in hours = " + event1.getDuration());
		System.out.println("Location = " + event1.getLocation());
		System.out.println("When = " + event1.eventDate + "\n\n");
		// Mostramos los datos del evento 1
		System.out.println("Event Name = " + event2.getEventName());
		System.out.println("Duration in hours = " + event2.getDuration());
		System.out.println("Location = " + event2.getLocation());
		System.out.println("When = " + event2.eventDate + "\n\n");
	}

}
