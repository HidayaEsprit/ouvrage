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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pidev.ouvrage.model.Commande;
import com.pidev.ouvrage.model.DAOUser;
import com.pidev.ouvrage.services.CommandeServices;


@RestController
public class CommandeController {

	@Autowired
	CommandeServices commandeServices;
	
	@GetMapping("/commande")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<Commande> getAllCommande(){
		return commandeServices.allProducts();
	}

	@PostMapping("/commande")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Commande addCommande(@RequestBody Commande c){
		return commandeServices.save(c);
	}
	
	@GetMapping("/commande/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Commande getCommandebyId(@PathVariable Long id){
		return commandeServices.getCommandebyId(id);
	}
	
	@DeleteMapping("/commande/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public String deleteCommandeById(@PathVariable Long id){
		return commandeServices.deleteCommandeById(id);
	}
	
	@PutMapping("/commande/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Commande updateCommande(@RequestBody Commande c){
		return commandeServices.updateCommande(c);
	}
}
