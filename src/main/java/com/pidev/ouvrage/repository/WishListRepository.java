package com.pidev.ouvrage.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.pidev.ouvrage.model.WishList;

public interface WishListRepository extends JpaRepository<WishList, Long>{

}
