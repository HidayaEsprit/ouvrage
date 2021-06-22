package com.pidev.ouvrage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.ouvrage.model.Ouvrage;

import com.pidev.ouvrage.repository.OuvrageRepository;


@Service
public class OuvrageServices {

	@Autowired
	OuvrageRepository ouvrageRepository;
	
	public Ouvrage saveOuvrage (Ouvrage o){
		return ouvrageRepository.save(o) ;
	}
	
	public List<Ouvrage> allProducts(){
		return ouvrageRepository.findAll();
	}
	
	public Ouvrage getOuvragebyId(Long id ){
		return ouvrageRepository.findById(id).orElse(null);
	}
	
	public String deleteOuvrageById(Long id ){
		
		 ouvrageRepository.deleteById(id);
		 return "Ouvrage deleted" +id ;
	}
	
	// public Ouvrage updateOuvrage(Ouvrage C) {
	// 	Ouvrage com = ouvrageRepository.findById(C.getId()).orElse(null);
	// 	com.setEtatOuvrage(C.getEtatOuvrage());
	// 	com.setTotal(C.getTotal());
	// 	return ouvrageRepository.save(com);
	// }
}
