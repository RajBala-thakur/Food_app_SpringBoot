package com.ty.food_app.food_app_boot.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.food_app.food_app_boot.dto.Items;
import com.ty.food_app.food_app_boot.dto.User;
import com.ty.food_app.food_app_boot.repository.ItemsRepository;

@Repository
public class ItemsDao {
	@Autowired
	private ItemsRepository repository;
	
	public Items saveItems(Items items)
	{
		return repository.save(items);
	}
    
	public Items updateItems(Items items,int id)
	{
		return repository.save(items);
	}
	public Items getItemsById(int id)
	{
		Optional<Items> optional=repository.findById(id);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
		
	}
	public String deleteItems(int id)
	{
		repository.deleteById(id);
		return "deleted";
	}


}
