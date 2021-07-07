package com.pidev.ouvrage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pidev.ouvrage.model.DAOUser;


@Repository
public interface UserRepository extends JpaRepository<DAOUser, Long> {
	DAOUser findByUsername(String username);
	@Query("SELECT max(user) FROM Likes")
	DAOUser getMaxLikes();

}