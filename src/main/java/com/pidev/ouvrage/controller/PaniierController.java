package com.pidev.ouvrage.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pidev.ouvrage.model.DAOUser;
import com.pidev.ouvrage.model.Ouvrage;
import com.pidev.ouvrage.model.OuvrageUser;
import com.pidev.ouvrage.model.Panier;
import com.pidev.ouvrage.services.CategorieServices;
import com.pidev.ouvrage.services.OuvrageServices;
import com.pidev.ouvrage.services.OuvrageUserServices;
import com.pidev.ouvrage.services.PanierServices;
import com.pidev.ouvrage.services.UserServices;

@RestController
public class PaniierController {
	@Autowired
	OuvrageServices ouvrageServices;
	@Autowired
	UserServices userServices;
	@Autowired
	PanierServices panierServices;
	@Autowired
	OuvrageUserServices ouvrageUserService;
	
	@PostMapping("/addOuvrageToPanier")
	public Object addOuvrageTopanier(@RequestBody  HashMap<String, Integer> body){
		HashMap<String, String> msg = new HashMap<>();
		
	//	return paniers;
		if(body.get("ouvrage_id")==null || body.get("user_id")==null || body.get("quantite")==null )
	    {
	    	  
	    	    msg.put("msg", "error : RequestBody");
	    	    return msg ;
	    }
		Ouvrage ouvrage =ouvrageServices.getOuvragebyId(Long.valueOf(body.get("ouvrage_id")));
		//System.out.println(ouvrage);
				
		DAOUser user =userServices.getUserbyId(Long.valueOf(body.get("user_id")));
		if (user == null)
		{
			msg.put("msg", "error : user not found");
    	    return msg ;	
		}
		if (ouvrage == null)
		{
			msg.put("msg", "error : ouvrage not found");
    	    return msg ;	
		}
		if(body.get("quantite")<0 || body.get("quantite")>ouvrage.getQteStock())
		{
			msg.put("msg", "error : invalid quantity");
    	    return msg ;
		}
		
		List<Panier> paniers = panierServices.getPanierbyUser(Long.valueOf(body.get("user_id")),false);
		//return paniers;
		Panier panier;
		Set<OuvrageUser> ouvrageUsers = new HashSet<>();

		boolean newPanier=false;
		boolean newOuvrage=true;
		if(!paniers.isEmpty())
		{
			
		 panier= paniers.get(0);
			
		}
		else 
		{
			newPanier=true;
		 panier= new Panier( user, null);
			panier=panierServices.savePanier(panier);
			
		}
		long x=0;
	    if(panier.getOuvrageUsers() != null)
	    {
			for (OuvrageUser ouvrageU :panier.getOuvrageUsers()) {
				if (ouvrageU.getOuvrage().getId()==Long.valueOf(body.get("ouvrage_id")))
				{
					newOuvrage=false;
					
					x=ouvrageU.getQuantite();
				}
			}
	    }
		
		ouvrage.setQteStock(ouvrage.getQteStock()-body.get("quantite"));
		Ouvrage ouvrageUpdated =ouvrageServices.updateOuvrage(ouvrage,ouvrage.getId());
		OuvrageUser ouvrageUser = new OuvrageUser(user, ouvrage,body.get("quantite")+x,panier);
		
		ouvrageUserService.saveouvrageUser(ouvrageUser);
		
		float s= (float) ouvrage.getPrix()*body.get("quantite");
		panier.setPrix(panier.getPrix()+s);
		panierServices.updatePanier(panier);
				
		msg.put("msg", "msg : succes");
		
		
		if(newPanier)
		{
			ouvrageUsers.add(ouvrageUser);
			panier.setOuvrageUsers(ouvrageUsers);
		}
		else if(newOuvrage)
		{
			panier.getOuvrageUsers().add(ouvrageUser);
		}
	    return panier;
		
	}
	
	
	
	
	
	@PostMapping("/payer")
	public Object payerPanier (@RequestBody  HashMap<String, Long> body){
		HashMap<String, String> msg = new HashMap<>();
		if(body.get("id")==null)
		{
			 msg.put("msg", "error : id not found ");
			  return msg ;
			
		}
		Panier panier = panierServices.getPanierbyId(body.get("id"));
		
		
		if(panier!=null)
		{
			if(panier.getPaiment())
			{
				 msg.put("msg", "error : already paid");
				  return msg ;
				
			}
			
			
		 panier.setPaiment(true);
		 panierServices.updatePanier(panier);
		 msg.put("msg", "succes : panier payed");
		  return msg ;
			
		}
		else 
		{
			msg.put("msg", "error : panier not found");
			  return msg ;
			
		}
		

		
	}
	
	
	@GetMapping("/paniers/{id}")
	public Object paniers (@PathVariable Long id){
		
		DAOUser user = userServices.getUserbyId(id);
		
		
		if(user!=null)
		{
			
				  return user.getPaniers() ;
				
		}
		
		return "erreur";

		
	}
	
	
	@GetMapping("/annulerPanier/{id}")
	public Object annulerPanier (@PathVariable Long id){
		
		Panier panier = panierServices.getPanierbyId(id);
		System.out.println(id);
		
		if(panier!=null)
		{
			     if(panier.getPaiment())
			     {
			    	 return "panier deja payé ";
			     }
			
				 for (OuvrageUser ouvrageUser : panier.getOuvrageUsers()) {
					Ouvrage ouvrage =ouvrageUser.getOuvrage();
					ouvrage.setQteStock((int) (ouvrage.getQteStock()+ouvrageUser.getQuantite()));
					ouvrageServices.updateOuvrage(ouvrage, ouvrage.getId());
					
				}
				 panierServices.deletePanierById(id);
				 return "panier annuler";
				
		}
		
		return "erreur";

		
	}
	}


