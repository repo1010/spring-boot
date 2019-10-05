package com.spring.angularspring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.angularspring.model.Product;


@Repository
public interface ProductRepository extends MongoRepository<Product, Integer>{

}
