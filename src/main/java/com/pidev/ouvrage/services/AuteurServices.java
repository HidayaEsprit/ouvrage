package com.pidev.ouvrage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.ouvrage.model.Auteur;
import com.pidev.ouvrage.model.Categorie;
import com.pidev.ouvrage.repository.AuteurRepository;


@Service
public class AuteurServices {

	@Autowired
	AuteurRepository auteurRepository;
	
	public Auteur saveAuteur (Auteur a){
		return auteurRepository.save(a) ;
	}
	
	public List<Auteur> allAuts(){
		return auteurRepository.findAll();
	}
	
	public Auteur getAuteurbyId(Long id ){
		return auteurRepository.findById(id).orElse(null);
	}
	
	public String deleteAuteurById(Long id ){
		
		 auteurRepository.deleteById(id);
		 return "Auteur deleted" +id ;
	}
	
public Auteur updateAuteur(Auteur A, long id) {
		
       	A.setIdAut(id);
	
	 	return auteurRepository.save(A);
}
}
