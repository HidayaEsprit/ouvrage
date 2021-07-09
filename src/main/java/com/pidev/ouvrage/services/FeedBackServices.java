package com.pidev.ouvrage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.ouvrage.model.Feedback;
import com.pidev.ouvrage.repository.FeedBackRepository;


@Service
public class FeedBackServices {

	@Autowired
	FeedBackRepository feedBackRepository;
	
	public Feedback saveFeedback (Feedback f){
		return feedBackRepository.save(f) ;
	}
	
	public List<Feedback> allProducts(){
		return feedBackRepository.findAll();
	}
	
	public Feedback getFeedBackbyId(Long id ){
		return feedBackRepository.findById(id).orElse(null);
	}
	
	public String deleteFeedbackById(Long id ){
		
		 feedBackRepository.deleteById(id);
		 return "feedback deleted" +id ;
	}
	
	public Feedback updateFeedback(Feedback f) {
		Feedback fu = feedBackRepository.findById(f.getId()).orElse(null);
		fu.setNomCom(f.getNomCom());
		fu.setDateCom(f.getDateCom());
		return feedBackRepository.save(fu);
	}
}
