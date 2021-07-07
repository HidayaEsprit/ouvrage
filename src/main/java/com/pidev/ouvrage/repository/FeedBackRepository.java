package com.pidev.ouvrage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pidev.ouvrage.model.Feedback;

public interface FeedBackRepository extends JpaRepository<Feedback, Long>{
	
	
	// Jpa Repository textendi pour --> Save (ajout), FindById , FindAll , DeleteById ... In progress (prédéfinis)

}
