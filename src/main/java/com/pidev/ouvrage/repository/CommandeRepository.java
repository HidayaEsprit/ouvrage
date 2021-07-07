package com.pidev.ouvrage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pidev.ouvrage.model.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long>{
	


}
