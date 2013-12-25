package vco.aed.models;

import java.util.Set;

public class Person {
	private final Long id;
	
	private String name;

	private final Set<Event> events;
	
	public Person(Long id, Set<Event> events) {
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
}
