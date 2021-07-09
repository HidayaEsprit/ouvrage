package com.pidev.ouvrage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pidev.ouvrage.model.Emprunte;



public interface EmprunteRepository extends JpaRepository<Emprunte, Long>{

}
