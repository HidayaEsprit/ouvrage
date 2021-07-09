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
import com.pidev.ouvrage.services.CommandeServices;


@RestController
public class CommandeController {

	@Autowired
	CommandeServices commandeServices;
	
	@GetMapping("/allCommande")
	public List<Commande> getAllCommande(){
		return commandeServices.allProducts();
	}
	
	@PostMapping("/addCommande")
	public Commande addCommande(@RequestBody Commande c){
		return commandeServices.saveCommande(c);
	}
	
	@GetMapping("/commande/{id}")
	public Commande getCommandebyId(@PathVariable Long id){
		return commandeServices.getCommandebyId(id);
	}
	
	@DeleteMapping("/commande/{id}")
	public String deleteCommandeById(@PathVariable Long id){
		return commandeServices.deleteCommandeById(id);
	}
	
	// @PutMapping("/commande/{id}")
	// public Commande updateCommande(@RequestBody Commande c){
	// 	return commandeServices.updateCommande(c);
	// }
}
