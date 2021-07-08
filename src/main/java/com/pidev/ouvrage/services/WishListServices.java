package com.pidev.ouvrage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.ouvrage.model.Feedback;
import com.pidev.ouvrage.model.WishList;
import com.pidev.ouvrage.repository.WishListRepository;

@Service
public class WishListServices {
	@Autowired
	WishListRepository wishListRepository;
	
	public WishList saveList (WishList f){
		return wishListRepository.save(f) ;
	}
	
	public List<WishList> allLists(){
		return wishListRepository.findAll();
	}
	
	public WishList getWishListbyId(Long id ){
		return wishListRepository.findById(id).orElse(null);
	}
	
	public String deleteWishListById(Long id ){
		
		wishListRepository.deleteById(id);
		 return "wishList deleted" +id ;
	}
	
	public WishList updateWishList(WishList f) {
		WishList fu = wishListRepository.findById(f.getId()).orElse(null);
		fu.setImage(f.getImage());
		fu.setAuteur(f.getAuteur());
		fu.setDisponiblite(f.getDisponiblite());
		fu.setTitre(f.getTitre());
		return wishListRepository.save(fu);
	}
}
