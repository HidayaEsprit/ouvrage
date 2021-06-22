package com.pidev.ouvrage.model;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "panier")
public class Panier {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private long quantite;
	@Column
    private Float prix;
    
    @OneToMany()
	private List<Ouvrage> ouvrages ;
	
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getQuantite() {
		return this.quantite;
	}

	public void setQuantite(long quantite) {
		this.quantite = quantite;
	}

	public Float getPrix() {
		return this.prix;
	}

	public void setPrix(Float prix) {
		this.prix = prix;
	}

	public List<Ouvrage> getOuvrages() {
		return this.ouvrages;
	}

	public void setOuvrages(List<Ouvrage> ouvrages) {
		this.ouvrages = ouvrages;
	}



}
