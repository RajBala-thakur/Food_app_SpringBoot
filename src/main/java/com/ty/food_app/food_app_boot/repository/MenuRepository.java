package com.ty.food_app.food_app_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.food_app.food_app_boot.dto.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

}
