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
import com.pidev.ouvrage.model.Ouvrage;
import com.pidev.ouvrage.model.Categorie;
import com.pidev.ouvrage.services.CategorieServices;


@RestController
public class CategorieController {

	@Autowired
	CategorieServices categorieServices;
	
	@GetMapping("/cat")
	@PreAuthorize("hasRole('ADMIN')")
	public List<Categorie> getAllCategorie(){
		return categorieServices.allCats();
	}
	
	@PostMapping("/cat")
	@PreAuthorize("hasRole('ADMIN')")
	public Categorie addCategorie(@RequestBody Categorie c){
		return categorieServices.saveCategorie(c);
	}
	
	@GetMapping("/cat/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public Categorie getCategoriebyId(@PathVariable Long id){
		return categorieServices.getCategoriebyId(id);
	}
	
	@DeleteMapping("/cat/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteCategorieById(@PathVariable Long id){
		return categorieServices.deleteCategorieById(id);
	}
	
	@PutMapping("/cat/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public Categorie updateCategorie(@RequestBody Categorie c, @PathVariable long id){
		return categorieServices.updateCategorie(c, id);
	 }
}
