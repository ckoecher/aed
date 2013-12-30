package vco.aed.server.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private final Long id;
	
	@Column(nullable=false)
	private String name;

	@ManyToMany(mappedBy="members")
	private final Set<Event> events;
	
	public Person() {
		this.id = null;
		this.events = new HashSet<Event>();
	}
	
	public Person(String name) {
		this.id = null;
		this.events = new HashSet<Event>();
		this.name = name;
	}
	
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
	
	@Override
	public String toString() {
		return this.name;
	}
}
