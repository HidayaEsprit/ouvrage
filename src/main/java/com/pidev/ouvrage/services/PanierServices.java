package com.pidev.ouvrage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.ouvrage.model.Panier;
import com.pidev.ouvrage.repository.PanierRepository;


@Service
public class PanierServices {

	@Autowired
	PanierRepository panierRepository;
	
	public Panier savePanier (Panier f){
		return panierRepository.save(f) ;
	}
	
	public List<Panier> allProducts(){
		return panierRepository.findAll();
	}
	
	public Panier getPanierbyId(Long id ){
		return panierRepository.findById(id).orElse(null);
	}
	public List<Panier> getPanierbyUser(Long id, boolean paiment ){
		return panierRepository.findByUserIdAndPaiment(id,paiment);
	}
	
	public String deletePanierById(Long id ){
		
		 panierRepository.deleteById(id);
		 return "Panier deleted" +id ;
	}
	
	 public Panier updatePanier(Panier c) {
	 	
	 	return panierRepository.save(c);
	 }
}
