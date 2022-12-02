package com.ty.food_app.food_app_boot.controller;

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

import com.ty.food_app.food_app_boot.dto.Menu;
import com.ty.food_app.food_app_boot.service.MenuService;
import com.ty.food_app.food_app_boot.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("menu")
public class MenuController {
	@Autowired
	private MenuService service;
	@ApiOperation(value = "save menu", notes = "its used to save menu")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal server error"),
			@ApiResponse(code = 404, message = "not found") })

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public  ResponseEntity<ResponseStructure<Menu>> saveMenu(@RequestBody Menu menu)
	{
		return service.saveMenu(menu);
		
	}
	@ApiOperation(value = "update menu", notes = "its used to update menu")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal server error"),
			@ApiResponse(code = 404, message = "not found") })

	@PutMapping( produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public  ResponseEntity<ResponseStructure<Menu>> updateMenu(@RequestBody Menu menu,@RequestParam int id)
	{
		return service.updateMenu(menu, id);
		
	}
	@ApiOperation(value = "get menu", notes = "its used to get menu")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal server error"),
			@ApiResponse(code = 404, message = "not found")
	})
	@GetMapping( produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public  ResponseEntity<ResponseStructure<Menu>> getMenuById(@RequestParam int id)
	{
		return service.getMenuById(id);
		
	}
	@ApiOperation(value = "delete menu", notes = "its used to delete menu")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal server error"),
			@ApiResponse(code = 404, message = "not found")
	})
	@DeleteMapping
	public  ResponseEntity<ResponseStructure<String>> deleteMenu(@RequestParam int id)
	{
		return service.DeleteMenuById(id);
		
	}
	
	
	

}
