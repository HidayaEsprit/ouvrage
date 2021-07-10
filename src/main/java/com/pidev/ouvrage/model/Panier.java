package com.pidev.ouvrage.model;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "panier")
public class Panier {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    @Column
    private Boolean paiment;
    public Panier(DAOUser user, Set<OuvrageUser> ouvrageUsers) {
		
		this.user = user;
		this.ouvrageUsers = ouvrageUsers;
		this.paiment=false ;
		this.total=(float) 0;
	}
   
    @OneToMany(mappedBy = "panier", cascade = CascadeType.ALL, orphanRemoval = true)
	  private Set<OuvrageUser> ouvrageUsers = new HashSet<>();
	//
	@Column
	private long quantite;
	public Boolean getPaiment() {
		return paiment;
	}

	public void setPaiment(Boolean paiment) {
		this.paiment = paiment;
	}


	public void setUser(DAOUser user) {
		this.user = user;
	}

	public Set<OuvrageUser> getOuvrageUsers() {
		return ouvrageUsers;
	}

	public void setOuvrageUsers(Set<OuvrageUser> ouvrageUsers) {
		this.ouvrageUsers = ouvrageUsers;
	}

	@Column
    private Float total;
	  //new column
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	 private DAOUser user;
	  //new column
	  
	 
	 
	  public Panier() {
		super();
	}

	//new column
    @OneToMany(cascade = CascadeType.ALL)
	private List<Ouvrage> ouvrages;

	public List<Ouvrage> getOuvrages() {
		return this.ouvrages;
	}

	public void setOuvrages(List<Ouvrage> ouvrages) {
		this.ouvrages = ouvrages;
	}
	
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	public void setQuantite(long quantite) {
		this.quantite = quantite;
	}

	public Float getPrix() {
		return this.total;
	}

	public void setPrix(Float prix) {
		this.total = prix;
	}



	



}
