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
@Table(name="WishList")
public class WishList  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String image ;
	private String titre;
	private String auteur;
	private Boolean disponiblite;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private DAOUser user;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public Boolean getDisponiblite() {
		return disponiblite;
	}

	public void setDisponiblite(Boolean disponiblite) {
		this.disponiblite = disponiblite;
	}

	public DAOUser getUser() {
		return user;
	}

	public void setUser(DAOUser user) {
		this.user = user;
	}

	public WishList() {
		super();
	}

	public WishList(String image, String titre, String auteur, Boolean disponiblite, DAOUser user) {
		super();
		this.image = image;
		this.titre = titre;
		this.auteur = auteur;
		this.disponiblite = disponiblite;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
