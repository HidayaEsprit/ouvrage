package com.pidev.ouvrage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pidev.ouvrage.model.DAOUser;
import com.pidev.ouvrage.model.Likes;
@Repository
public interface LikesRepository extends JpaRepository<Likes, Long>{


	
}
