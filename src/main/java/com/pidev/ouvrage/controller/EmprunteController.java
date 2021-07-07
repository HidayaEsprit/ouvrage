package com.pidev.ouvrage.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pidev.ouvrage.model.DAOUser;
import com.pidev.ouvrage.model.Emprunte;
import com.pidev.ouvrage.model.Feedback;
import com.pidev.ouvrage.model.Ouvrage;
import com.pidev.ouvrage.repository.OuvrageRepository;
import com.pidev.ouvrage.repository.UserRepository;
import com.pidev.ouvrage.services.EmprunteServices;

@RestController
public class EmprunteController {
	@Autowired
	UserRepository userRepo ;
	@Autowired
	OuvrageRepository ouvrageRepo;
	@Autowired
	EmprunteServices emprunteServices ;
	
	@GetMapping("/allEmprunte")
	public List<Emprunte> getAllEmprunte(){
		return emprunteServices.allEmpruntes();
	}
	
	@GetMapping("/emprunte/{id}")
	public Emprunte EmprunteById(@PathVariable Long id){
		return emprunteServices.getEmpruntebyId(id);
	}
	
	@DeleteMapping("/emprunte/{id}")
	public String deleteEmprunte(@PathVariable Long id){
		return emprunteServices.deleteEmprunteById(id);
	}
	@PostMapping("/addEmprunte")
	public Emprunte addEmprunte(@RequestBody Emprunte e){
		e.setDateDeb(new Date());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("Current Date " + dateFormat.format(e.getDateDeb()));
		Calendar c = Calendar.getInstance();
        c.setTime(e.getDateDeb());  
       c.add(Calendar.DATE, e.getDuree());
        Date currentDatePlus = c.getTime();
  
        e.setDateFin(currentDatePlus);
	Optional<DAOUser> u = userRepo.findById(e.getUser().getId());
e.setUser(u.get());

    Optional<Ouvrage> o =  ouvrageRepo.findById(e.getOuvrage().getId());
    e.setOuvrage(o.get()); 

		return emprunteServices.saveEmprunte(e);

	}
	
	@PutMapping("/emprunte/{id}")
	public Emprunte updateEmprunte(@RequestBody Emprunte f , @PathVariable Long id){
		f.setId(id);
		f.setDateDeb(new Date());
		
		return emprunteServices.updateEmprunte(f);
	}
}
