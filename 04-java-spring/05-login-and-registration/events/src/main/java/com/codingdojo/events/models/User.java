package com.codingdojo.events.models;

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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table (name="users1")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String firstName;
	@NotEmpty
	private String lastName;
	@NotEmpty
	private String city;
	@NotEmpty
	private String state;
	@NotEmpty
	@Email(message="Must be a valid email.")
	private String email;
	@NotEmpty
	@Size(min=5, message="Password must be at least 5 characters.")
	private String password;
	@NotEmpty
	@Transient
	private String passwordConfirmation;
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
    @OneToMany(fetch=FetchType.LAZY, mappedBy="planner")
    private List<Events> eventsPlanned;
    @OneToMany(fetch=FetchType.LAZY, mappedBy="commenter")
    private List<Messages> commentsMade;
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
		name="events_users",
		joinColumns = @JoinColumn(name="user_id"),
		inverseJoinColumns = @JoinColumn(name="event_id")
	)
    private List<Events> eventsAttending;
	
	public User() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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
	
	public List<Events> getEventsPlanned() {
		return eventsPlanned;
	}

	public void setEventsPlanned(List<Events> eventsPlanned) {
		this.eventsPlanned = eventsPlanned;
	}

	public List<Events> getEventsAttending() {
		return eventsAttending;
	}

	public void setEventsAttending(List<Events> eventsAttending) {
		this.eventsAttending = eventsAttending;
	}
	

	public List<Messages> getCommentsMade() {
		return commentsMade;
	}

	public void setCommentsMade(List<Messages> commentsMade) {
		this.commentsMade = commentsMade;
	}

	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
	    this.updatedAt = new Date();
	}
}
