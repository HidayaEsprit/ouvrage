package com.pidev.ouvrage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pidev.ouvrage.model.Commande;
import com.pidev.ouvrage.model.Auteur;
import com.pidev.ouvrage.services.AuteurServices;


@RestController
public class AuteurController {

	@Autowired
	AuteurServices auteurServices;
	
	@GetMapping("/aut")
	public List<Auteur> getAllAuteur(){
		return auteurServices.allAuts();
	}
	
	@PostMapping("/aut")
	public Auteur addAuteur(@RequestBody Auteur a){
		return auteurServices.saveAuteur(a);
	}
	
	@GetMapping("/aut/{id}")
	public Auteur getAuteurbyId(@PathVariable Long id){
		return auteurServices.getAuteurbyId(id);
	}
	
	@DeleteMapping("/aut/{id}")
	public String deleteAuteurById(@PathVariable Long id){
		return auteurServices.deleteAuteurById(id);
	}
	
	// @PutMapping("/ouvrage/{id}")
	// public Ouvrage updateOuvrage(@RequestBody ouvrage o){
	// 	return ouvrageServices.updateOuvrage(o);
	// }
}
