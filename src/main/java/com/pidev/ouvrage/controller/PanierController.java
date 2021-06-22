package com.pidev.ouvrage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pidev.ouvrage.model.Panier;
import com.pidev.ouvrage.services.PanierServices;


@RestController
public class PanierController {

	@Autowired
	PanierServices panierServices;
	
	@GetMapping("/allpanier")
	public List<Panier> getAllPanier(){
		return panierServices.allProducts();
	}
	
	@PostMapping("/addpanier")
	public Panier addpanier(@RequestBody Panier p){
		return panierServices.savePanier(p);
	}
	
	@GetMapping("/panier/{id}")
	public Panier getpanierbyId(@PathVariable Long id){
		return panierServices.getPanierbyId(id);
	}
	
	@DeleteMapping("/panier/{id}")
	public String deletepanierById(@PathVariable Long id){
		return panierServices.deletePanierById(id);
	}
	
	// @PutMapping("/panier/{id}")
	// public panier updatepanier(@RequestBody panier p){
	// 	return panierServices.updatepanier(p);
	// }
}
