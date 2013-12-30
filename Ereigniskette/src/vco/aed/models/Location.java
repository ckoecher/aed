package vco.aed.models;

import java.util.HashSet;
import java.util.Set;

public class Location {
	private final Long id;
	
	private String name;

	private final Set<Event> events;
	
	public Location() {
		this.id = null;
		this.events = new HashSet<Event>();
	}
	
	public Location(String name) {
		this.id = null;
		this.events = new HashSet<Event>();
		this.name = name;
	}
	
	public Location(Long id,Set<Event> events) {
		this.id = id;
		this.events = events;
	}
	
	public Long getId() {
		return id;
	}

	public Set<Event> getEvents() {
		return events;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
}
