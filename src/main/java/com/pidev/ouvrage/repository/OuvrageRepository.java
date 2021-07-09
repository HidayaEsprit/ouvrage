
package com.pidev.ouvrage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pidev.ouvrage.model.Ouvrage;

@Repository
public interface OuvrageRepository extends JpaRepository<Ouvrage, Long>{
	


}
