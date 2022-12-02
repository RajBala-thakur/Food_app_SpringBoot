package com.ty.food_app.food_app_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.food_app.food_app_boot.dao.MenuDao;
import com.ty.food_app.food_app_boot.dto.Menu;
import com.ty.food_app.food_app_boot.dto.Product;
import com.ty.food_app.food_app_boot.dto.User;
import com.ty.food_app.food_app_boot.exception.NoSuchIdFoundException;
import com.ty.food_app.food_app_boot.exception.UnableToDeleteException;
import com.ty.food_app.food_app_boot.exception.UnableToUpdateException;
import com.ty.food_app.food_app_boot.util.ResponseStructure;

@Service
public class MenuService {
	@Autowired
	private MenuDao dao;
	
	public  ResponseEntity<ResponseStructure<Menu>> saveMenu(Menu menu)
	{
		ResponseStructure<Menu>responseStructure= new ResponseStructure<Menu>();
		ResponseEntity<ResponseStructure<Menu>> responseEntity=new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.CREATED);
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("saved");
		responseStructure.setData(dao.saveMenu(menu));
		return responseEntity;
		
	}
	public ResponseEntity<ResponseStructure<Menu>> updateMenu(Menu menu,int id)
	
	{
		Menu menu1=dao.getMenuById(id);
		ResponseStructure<Menu>responseStructure= new ResponseStructure<Menu>();
		ResponseEntity<ResponseStructure<Menu>> responseEntity=new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.OK);
		if(menu1!=null) {
		
		menu1.setId(id);
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("updated");
		responseStructure.setData(dao.saveMenu(menu));
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
	
	public ResponseEntity<ResponseStructure<Menu>> getMenuById(int id)
	{
		Menu menu1=dao.getMenuById(id);
		ResponseStructure<Menu> responseStructure = new ResponseStructure<Menu>();
		ResponseEntity<ResponseStructure<Menu>>responseEntity=new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.OK);
		if(menu1!=null) {
		
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Received");
		responseStructure.setData(dao.getMenuById(id));
	}else
	{
		throw new NoSuchIdFoundException();
	}
	return responseEntity;
	}
	
	public ResponseEntity<ResponseStructure<String>> DeleteMenuById(int id)
	{    	Menu menu2=dao.getMenuById(id);
		ResponseStructure<String>responseStructure= new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity=new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);
		if(menu2!=null) {
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("deleted");
		responseStructure.setData(dao.deleteMenu(id));
		return responseEntity;
	}
		else
		{
			throw new UnableToDeleteException("Unable to delete Exception");
		}
	

	}
}
