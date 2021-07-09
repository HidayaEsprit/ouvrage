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
import org.springframework.web.bind.annotation.RestController;

import com.pidev.ouvrage.model.DAOUser;
import com.pidev.ouvrage.model.Feedback;
import com.pidev.ouvrage.model.WishList;
import com.pidev.ouvrage.repository.UserRepository;
import com.pidev.ouvrage.services.WishListServices;

@RestController
public class WishListController {

	@Autowired
	WishListServices wishListServices;
	@Autowired
	UserRepository userRepo ;
	
	@GetMapping("/allLists")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')or hasRole('AUTEUR')")
	public List<WishList> getAllFeed(){
		return wishListServices.allLists();
	}
	
	@PostMapping("/addWishList")
	@PreAuthorize("hasRole('USER')")
	public WishList addFeedback(@RequestBody WishList f){
		Optional<DAOUser> u = userRepo.findById(f.getUser().getId());
		f.setUser(u.get());
		return wishListServices.saveList(f);
	}
	
	@GetMapping("/wishlist/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public WishList WishListById(@PathVariable Long id){
		return wishListServices.getWishListbyId(id);
	}
	
	@DeleteMapping("/wishlist/{id}")
	@PreAuthorize("hasRole('USER')")
	public String deleteWishList(@PathVariable Long id){
		return wishListServices.deleteWishListById(id);
	}
	
	@PutMapping("/wishlist/{id}")
	@PreAuthorize("hasRole('USER')")
	public WishList WishList(@RequestBody WishList f , @PathVariable Long id){
		f.setId(id);
	
		return wishListServices.updateWishList(f);
	}
}
