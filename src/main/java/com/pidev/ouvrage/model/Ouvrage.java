package com.pidev.ouvrage.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.pidev.ouvrage.model.Auteur;
import com.pidev.ouvrage.model.Categorie;



@Entity
@Table(name = "ouvrage")
public class Ouvrage implements Serializable {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
	@Column
    private String ref;
	@Column
	private String nomLivre;
	@Column
	private int qteStock;
	@Column
	private double prix;
	@Column
	private int initStock;

	public int getInitStock() {
		return this.initStock;
	}

	public void setInitStock(int initStock) {
		this.initStock = initStock;
	}

	@Column(updatable = false)
	private LocalDate update_At;

	public LocalDate getUpdate_At() {
		return this.update_At;
	}

	public void setUpdate_At(LocalDate update_At) {
		this.update_At = update_At;
	}
	
	@Column
	private LocalDate created_At;

	public LocalDate getCreated_At() {
		return this.created_At;
	}

	public void setCreated_At(LocalDate created_At) {
		this.created_At = created_At;
	}
    
	@ManyToOne
	private Categorie categorie;
	
	@ManyToOne
	private Auteur auteur;
	
	@OneToMany(mappedBy = "ouvrage", cascade = CascadeType.ALL, orphanRemoval = true)
	  private Set<OuvrageUser> UserOuvrages = new HashSet<>();
	
    public Ouvrage() {
		super();
		
	}
   
    
	public Ouvrage( int id ,String ref, String nomLivre, int qteStock, double prix,
			com.pidev.ouvrage.model.Categorie categorie, com.pidev.ouvrage.model.Auteur auteur) {
		super();
		this.id = id;
		this.ref = ref;
		this.nomLivre = nomLivre;
		this.qteStock = qteStock;
		this.prix = prix;
		this.setCategorie(categorie);
		this.setAuteur(auteur);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getNomLivre() {
		return nomLivre;
	}

	public void setNomLivre(String nomLivre) {
		this.nomLivre = nomLivre;
	}

	public int getQteStock() {
		return qteStock;
	}

	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}


	public Categorie getCategorie() {
		return categorie;
	}


	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	public Auteur getAuteur() {
		return auteur;
	}


	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}


	/*public Set<OuvrageUser> getUserOuvrages() {
		return UserOuvrages;
	}


	public void setUserOuvrages(Set<OuvrageUser> userOuvrages) {
		UserOuvrages = userOuvrages;
	}


	@Override
	public String toString() {
		return "Ouvrage [id=" + id + ", ref=" + ref + ", nomLivre=" + nomLivre + ", qteStock=" + qteStock + ", prix="
				+ prix + ", categorie=" + categorie + ", auteur=" + auteur + ", UserOuvrages=" + UserOuvrages + "]";
	}*/


}
