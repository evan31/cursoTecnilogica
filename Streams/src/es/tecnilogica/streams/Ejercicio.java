package es.tecnilogica.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio {

	public static void main(String[] args) {
		// Instancia de la lista
		List<Event> eventList = new ArrayList<Event>();

		// Instancias de eventos
		Event event1 = new Event();
		Event event2 = new Event();
		Event event3 = new Event();
		Event event4 = new Event();
		Event event5 = new Event();

		// Rellenamos los eventos
		fillEvents(event1, event2, event3, event4, event5);

		// Insertamos los eventos en la lista
		eventList.add(event1);
		eventList.add(event2);
		eventList.add(event3);
		eventList.add(event4);
		eventList.add(event5);

		// Ejercicio 1: Prints the name of all members
		System.out.println("----- Ejercicio 1 -----");
		eventList.stream().forEach(x -> System.out.println(x.getName()));

		// Ejercicio 2: Prints the name of all members of type “sport”
		System.out.println("----- Ejercicio 2 -----");
		eventList.stream().
			filter(event -> event.getType().equalsIgnoreCase("sport")).
			forEach(event -> System.out.println(event.getName()));

		// Ejercicio 3: Get the sum of the seatsAvailable of all members of type “sport”
		System.out.println("----- Ejercicio 3 -----");
		System.out.println(eventList.stream().
			filter(event -> event.getType().equalsIgnoreCase("sport")).
			mapToInt(event -> event.getSeatsAvailable()).sum());

		// Ejercicio 4: We need to find a list all element of type “sport” and return a list of id’s
		System.out.println("----- Ejercicio 4 ----");
		eventList.stream().
			filter(event -> event.getType().equalsIgnoreCase("sport")).
			map(event -> event.getId()).
			collect(Collectors.toList()).
			forEach(event -> System.out.println(event));

		// Ejercicio 5: We need to find a list all element of type “sport” and return a list of id’s sorting in decreasing order by name.
		System.out.println("----- Ejercicio 5 -----");
		Comparator<Event> nameComparator = (Event e1,Event e2) -> e2.getName().compareTo(e1.getName());
		eventList.stream().
			filter(e -> e.getType().equalsIgnoreCase("sport")).
			sorted(nameComparator).
			map(e -> e.getId()/*e.getName()*/).
			collect(Collectors.toList()).
			forEach(e -> System.out.println(e));
	}

	private static void fillEvents(Event event1, Event event2, Event event3,
			Event event4, Event event5) {
		// Evento 1
		event1.setId(1);
		event1.setName("Event 1");
		event1.setType("musical");
		event1.setSeatsAvailable(3);
		// Evento 2
		event2.setId(2);
		event2.setName("Event 2");
		event2.setType("sport");
		event2.setSeatsAvailable(5);
		// Evento 3
		event3.setId(3);
		event3.setName("Event 3");
		event3.setType("sport");
		event3.setSeatsAvailable(10);
		// Evento 4
		event4.setId(4);
		event4.setName("Event 4");
		event4.setType("cultural");
		event4.setSeatsAvailable(34);
		// Evento 5
		event5.setId(5);
		event5.setName("Event 5");
		event5.setType("sport");
		event5.setSeatsAvailable(56);
	}

}
