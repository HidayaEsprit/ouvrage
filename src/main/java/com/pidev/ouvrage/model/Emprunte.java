package com.pidev.ouvrage.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Emprunte")
public class Emprunte implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
	private Date dateDeb;
	
	private int Duree ;
	
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
	private Date dateFin;
	
	@ManyToOne
	private DAOUser user;
	
	@ManyToOne
	private Ouvrage ouvrage;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateDeb() {
		return dateDeb;
	}

	public void setDateDeb(Date dateDeb) {
		this.dateDeb = dateDeb;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public DAOUser getUser() {
		return user;
	}

	public void setUser(DAOUser user) {
		this.user = user;
	}

	public Ouvrage getOuvrage() {
		return ouvrage;
	}

	public void setOuvrage(Ouvrage ouvrage) {
		this.ouvrage = ouvrage;
	}

	

	public int getDuree() {
		return Duree;
	}

	public void setDuree(int duree) {
		Duree = duree;
	}

	public Emprunte(Long id, Date dateDeb, int duree, Date dateFin, DAOUser user, Ouvrage ouvrage) {
		super();
		this.id = id;
		this.dateDeb = dateDeb;
		Duree = duree;
		this.dateFin = dateFin;
		this.user = user;
		this.ouvrage = ouvrage;
	}

	public Emprunte() {
		super();
	}
	
}
