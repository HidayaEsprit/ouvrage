package com.pidev.ouvrage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.ouvrage.model.OuvrageUser;
import com.pidev.ouvrage.model.Panier;
import com.pidev.ouvrage.repository.OuvrageUserRepository;

@Service
public class OuvrageUserServices {
	@Autowired
	OuvrageUserRepository ouvrageUserRepository;
	public OuvrageUser saveouvrageUser (OuvrageUser o){
		return ouvrageUserRepository.save(o) ;
	}
	
	public List<OuvrageUser> findByIdUserAndIdOuvrage (Long idUser,Long idOuvrage ){
		return ouvrageUserRepository.findByUserIdAndOuvrageId(idUser, idOuvrage) ;
	}
	

}
