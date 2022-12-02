package com.ty.food_app.food_app_boot.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.food_app.food_app_boot.dto.User;
import com.ty.food_app.food_app_boot.repository.UserRepository;

@Repository
public class UserDao {
	@Autowired
	private UserRepository repository;
	
	public User saveUser(User user)
	{
		return repository.save(user);
	}
    
	public User updateUser(User user,int id)
	{
		return repository.save(user);
	}
	public User getUserById(int id)
	{
		Optional<User> optional=repository.findById(id);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
		
	}
	public String deleteUser(int id)
	{
		repository.deleteById(id);
		return "deleted";
	}


}
