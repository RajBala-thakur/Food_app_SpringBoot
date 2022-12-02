package com.ty.food_app.food_app_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.food_app.food_app_boot.dto.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
