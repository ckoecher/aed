package vco.aed.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Event {
	private final Long id;

	private String name;
	
	private String description;
	
	private Date start;
	
	private Date end;
	
	private final Set<Person> members;

	private final Set<Location> locations;
	
	private final Set<Event> prevEvents;
	

	public Event() {
		this.id = null;
		this.members = new HashSet<Person>();
		this.locations = new HashSet<Location>();
		this.prevEvents = new HashSet<Event>();
	}
	
	public Event(String name) {
		this.id = null;
		this.members = new HashSet<Person>();
		this.locations = new HashSet<Location>();
		this.prevEvents = new HashSet<Event>();
		this.name = name;
	}
	
	public Event(Long id, Set<Person> members, Set<Location> locations, Set<Event> prevEvents) {
		this.id = id;
		this.members = members;
		this.locations = locations;
		this.prevEvents = prevEvents;
	}
	
	public Long getId() {
		return id;
	}

	public Set<Event> getPrevEvents() {
		return prevEvents;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public Set<Location> getLocations() {
		return locations;
	}

	public Date getStart() {
		return start;
	}

	public Set<Person> getMembers() {
		return members;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
}
