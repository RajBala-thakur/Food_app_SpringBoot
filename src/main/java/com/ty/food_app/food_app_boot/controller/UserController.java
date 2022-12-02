package com.ty.food_app.food_app_boot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.food_app.food_app_boot.dto.User;
import com.ty.food_app.food_app_boot.service.UserService;
import com.ty.food_app.food_app_boot.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService service;

	@ApiOperation(value = "save user", notes = "its used to save user")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal server error"),
			@ApiResponse(code = 404, message = "not found") })

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<User>> saveuser(@RequestBody @Valid User user) {
		return service.saveUser(user);
	}

	@ApiOperation(value = "update user", notes = "its used to update user")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal server error"),
			@ApiResponse(code = 404, message = "not found") })

	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<User>> updateuser(@RequestBody User user, @RequestParam int id) {
		return service.updateUser(user, id);
	}

	@ApiOperation(value = "get user", notes = "its used to get user")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal server error"),
			@ApiResponse(code = 404, message = "not found")
	})
	@GetMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<User>> getUserById(@RequestParam int id) {
		return service.getUserById(id);
	}

	@ApiOperation(value = "delete user", notes = "its used to delete user")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal server error"),
			@ApiResponse(code = 404, message = "not found")
	})
	@DeleteMapping
	public ResponseEntity<ResponseStructure<String>> deleteUserById(@RequestParam int id) {
		return service.deleteUserById(id);
	}

}
