package com.ty.food_app.food_app_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.food_app.food_app_boot.dao.ProductDao;
import com.ty.food_app.food_app_boot.dto.Product;
import com.ty.food_app.food_app_boot.dto.User;
import com.ty.food_app.food_app_boot.exception.NoSuchIdFoundException;
import com.ty.food_app.food_app_boot.exception.UnableToDeleteException;
import com.ty.food_app.food_app_boot.exception.UnableToUpdateException;
import com.ty.food_app.food_app_boot.util.ResponseStructure;

@Service
public class ProductService {
	@Autowired
	private ProductDao dao;
	
	public ResponseEntity<ResponseStructure<Product>>saveProduct(Product product)
	{
		ResponseStructure<Product> responseStructure=new ResponseStructure<Product>();
		ResponseEntity<ResponseStructure<Product>> responseEntity=new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.CREATED );
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("saved");
		responseStructure.setData(dao.saveProduct(product));
		return responseEntity;
		
	}
	public ResponseEntity<ResponseStructure<Product>>updateProduct(Product product,int id)
	{
		ResponseStructure<Product> responseStructure=new ResponseStructure<Product>();
		ResponseEntity<ResponseStructure<Product>> responseEntity=new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.OK );
		Product product1=dao.getProductById(id);
		if(product1!=null) {
			product.setId(id);
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("saved");
		responseStructure.setData(dao.saveProduct(product));
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
	
	public ResponseEntity<ResponseStructure<Product>> getProductById(int id)
	{    Product product1=dao.getProductById(id);
		ResponseStructure<Product>responseStructure=new ResponseStructure<Product>();
		ResponseEntity<ResponseStructure<Product>> responseEntity=new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.OK );
		if(product1!=null) {
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Received");
		responseStructure.setData(dao.getProductById(id));
		return responseEntity;
		}
		else
		{
			throw new NoSuchIdFoundException();
		}
		
	}
	public ResponseEntity<ResponseStructure<String>> deleteProductById(int id)
	{      Product product1=dao.getProductById(id);
		ResponseStructure<String>responseStructure=new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity=new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK );
		if(product1!=null) {
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(dao.deleteProduct(id));
		return responseEntity;
		}
		else
		{
			throw new UnableToDeleteException("Unable To Delete exception");
		}
		
		
	}

}
