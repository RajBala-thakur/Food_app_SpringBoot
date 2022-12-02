package com.ty.food_app.food_app_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.food_app.food_app_boot.dao.UserDao;
import com.ty.food_app.food_app_boot.dto.User;
import com.ty.food_app.food_app_boot.exception.NoSuchIdFoundException;
import com.ty.food_app.food_app_boot.exception.UnableToDeleteException;
import com.ty.food_app.food_app_boot.exception.UnableToUpdateException;
import com.ty.food_app.food_app_boot.util.ResponseStructure;

@Service
public class UserService {
	@Autowired
	private UserDao dao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(dao.saveUser(user));
		ResponseEntity<ResponseStructure<User>> responseEntity=new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.CREATED);
		return responseEntity ;
	}

	public ResponseEntity<ResponseStructure<User>>updateUser(User user, int id) {
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		ResponseEntity<ResponseStructure<User>> responseEntity=new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.CREATED);
		User user1 = dao.getUserById(id);
		if (user1 != null) {
			user.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(dao.saveUser(user));
		
			return responseEntity;

		} else {
			  throw new UnableToUpdateException();
			
//			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
//			responseStructure.setMessage("NotFound");
//			responseStructure.setData(null);
//			return responseStructure;
		}
		
	}

	public ResponseEntity<ResponseStructure<User>>getUserById(int id) {
		User user2=dao.getUserById(id);
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		ResponseEntity<ResponseStructure<User>> responseEntity=new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK );
		
		
		if(user2!=null) {
		
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Received");
		responseStructure.setData(dao.getUserById(id));
	}else
	{
		throw new NoSuchIdFoundException();
	}
	return responseEntity;
	}

	public ResponseEntity<ResponseStructure<String>> deleteUserById(int id) {
		User user3=dao.getUserById(id);
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity=new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK );
		User user1 = dao.getUserById(id);
		if(user3!=null) {
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(dao.deleteUser(id));
		return responseEntity;
		}
		else
		{
			throw new UnableToDeleteException("Unable To Delete exception");
		}
	}

}
