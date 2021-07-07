package com.pidev.ouvrage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pidev.ouvrage.model.Dislike;

@Repository
public interface DislikeRepository extends JpaRepository<Dislike, Long>{

}
