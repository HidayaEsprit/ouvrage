package com.pidev.ouvrage.model;

import java.time.LocalDate;

import javax.persistence.*;

import com.pidev.ouvrage.model.enumeration.EtatCommande;
import com.pidev.ouvrage.model.enumeration.MoyenPaiement;
import com.pidev.ouvrage.model.enumeration.StatusCommande;

@Entity
@Table(name = "commande")
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private Float total;

	@Column
	private Float tauxLivraison;

	@Column
	private Float TVA;

	@Column
	private Float sousTotal;

	@Column
	private LocalDate dateCommande;

	
	@Column
	private LocalDate dateLivraison;

	@OneToOne
    @JoinColumn(unique = true)
	private Panier panier;

	@ManyToOne
	private DAOUser user;

	@OneToOne
	private Facture facture;

	@Enumerated(EnumType.STRING)
    @Column(name = "etat", nullable = false)
	private EtatCommande etat;
	
	@Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
	private StatusCommande status;
	
	@Enumerated(EnumType.STRING)
    @Column(name = "moyenPaiement", nullable = false)
    private MoyenPaiement moyenPaiement;

	public Float getTauxLivraison() {
		return this.tauxLivraison;
	}

	public void setTauxLivraison(Float tauxLivraison) {
		this.tauxLivraison = tauxLivraison;
	}

	public LocalDate getDateCommande() {
		return this.dateCommande;
	}

	public void setDateCommande(LocalDate dateCommande) {
		this.dateCommande = dateCommande;
	}

	public LocalDate getDateLivraison() {
		return this.dateLivraison;
	}

	public void setDateLivraison(LocalDate dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public Float getSousTotal() {
		return this.sousTotal;
	}

	public void setSousTotal(Float sousTotal) {
		this.sousTotal = sousTotal;
	}

	public Float getTVA() {
		return this.TVA;
	}

	public void setTVA(Float TVA) {
		this.TVA = TVA;
	}

	public Facture getFacture() {
		return this.facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public DAOUser getUser() {
		return this.user;
	}

	public void setUser(DAOUser user) {
		this.user = user;
	}
	
	public Float getTotal() {
		return this.total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Panier getPanier() {
		return this.panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	public EtatCommande getEtat() {
		return this.etat;
	}

	public void setEtat(EtatCommande etat) {
		this.etat = etat;
	}

	public StatusCommande getStatus() {
		return this.status;
	}

	public void setStatus(StatusCommande status) {
		this.status = status;
	}

	public MoyenPaiement getMoyenPaiement() {
		return this.moyenPaiement;
	}

	public void setMoyenPaiement(MoyenPaiement moyenPaiement) {
		this.moyenPaiement = moyenPaiement;
	}



}
