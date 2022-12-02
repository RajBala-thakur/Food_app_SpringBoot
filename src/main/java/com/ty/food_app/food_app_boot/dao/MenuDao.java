package com.ty.food_app.food_app_boot.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.food_app.food_app_boot.dto.Menu;
import com.ty.food_app.food_app_boot.dto.User;
import com.ty.food_app.food_app_boot.repository.MenuRepository;

@Repository
public class MenuDao {
	@Autowired
	private MenuRepository repository;
	
	public Menu saveMenu(Menu menu)
	{
		return repository.save(menu);
	}
    
	public Menu updateMenu(Menu menu,int id)
	{
		return repository.save(menu);
	}
	public Menu getMenuById(int id)
	{
		Optional<Menu> optional=repository.findById(id);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
		
	}
	public String deleteMenu(int id)
	{
		repository.deleteById(id);
		return "deleted";
	}


}
