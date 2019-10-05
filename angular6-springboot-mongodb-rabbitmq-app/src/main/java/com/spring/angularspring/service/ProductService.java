package com.spring.angularspring.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.angularspring.model.Product;
import com.spring.angularspring.repository.ProductRepository;

@Service
public class ProductService implements IProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	NextSequenceService nextSequenceService;
	
	@Autowired
	RabbitMQService rabbitMQService;

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProduct(Integer productId) {
		return productRepository.findById(productId).get();
	}

	@Override
	public void removeProduct(Integer productId) {
		Product productbackup = getProduct(productId);
		 productRepository.deleteById(productId);		 
		 rabbitMQService.publishMesaage(Arrays.asList(productbackup), Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Override
	public void updateProduct(Product product) {
		 productRepository.save(product);
		 rabbitMQService.publishMesaage(Arrays.asList(product), Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void addProduct(Product product) {
		product.setId(nextSequenceService.getNextSequence("customSequences"));
		 productRepository.save(product);
		 rabbitMQService.publishMesaage(Arrays.asList(product), Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	
}
