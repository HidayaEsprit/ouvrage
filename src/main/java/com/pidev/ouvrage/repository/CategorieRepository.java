package com.pidev.ouvrage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pidev.ouvrage.model.Categorie;


@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {

}
