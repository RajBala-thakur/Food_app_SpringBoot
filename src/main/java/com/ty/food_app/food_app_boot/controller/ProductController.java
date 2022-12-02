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

import com.ty.food_app.food_app_boot.dto.Product;
import com.ty.food_app.food_app_boot.dto.User;
import com.ty.food_app.food_app_boot.service.ProductService;
import com.ty.food_app.food_app_boot.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("product")
public class ProductController {
	@Autowired
	private ProductService service;
    
	@ApiOperation(value = "save product", notes = "its used to save product")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal server error"),
			@ApiResponse(code = 404, message = "not found") })

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product)
	{
		return service.saveProduct(product);
	}
	@ApiOperation(value = "update product", notes = "its used to update product ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal server error"),
			@ApiResponse(code = 404, message = "not found") })

	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestBody Product product,@RequestParam int id)
	{
		return service.updateProduct(product, id);
	}
	@ApiOperation(value = "get product", notes = "its used to get product")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal server error"),
			@ApiResponse(code = 404, message = "not found")
	})
	@GetMapping( produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Product>> getProductById(@RequestParam int id)
	{
		return service.getProductById(id);
	}
	
	@ApiOperation(value = "delete product", notes = "its used to delete product")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal server error"),
			@ApiResponse(code = 404, message = "not found")
	})
	@DeleteMapping
	public ResponseEntity<ResponseStructure<String>> deleteUserById(@RequestParam int id)
	{
		return service.deleteProductById(id);
	}

	
}
