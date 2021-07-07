package com.pidev.ouvrage.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Dislike")
public class Dislike implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2229385718861432639L;
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private DAOUser user;
	@ManyToOne(cascade=CascadeType.ALL)
	private Feedback feedback;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public DAOUser getUser() {
		return user;
	}
	public void setUser(DAOUser user) {
		this.user = user;
	}
	public Feedback getFeedback() {
		return feedback;
	}
	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}
	public Dislike(DAOUser user, Feedback feedback) {
		super();
		this.user = user;
		this.feedback = feedback;
	}
	public Dislike() {
		super();
	}
	
	
}