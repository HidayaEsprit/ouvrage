package com.pidev.ouvrage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.ouvrage.model.DAOUser;
import com.pidev.ouvrage.repository.UserRepository;


@Service
public class UserServices {
	@Autowired
	UserRepository userRepository;
	public DAOUser getUserbyId(Long id ){
		return userRepository.findById(id).orElse(null);
	}

}
