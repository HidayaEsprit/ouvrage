package com.pidev.ouvrage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pidev.ouvrage.model.Commande;
import com.pidev.ouvrage.model.Auteur;
import com.pidev.ouvrage.model.Categorie;
import com.pidev.ouvrage.services.AuteurServices;


@RestController
public class AuteurController {

	@Autowired
	AuteurServices auteurServices;
	
	@GetMapping("/aut")
	@PreAuthorize("hasRole('ADMIN')")
	public List<Auteur> getAllAuteur(){
		return auteurServices.allAuts();
	}
	
	
	
	@PostMapping("/aut")
	
	@PreAuthorize("hasRole('ADMIN')")
	public Auteur addAuteur(@RequestBody Auteur a){
		return auteurServices.saveAuteur(a);
	}
	
	@GetMapping("/aut/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public Auteur getAuteurbyId(@PathVariable Long id){
		return auteurServices.getAuteurbyId(id);
	}
	
	@DeleteMapping("/aut/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteAuteurById(@PathVariable Long id){
		return auteurServices.deleteAuteurById(id);
	}
	
	@PutMapping("/aut/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public Auteur updateAuteur(@RequestBody Auteur a, @PathVariable long id){
		return auteurServices.updateAuteur(a, id);
	 }
}
