package com.pidev.ouvrage.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.ouvrage.model.Commande;
import com.pidev.ouvrage.model.DAOUser;
import com.pidev.ouvrage.model.Ouvrage;
import com.pidev.ouvrage.model.Panier;
import com.pidev.ouvrage.model.enumeration.EtatCommande;
import com.pidev.ouvrage.model.enumeration.StatusCommande;
import com.pidev.ouvrage.repository.CommandeRepository;
import com.pidev.ouvrage.repository.UserRepository;


@Service
public class CommandeServices {

	@Autowired
	CommandeRepository CommandeRepository;

	private final PanierServices panierServices;
	private final OuvrageServices ouvrageServices ; 
	private final UserRepository userRepository ; 

	public CommandeServices(PanierServices panierServices , OuvrageServices ouvrageServices , UserRepository userRepository){
		this.panierServices = panierServices;
		this.ouvrageServices = ouvrageServices;
		this.userRepository = userRepository ;
	}

	public Commande save (Commande c){
		List<Ouvrage> listOuvrages ;
		Float tva ;
		Panier panier;
		LocalDate now = LocalDate.now();
		Ouvrage O ; 
		Float sous_total = (float) 0;
		panier = panierServices.getPanierbyId(c.getPanier().getId());
		listOuvrages = panier.getOuvrages();

		for (Ouvrage ouvrage : listOuvrages) {
			O = ouvrageServices.getOuvragebyId(ouvrage.getId());
			sous_total = (float) (sous_total +O.getPrix());
		}
		c.setSousTotal(sous_total);
		c.setDateCommande(now);
		c.setDateLivraison(now.plusDays(1));
		c.setEtat(EtatCommande.SUCCEED);
		c.setStatus(StatusCommande.started);
		tva = (sous_total * 19)/100 ;
		c.setTVA(tva);
		c.setTotal((float)sous_total+tva);
		return CommandeRepository.save(c) ;
	}
	
	public List<Commande> allProducts(){
		return CommandeRepository.findAll();
	}

	public Commande getCommandebyId(Long id ){
		return CommandeRepository.findById(id).orElse(null);
	}
	
	public String deleteCommandeById(Long id ){
		
		 CommandeRepository.deleteById(id);
		 return "Commande deleted" +id ;
	}
	
	public Commande updateCommande(Commande C) {
		Commande com = CommandeRepository.findById(C.getId()).orElse(null);
		com.setEtat(C.getEtat());
		com.setTauxLivraison(C.getTauxLivraison());
		com.setDateCommande(C.getDateCommande());
		com.setDateLivraison(C.getDateLivraison());
		com.setSousTotal(C.getSousTotal());
		com.setTVA(C.getTVA());
		com.setUser(C.getUser());
		com.setStatus(C.getStatus());
		com.setPanier(C.getPanier());
		com.setTotal(C.getTotal());
		com.setMoyenPaiement(C.getMoyenPaiement());
		return CommandeRepository.save(com);
	}
}
