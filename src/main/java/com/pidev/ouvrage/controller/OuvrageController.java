package com.pidev.ouvrage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.pidev.ouvrage.exceptions.ResourceNotFoundException;



import com.pidev.ouvrage.model.Ouvrage;
import com.pidev.ouvrage.repository.OuvrageRepository;
import com.pidev.ouvrage.services.OuvrageServices;


@RestController
public class OuvrageController {

	@Autowired
	OuvrageServices ouvrageServices;
	
	@Autowired
	OuvrageRepository ouvrageRepository;
	
	@GetMapping("/ouvrage")
	@PreAuthorize("hasRole('USER') OR hasRole('ADMIN')")
	public List<Ouvrage> getAllOuvrage(){
		return ouvrageServices.allProducts();
	}
	
	@PostMapping("/ouvrage")
	@PreAuthorize("hasRole('USER') OR hasRole('ADMIN')")
	public Ouvrage addOuvrage(@RequestBody Ouvrage o){
		return ouvrageServices.saveOuvrage(o);
	}
	
	@GetMapping("/ouvrage/{id}")
	@PreAuthorize("hasRole('USER') OR hasRole('ADMIN')")
	public Ouvrage getOuvragebyId(@PathVariable Long id){
		return ouvrageServices.getOuvragebyId(id);
	}
	
	
	
	/*//DeleteOuvrage
	@DeleteMapping("/ouvrage/{id}")
		public Map<String, Boolean> deleteOuvrage(@PathVariable(value = "id") Long ouvId)
				throws ResourceNotFoundException {
			Ouvrage ouv = ouvrageRepository.findById(ouvId)
					.orElseThrow(() -> new ResourceNotFoundException("ouvrage not found for this id :: " + ouvId));

			ouvrageRepository.delete(ouv);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
		}*/
	
	
	 @DeleteMapping("/ouvrage/{id}")
	 @PreAuthorize("hasRole('USER') OR hasRole('ADMIN')")
	public String deleteOuvrage(@PathVariable Long id){
		return ouvrageServices.deleteOuvrageById(id);
	}  
	
	
	
	
	@PutMapping("/ouvrage/{id}")
	@PreAuthorize("hasRole('USER') OR hasRole('ADMIN')")
		public Ouvrage updateOuvrage(@RequestBody Ouvrage o, @PathVariable long id){
			return ouvrageServices.updateOuvrage(o, id);
		 }
	
	
	
	
}
