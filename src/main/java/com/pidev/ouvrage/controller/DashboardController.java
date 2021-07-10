
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
import com.pidev.ouvrage.model.Ouvrage;
import com.pidev.ouvrage.services.CommandeServices;
import com.pidev.ouvrage.services.DashboardServices;
import com.pidev.ouvrage.services.dto.DTODashboard;


@RestController
public class DashboardController {

	@Autowired
	DashboardServices dashboardServices;
	
    @GetMapping("/dashboard")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public DTODashboard getDashboard(){
		return dashboardServices.getDashboard();
    }
    

}
