package com.spring.crudwebapp.service;

import java.util.List;

import com.spring.crudwebapp.model.Product;

public interface IProductService {

	public List<Product> getAllProducts();

	public void saveAll(List<Product> prodList);

	public void save(Product product);

	public List<Product> update(Product product);

	public Product getProductById(int productid);

	public void deleteProduct(int productid);

	public void bulkDelete(String[] checkedIds);

}
