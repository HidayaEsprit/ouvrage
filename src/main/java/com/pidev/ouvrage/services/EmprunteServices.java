package com.pidev.ouvrage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.ouvrage.model.Emprunte;
import com.pidev.ouvrage.model.Feedback;
import com.pidev.ouvrage.repository.EmprunteRepository;

@Service
public class EmprunteServices {

	@Autowired
	EmprunteRepository emprunteRepository;
	
	public Emprunte saveEmprunte (Emprunte e){
		return emprunteRepository.save(e) ;
	}
	
	public List<Emprunte> allEmpruntes(){
		return emprunteRepository.findAll();
	}
	
	public Emprunte getEmpruntebyId(Long id ){
		return emprunteRepository.findById(id).orElse(null);
	}
	
	public String deleteEmprunteById(Long id ){
		
		emprunteRepository.deleteById(id);
		 return "Emprunte deleted" +id ;
	}
	
	public Emprunte updateEmprunte(Emprunte f) {
		Emprunte fu = emprunteRepository.findById(f.getId()).orElse(null);
	    fu.setDateDeb(f.getDateFin());
		fu.setDateFin(f.getDateFin());
		return emprunteRepository.save(fu);
	}
}
