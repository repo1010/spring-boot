package com.spring.angularspring.service;

import java.util.List;

import com.spring.angularspring.model.Product;

public interface IProductService {

	List<Product> getAllProducts();
	
	Product getProduct(Integer productId);
	
	void addProduct(Product product);
	
	void removeProduct(Integer productId);
	
	void updateProduct(Product product);
}
