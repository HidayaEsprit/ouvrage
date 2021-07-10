package com.pidev.ouvrage.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categorie implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long idCat;
	@Column
	private String nomCat;
	
	
	
	@OneToMany(mappedBy = "categorie", targetEntity = Ouvrage.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Ouvrage> ouvrages;
	
	
	public Categorie() {
		super();
		
	}
	

	public Categorie(long idCat, String nomCat, List<Ouvrage> ouvrages) {
		super();
		this.idCat = idCat;
		this.nomCat = nomCat;
		this.setOuvrages(ouvrages);
	}

	public long getIdCat() {
		return idCat;
	}
	public void setIdCat(long idCat) {
		this.idCat = idCat;
	}
	public String getNomCat() {
		return nomCat;
	}
	public void setNomCat(String nomCat) {
		this.nomCat = nomCat;
	}



	@Override
	public String toString() {
		return "Categorie [idCat=" + idCat + ", nomCat=" + nomCat + "]";
	}



	/*public List<Ouvrage> getOuvrages() {
		return ouvrages;
	}
*/

	public void setOuvrages(List<Ouvrage> ouvrages) {
		this.ouvrages = ouvrages;
	} 


	


	


	
	
	
}
