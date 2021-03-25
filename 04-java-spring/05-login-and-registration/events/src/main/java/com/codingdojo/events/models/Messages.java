package com.codingdojo.events.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="messages")
public class Messages {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String comment;
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User commenter;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="event_id")
    private Events eventComment;
    
    public Messages() {
    	
    }
	public Messages(User commenter, Events eventComment, String comment) {
		this.commenter = commenter;
		this.eventComment = eventComment;
		this.comment = comment;
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
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
	public User getCommenter() {
		return commenter;
	}
	public void setCommenter(User commenter) {
		this.commenter = commenter;
	}
	public Events getEventComment() {
		return eventComment;
	}
	public void setEventComment(Events eventComment) {
		this.eventComment = eventComment;
	}
	
}
