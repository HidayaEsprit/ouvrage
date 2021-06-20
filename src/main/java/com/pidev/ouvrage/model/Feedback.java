package com.pidev.ouvrage.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="Feedback")
public class Feedback implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nomCom ;
	@Temporal(TemporalType.DATE)
	private Date dateCom;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private DAOUser user;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomCom() {
		return nomCom;
	}
	public void setNomCom(String nomCom) {
		this.nomCom = nomCom;
	}
	public Date getDateCom() {
		return dateCom;
	}
	public void setDateCom(Date dateCom) {
		this.dateCom = dateCom;
	}
	public Feedback() {
		super();
	}
	public Feedback(String nomCom, Date dateCom) {
		super();
		this.nomCom = nomCom;
		this.dateCom = dateCom;
	}
	
	
}
