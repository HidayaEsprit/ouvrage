package com.pidev.ouvrage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pidev.ouvrage.model.Panier;

public interface PanierRepository extends JpaRepository<Panier, Long>{
	List<Panier> findByUserIdAndPaiment (Long id,boolean paiment );


}

