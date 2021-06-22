package com.pidev.ouvrage.model;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "facture")
public class Facture {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
    private LocalDate dateFacture;
    
    @OneToOne
    private Commande commande;
}
