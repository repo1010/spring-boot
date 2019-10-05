package com.spring.crudwebapp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.crudwebapp.model.Customer;
import com.spring.crudwebapp.model.Product;
import com.spring.crudwebapp.service.ICustomerService;
import com.spring.crudwebapp.service.IProductService;

@SpringBootApplication
public class SpringbootCrudWebAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCrudWebAppApplication.class, args);
	}

	@Autowired
	IProductService productService;
	
	@Autowired
	ICustomerService customerService;

	@Override
	public void run(String... args) throws Exception {
		
		//populate db with customers
		/*List<Customer> custList = new ArrayList<Customer>();
		custList.add(new Customer("vishal","vishal"));
		custList.add(new Customer("ankit","ankit"));
		customerService.populate(custList);
		
		//populate db with products
		List<Product> prodList = new ArrayList<Product>();
		prodList.add(new Product("Television", "HD and plazma feature", new BigDecimal(23000.00)));
		prodList.add(new Product("Refregeretor", "Auto implementation and sound feature", new BigDecimal(12000.00)));
		prodList.add(new Product("Camera", "High resolution feature", new BigDecimal(10000.00)));
		prodList.add(new Product("Laptop", "HD webcam and gemming support feature", new BigDecimal(60000.00)));

		productService.saveAll(prodList);*/
	}

}
