package com.pidev.ouvrage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pidev.ouvrage.model.Commande;
import com.pidev.ouvrage.model.Ouvrage;
import com.pidev.ouvrage.services.OuvrageServices;


@RestController
public class OuvrageController {

	@Autowired
	OuvrageServices ouvrageServices;
	
	@GetMapping("/ouvrage")
	public List<Ouvrage> getAllOuvrage(){
		return ouvrageServices.allProducts();
	}
	
	@PostMapping("/ouvrage")
	public Ouvrage addOuvrage(@RequestBody Ouvrage o){
		return ouvrageServices.saveOuvrage(o);
	}
	
	@GetMapping("/ouvrage/{id}")
	public Ouvrage getOuvragebyId(@PathVariable Long id){
		return ouvrageServices.getOuvragebyId(id);
	}
	
	@DeleteMapping("/ouvrage/{id}")
	public String deleteOuvrageById(@PathVariable Long id){
		return ouvrageServices.deleteOuvrageById(id);
	}
	
	// @PutMapping("/ouvrage/{id}")
	// public Ouvrage updateOuvrage(@RequestBody ouvrage o){
	// 	return ouvrageServices.updateOuvrage(o);
	// }
}
