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
import com.pidev.ouvrage.model.Categorie;
import com.pidev.ouvrage.services.CategorieServices;


@RestController
public class CategorieController {

	@Autowired
	CategorieServices categorieServices;
	
	@GetMapping("/cat")
	public List<Categorie> getAllCategorie(){
		return categorieServices.allCats();
	}
	
	@PostMapping("/cat")
	public Categorie addCategorie(@RequestBody Categorie c){
		return categorieServices.saveCategorie(c);
	}
	
	@GetMapping("/cat/{id}")
	public Categorie getCategoriebyId(@PathVariable Long id){
		return categorieServices.getCategoriebyId(id);
	}
	
	@DeleteMapping("/cat/{id}")
	public String deleteCategorieById(@PathVariable Long id){
		return categorieServices.deleteCategorieById(id);
	}
	
	// @PutMapping("/ouvrage/{id}")
	// public Ouvrage updateOuvrage(@RequestBody ouvrage o){
	// 	return ouvrageServices.updateOuvrage(o);
	// }
}
