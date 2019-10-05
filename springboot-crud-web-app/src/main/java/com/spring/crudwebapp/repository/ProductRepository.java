package com.spring.crudwebapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.crudwebapp.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

	Product findById(int productid);

	void deleteById(int productid);

	


}
