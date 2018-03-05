package es.tecnilogica.ejemplos.spring.entities;




/**
 * Entity class for Event
 */
public class Event {

	private int eventid;
	private String name;
	private String description;
	private String place;
	private String duration;
	private String eventType;
	private int seatsAvailable;


	public int getEventid()
	{
		return eventid;
	}

	public void setEventid(int eventid)
	{
		this.eventid = eventid;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getPlace()
	{
		return place;
	}

	public void setPlace(String place)
	{
		this.place = place;
	}

	public String getDuration()
	{
		return duration;
	}

	public void setDuration(String duration)
	{
		this.duration = duration;
	}

	public String getEventType()
	{
		return eventType;
	}

	public void setEventType(String eventType)
	{
		this.eventType = eventType;
	}

	public int getSeatsAvailable()
	{
		return seatsAvailable;
	}

	public void setSeatsAvailable(int seatsAvailable)
	{
		this.seatsAvailable = seatsAvailable;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Event [eventid=" + eventid + ", name=" + name
				+ ", description=" + description + ", place=" + place
				+ ", duration=" + duration + ", eventType=" + eventType
				+ ", seatsAvailable=" + seatsAvailable + "]";
	}


}


