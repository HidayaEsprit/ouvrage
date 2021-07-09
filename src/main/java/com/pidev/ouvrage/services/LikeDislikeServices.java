package com.pidev.ouvrage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.ouvrage.model.DAOUser;
import com.pidev.ouvrage.model.Dislike;
import com.pidev.ouvrage.model.Feedback;
import com.pidev.ouvrage.model.Likes;
import com.pidev.ouvrage.repository.DislikeRepository;
import com.pidev.ouvrage.repository.LikesRepository;
import com.pidev.ouvrage.repository.UserRepository;

@Service
public class LikeDislikeServices {
	@Autowired
	LikesRepository likesRepository;
	@Autowired
    DislikeRepository dislikeRepository;
	
	@Autowired
	
	UserRepository userRepo;
	
	public Likes saveLikes (Likes f){
          return   likesRepository.save(f);
	}
	
	public String deleteLikesId(Long id ){
		
		likesRepository.deleteById(id);
		 return "Likes  deleted" +id ;
	}
	
	public DislikeRepository savedisLikes (Dislike f){
        return   (DislikeRepository) dislikeRepository.save(f);
	}
	
	public String deleteDisLikesId(Long id ){
		
		likesRepository.deleteById(id);
		 return "Likes  deleted" +id ;
	}
	public List<Likes> allLikes(){
		return likesRepository.findAll();
	}
	
	
	
}
