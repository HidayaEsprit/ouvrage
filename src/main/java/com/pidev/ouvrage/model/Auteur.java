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
import javax.persistence.Table;

@Entity
@Table(name = "auteur")
public class Auteur implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long idAut;
	@Column
	private String nomAut;
	@Column
	private String prenomAut;
	
	
	@OneToMany(mappedBy = "auteur", targetEntity = Ouvrage.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Ouvrage> ouvrages;
	
	
	
	
	public Auteur() {
		super();
		
	}
	

	public Auteur(long idAut, String nomAut, String prenomAut, List<Ouvrage> ouvrages) {
		super();
		this.idAut = idAut;
		this.nomAut = nomAut;
		this.prenomAut = prenomAut;
		this.setOuvrages(ouvrages);
	}

	public long getIdAut() {
		return idAut;
	}

	public void setIdAut(long idAut) {
		this.idAut = idAut;
	}

	public String getNomAut() {
		return nomAut;
	}

	public void setNomAut(String nomAut) {
		this.nomAut = nomAut;
	}


	public String getPrenomAut() {
		return prenomAut;
	}

	public void setPrenomAut(String prenomAut) {
		this.prenomAut = prenomAut;
	}



	@Override
	public String toString() {
		return "Auteur [idAut=" + idAut + ", nomAut=" + nomAut + ", prenomAut=" + prenomAut + "]";
	}


	/*public List<Ouvrage> getOuvrages() {
		return ouvrages;
	}
*/

	public void setOuvrages(List<Ouvrage> ouvrages) {
		this.ouvrages = ouvrages;
	}


	
}
