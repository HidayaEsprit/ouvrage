package com.pidev.ouvrage.repository;

import java.util.ArrayList;

import com.pidev.ouvrage.model.DAOUser;
import com.pidev.ouvrage.model.Ouvrage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DashboardRepository extends JpaRepository<Ouvrage, Long>{


    @Query("select COUNT(*) FROM Commande commande LEFT JOIN DAOUser daoUser ON (commande.user = daoUser.id ) WHERE (commande.user= :user) AND (MONTH(commande.dateCommande) = MONTH(current_timestamp))")
    Integer findCommandeByUserAndMois(@Param("user")DAOUser user); 

    @Query("select COUNT(*) from DAOUser user  WHERE  (MONTH(user.created_At)=MONTH(current_timestamp))")
    Integer findUsersByMonth(); 

    @Query("select COUNT(*) from DAOUser user  WHERE  (YEAR(user.created_At)=YEAR(current_timestamp))")
    Integer findUsersByYEAR(); 

    @Query("select COUNT(*) from Ouvrage ouvrage  WHERE  (YEAR(ouvrage.created_At)=YEAR(current_timestamp))")
    Integer findOuvrageByYEAR(); 

    @Query("select COUNT(*) from Ouvrage ")
    Integer countOuvrage(); 

    @Query("select ouvrage from Ouvrage ouvrage  WHERE  (MONTH(ouvrage.update_At)=MONTH(current_timestamp))")
    ArrayList<Ouvrage> findOuvrageByMonth();
}
