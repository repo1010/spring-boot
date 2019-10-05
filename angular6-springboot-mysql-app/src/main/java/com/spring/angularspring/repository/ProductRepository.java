package com.spring.angularspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.angularspring.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
