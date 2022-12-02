package com.ty.food_app.food_app_boot.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.food_app.food_app_boot.dto.FoodOrder;
import com.ty.food_app.food_app_boot.dto.User;
import com.ty.food_app.food_app_boot.repository.FoodOrderRepository;

@Repository
public class FoodOrderDao {
	
	@Autowired
	private FoodOrderRepository repository;
	
	public FoodOrder saveFoodOrder(FoodOrder foodOrder)
	{
		return repository.save(foodOrder);
	}
    
	public FoodOrder updateFoodOrder(FoodOrder foodOrder,int id)
	{
		return repository.save(foodOrder);
	}
	public FoodOrder getFoodOrderById(int id)
	{
		Optional<FoodOrder> optional=repository.findById(id);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
		
	}
	public String deleteFoodOrder(int id)
	{
		repository.deleteById(id);
		return "deleted";
	}

	

}
