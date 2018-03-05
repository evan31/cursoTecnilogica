package es.tecnilogica.streams;

public class Event {
	private int id;
	private String name;
	private String type;
	private int seatsAvailable;

	/**
	 * Empty Constructor
	 */
	public Event(){

	}

	/**
	 * Copy Constructor
	 * @param e Event to copy
	 */
	public Event(Event e){
		this.id = e.id;
		this.name = e.name;
		this.type = e.type;
		this.seatsAvailable = e.seatsAvailable;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return the seatsAvailable
	 */
	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @param seatsAvailable the seatsAvailable to set
	 */
	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

}
