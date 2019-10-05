package com.spring.crudwebapp.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.crudwebapp.model.Product;
import com.spring.crudwebapp.repository.ProductRepository;

@Service
public class ProductService implements IProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public void saveAll(List<Product> prodList) {
		productRepository.saveAll(prodList);
	}

	@Override
	public void save(Product product) {
		 productRepository.saveAndFlush(product);
		 

	}

	@Override
	public List<Product> update(Product product) {
		productRepository.save(product);
		return getAllProducts();
	}

	@Override
	public Product getProductById(int productid) {

		return productRepository.findById(productid);
	}

	@Override
	@Transactional
	public void deleteProduct(int productid) {
		 productRepository.deleteById(productid);
		 
	}

	@Override
	@Transactional
	public void bulkDelete(String[] checkedIds) {
		Arrays.stream(checkedIds).forEach(id -> {
			productRepository.deleteById(Integer.parseInt(id));
		});
				
	}

}
