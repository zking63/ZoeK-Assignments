package com.codingdojo.events.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="events")
public class Events {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String name;
	@NotEmpty
	private String eventState;
	@Future
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	private Date eventDate;
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User planner;
    @OneToMany(fetch=FetchType.LAZY, mappedBy="eventComment")
    private List<Messages> eventComments;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	        name = "events_users", 
	        joinColumns = @JoinColumn(name = "event_id"), 
	        inverseJoinColumns = @JoinColumn(name = "user_id")
			)
	private List<User> attendees;
	public Events() {
		
	}
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
	    this.updatedAt = new Date();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEventState() {
		return eventState;
	}
	public void setEventState(String eventState) {
		this.eventState = eventState;
	}
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
    public String getEventDateFormatted() {
    	SimpleDateFormat df = new SimpleDateFormat("MMMM, dd, YYYY");
    	return df.format(this.eventDate);
    }
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public List<User> getAttendees() {
		return attendees;
	}
	public void setAttendees(List<User> attendees) {
		this.attendees = attendees;
	}
	public User getPlanner() {
		return planner;
	}
	public void setPlanner(User planner) {
		this.planner = planner;
	}
	
}
