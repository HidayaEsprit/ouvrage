package com.pidev.ouvrage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.pidev.ouvrage.model.DAOUser;

@Repository
public interface UserRepository extends JpaRepository<DAOUser, Long> {
	Optional<DAOUser> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

	@Query("SELECT max(user) FROM Likes")
	DAOUser getMaxLikes();
}
