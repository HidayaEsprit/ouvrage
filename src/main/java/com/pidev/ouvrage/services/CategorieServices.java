package com.pidev.ouvrage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.ouvrage.model.Categorie;

import com.pidev.ouvrage.repository.CategorieRepository;


@Service
public class CategorieServices {

	@Autowired
	CategorieRepository categorieRepository;
	
	public Categorie saveCategorie (Categorie c){
		return categorieRepository.save(c) ;
	}
	
	public List<Categorie> allCats(){
		return categorieRepository.findAll();
	}
	
	public Categorie getCategoriebyId(Long id ){
		return categorieRepository.findById(id).orElse(null);
	}
	
	public String deleteCategorieById(Long id ){
		
		 categorieRepository.deleteById(id);
		 return "Categorie deleted" +id ;
	}
	
	// public Ouvrage updateOuvrage(Ouvrage C) {
	// 	Ouvrage com = ouvrageRepository.findById(C.getId()).orElse(null);
	// 	com.setEtatOuvrage(C.getEtatOuvrage());
	// 	com.setTotal(C.getTotal());
	// 	return ouvrageRepository.save(com);
	// }
}
