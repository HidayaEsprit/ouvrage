package com.pidev.ouvrage.model;

import javax.persistence.*;  
import java.io.Serializable;

@Entity
@Table(name = "ouvrage_user")
public class OuvrageUser {
	@EmbeddedId
    private UserOuvrageId id;
     
    @ManyToOne()
    @MapsId("userId")

    @JoinColumn(name = "user_id")
    private DAOUser user;

    @ManyToOne()
    @MapsId("ouvrageId")
    @JoinColumn(name = "ouvrage_id")
    private Ouvrage ouvrage;
   
    
    @ManyToOne
    @MapsId("panierId")
    @JoinColumn(name="panier_id", nullable=false)
    private Panier panier;
    
      
    @Column
	private long quantite;
	
	
	
	
	
	





	public void setUser(DAOUser user) {
		this.user = user;
	}





	public Ouvrage getOuvrage() {
		return ouvrage;
	}





	public void setOuvrage(Ouvrage ouvrage) {
		this.ouvrage = ouvrage;
	}





	public long getQuantite() {
		return quantite;
	}





	public void setQuantite(long quantite) {
		this.quantite = quantite;
	}
















	public OuvrageUser() {
		super();
	}





	public OuvrageUser(DAOUser user, Ouvrage ouvrage, long quantite,Panier panier) {
		super();
		this.id = new UserOuvrageId(user.getId(),ouvrage.getId(),panier.getId());
		this.user = user;
		this.ouvrage = ouvrage;
		this.quantite = quantite;
		this.panier=panier;
	}

}
