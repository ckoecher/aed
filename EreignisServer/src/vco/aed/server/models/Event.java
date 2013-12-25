package vco.aed.server.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;



@Entity
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private final Long id;

	@Column(nullable=false)
	private String name;
	
	private String description;
	
	private Date start;
	
	private Date end;
	
//	private static final String idString = "ID";
	
	@ManyToMany
	@JoinTable(name="EVENT_PERSON",
	joinColumns={@JoinColumn(name="EVENT_ID",referencedColumnName="ID")},
	inverseJoinColumns={@JoinColumn(name="PERSON_ID",referencedColumnName="ID")} )
	private final Set<Person> members;

	@ManyToMany
	@JoinTable(name="EVENT_LOCATION",
	joinColumns={@JoinColumn(name="EVENT_ID",referencedColumnName="ID")},
	inverseJoinColumns={@JoinColumn(name="LOCATION_ID",referencedColumnName="ID")} )
	private final Set<Location> locations;
	
	@OneToMany
	private final Set<Event> prevEvents;
	

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
	
	
	
}
