package com.spring.crudwebapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.crudwebapp.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

	Optional<Customer> findByUsername(String username);

}
