package com.pidev.ouvrage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pidev.ouvrage.model.OuvrageUser;
import com.pidev.ouvrage.model.Panier;
import com.pidev.ouvrage.model.UserOuvrageId;

public interface OuvrageUserRepository extends JpaRepository<OuvrageUser, UserOuvrageId>{
	List<OuvrageUser> findByUserIdAndOuvrageId (Long idUser,Long idOuvrage );


}
