package com.pidev.ouvrage.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pidev.ouvrage.model.DAOUser;
import com.pidev.ouvrage.model.Feedback;
import com.pidev.ouvrage.repository.UserRepository;
import com.pidev.ouvrage.services.FeedBackServices;


@RestController

public class FeedbackController {

	@Autowired
	FeedBackServices feedBackServices;
	@Autowired
	UserRepository userRepo ;
	
	@GetMapping("/all")
	public List<Feedback> getAllFeed(){
		return feedBackServices.allProducts();
	}
	
	@PostMapping("/addFeedback")
	public Feedback addFeedback(@RequestBody Feedback f){
		f.setDateCom(new Date());
	Optional<DAOUser> u = userRepo.findById(f.getUser().getId());
f.setUser(u.get());
		return feedBackServices.saveFeedback(f);
	}
	
	@GetMapping("/feedback/{id}")
	public Feedback feedbackById(@PathVariable Long id){
		return feedBackServices.getFeedBackbyId(id);
	}
	
	@DeleteMapping("/feedback/{id}")
	public String deleteFeedback(@PathVariable Long id){
		return feedBackServices.deleteFeedbackById(id);
	}
	
	@PutMapping("/feedback/{id}")
	public Feedback updateFeedback(@RequestBody Feedback f , @PathVariable Long id){
		f.setId(id);
		f.setDateCom(new Date());
		return feedBackServices.updateFeedback(f);
	}
}
