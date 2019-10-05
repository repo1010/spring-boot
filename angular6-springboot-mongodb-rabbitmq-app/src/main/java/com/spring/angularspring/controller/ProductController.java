package com.spring.angularspring.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.angularspring.model.Product;
import com.spring.angularspring.service.ProductService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders = "*")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping(value ="/products" , method = RequestMethod.GET)
	List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@RequestMapping(value ="/product/{productId}" , method = RequestMethod.GET)
	Product getProduct(@PathVariable Integer productId){
		return productService.getProduct(productId);
	}
	
	@RequestMapping(value ="/product" , method = RequestMethod.POST)
	void createProduct(@RequestBody Product product){
		 productService.addProduct(product);
	}
	
	@RequestMapping(value ="/product" , method = RequestMethod.PUT)
	void updateProduct(@RequestBody Product product){
		 productService.updateProduct(product);
	}
	
	@RequestMapping(value ="/product/{productId}" , method = RequestMethod.DELETE)
	void updateProduct(@PathVariable Integer productId){
		 productService.removeProduct(productId);
	}
	
	
	
}
