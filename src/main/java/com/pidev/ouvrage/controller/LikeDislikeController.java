package com.pidev.ouvrage.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pidev.ouvrage.model.DAOUser;
import com.pidev.ouvrage.model.Dislike;
import com.pidev.ouvrage.model.Feedback;
import com.pidev.ouvrage.model.Likes;
import com.pidev.ouvrage.model.maxiLikes;
import com.pidev.ouvrage.repository.FeedBackRepository;
import com.pidev.ouvrage.repository.UserRepository;
import com.pidev.ouvrage.services.LikeDislikeServices;
import com.pidev.ouvrage.services.SendMailService;



@RestController
public class LikeDislikeController {
	@Autowired
	LikeDislikeServices likeDislikeServices;
	@Autowired
	UserRepository userRepo ;
	@Autowired
	FeedBackRepository feedBackRepository ;
	@Autowired
	private SendMailService sendMailSerivce;
	
	@PostMapping("/addLike")
	public Likes addLike(@RequestBody Likes f){
	
	Optional<DAOUser> u = userRepo.findById(f.getUser().getId());
f.setUser(u.get());
Optional<Feedback> fe = feedBackRepository.findById(f.getFeedback().getId());
f.setFeedback(fe.get());
		return likeDislikeServices.saveLikes(f);
	}
	
	@PostMapping("/addDisLike")
	public Likes Dislike(@RequestBody Dislike f){
	
	Optional<DAOUser> u = userRepo.findById(f.getUser().getId());
f.setUser(u.get());
		return (Likes) likeDislikeServices.savedisLikes(f);
	}
	
	@DeleteMapping("/likes/{id}")
	public String deleteLikes(@PathVariable Long id){
		return likeDislikeServices.deleteLikesId(id);
	}
	
	@DeleteMapping("/Dislikes/{id}")
	public String deleteDisLikes(@PathVariable Long id){
		return likeDislikeServices.deleteDisLikesId(id);
	}
	
	public  int getCount(List<Long> l,int n){
		int  max = 0 ;
		for (int i=0;i<l.size();i++){
			if(l.get(i)==n){
				max++;
			}
		}
		return max;
	}
	
	@GetMapping("/maxLikes")
	public Optional<DAOUser>  maxLikes(){
		List<Long>tabs = new ArrayList<>()  ;
		List<Likes> l = likeDislikeServices.allLikes();
		for(int i=0; i<l.size();i++){
	             System.out.println("a");
			tabs.add(l.get(i).getUser().getId());
		}
		List<maxiLikes>tabM=new ArrayList<>();
		
		for (int i=0;i<tabs.size();i++){
			tabM.add(new maxiLikes(tabs.get(i).intValue(), getCount(tabs, tabs.get(i).intValue())));
		}
		int maxU=0;
		int IdU=0;
		for(int i=0;i<tabM.size();i++){
			if(tabM.get(i).getMax()>maxU){
				maxU=tabM.get(i).getMax();
				IdU=tabM.get(i).getIdU();
			}
		}
		Optional<DAOUser> us=  userRepo.findById(new Long(IdU));
		sendMailSerivce.sendEmail(us.get().getEmail(), "Bonjour Mr/Mme "+us.get().getUsername()+",Vous avez une offre spéciale ", "Offre Spéciale");
		return us;
	}
	
}
