package com.pidev.ouvrage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pidev.ouvrage.model.Auteur;


@Repository
public interface AuteurRepository extends JpaRepository<Auteur, Long> {

}
