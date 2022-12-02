package com.ty.food_app.food_app_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.food_app.food_app_boot.dao.ItemsDao;
import com.ty.food_app.food_app_boot.dto.Items;
import com.ty.food_app.food_app_boot.dto.Menu;
import com.ty.food_app.food_app_boot.exception.NoSuchIdFoundException;
import com.ty.food_app.food_app_boot.exception.UnableToDeleteException;
import com.ty.food_app.food_app_boot.exception.UnableToUpdateException;
import com.ty.food_app.food_app_boot.util.ResponseStructure;

@Service
public class ItemsService {
	@Autowired
	private ItemsDao dao;
	
	public ResponseEntity<ResponseStructure<Items>> saveItems(Items items)
	{
		ResponseStructure<Items>responseStructure= new ResponseStructure<Items>();
		ResponseEntity<ResponseStructure<Items>>responseEntity=new ResponseEntity<ResponseStructure<Items>>(responseStructure,HttpStatus.CREATED);
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("saved");
		responseStructure.setData(dao.saveItems(items));
		return responseEntity;
		
	}
	public ResponseEntity<ResponseStructure<Items>> updateItems(Items items,int id)
	
	{
		Items items1=dao.getItemsById(id);
		ResponseStructure<Items>responseStructure= new ResponseStructure<Items>();
		ResponseEntity<ResponseStructure<Items>> responseEntity=new ResponseEntity<ResponseStructure<Items>>(responseStructure,HttpStatus.OK);
		if(items1!=null) {
		
		items.setId(id);
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("updated");
		responseStructure.setData(dao.saveItems(items));
		return responseEntity;
		}
		else
		{
			 throw new UnableToUpdateException();
//			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
//			responseStructure.setMessage("NotFound");
//			responseStructure.setData(null);
//			return responseStructure;
		}
		
	}
	
	public ResponseEntity<ResponseStructure<Items>>getItemsById(int id)
	{
		Items items1=dao.getItemsById(id);
		
		ResponseStructure<Items> responseStructure = new ResponseStructure<Items>();
		ResponseEntity<ResponseStructure<Items>> responseEntity=new ResponseEntity<ResponseStructure<Items>>(responseStructure,HttpStatus.OK);
		if(items1!=null) {
		
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Received");
		responseStructure.setData(dao.getItemsById(id));
	}else
	{
		throw new NoSuchIdFoundException();
	}
	return responseEntity;
	}
	
	public ResponseEntity<ResponseStructure<String>> DeleteItemsById(int id)
	{    	Items items1=dao.getItemsById(id);
		ResponseStructure<String>responseStructure= new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity=new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);
		if(items1!=null) {
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("deleted");
		responseStructure.setData(dao.deleteItems(id));
		return responseEntity;
	}
		else
		{
			throw new UnableToDeleteException("Unable to delete Exception");
		}
	

	}
	
	
	

}
