package com.ty.food_app.food_app_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.food_app.food_app_boot.dto.Items;

public interface ItemsRepository extends JpaRepository<Items, Integer> {

}
