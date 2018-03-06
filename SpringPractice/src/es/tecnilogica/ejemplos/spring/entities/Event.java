package es.tecnilogica.ejemplos.spring.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




/**
 * Entity class for Event
 */
@Table(name="events")
@Entity
public class Event{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int eventid;

	@Column(name="name")
	private String name;

	@Column(name="description")
	private String description;

	@Column(name="places")
	private String place;

	@Column(name="duration")
	private String duration;

	@Column(name="event_type")
	private String eventType;

	@Column(name="seats_available")
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


