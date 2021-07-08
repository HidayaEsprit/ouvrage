package com.pidev.ouvrage.model;



import javax.persistence.*;

@Entity
@Table(name = "ouvrage")
public class Ouvrage {
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

	public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRef() {
        return this.ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

	public Ouvrage(long id, String ref, String nomLivre, int qteStock, double prix) {
		super();
		this.id = id;
		this.ref = ref;
		this.nomLivre = nomLivre;
		this.qteStock = qteStock;
		this.prix = prix;
	}

	public Ouvrage() {
		super();
	}

}