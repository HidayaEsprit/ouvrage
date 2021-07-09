package com.pidev.ouvrage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.ouvrage.model.Commande;
import com.pidev.ouvrage.repository.CommandeRepository;


@Service
public class CommandeServices {

	@Autowired
	CommandeRepository CommandeRepository;
	
	public Commande saveCommande (Commande f){
		return CommandeRepository.save(f) ;
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
	
	// public Commande updateCommande(Commande C) {
	// 	Commande com = CommandeRepository.findById(C.getId()).orElse(null);
	// 	com.setEtatCommande(C.getEtatCommande());
	// 	com.setTotal(C.getTotal());
	// 	return CommandeRepository.save(com);
	// }
}
