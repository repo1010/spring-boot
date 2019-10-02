package com.spring.crudwebapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.crudwebapp.model.Customer;
import com.spring.crudwebapp.repository.CustomerRepository;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	CustomerRepository custRepository;

	public Boolean fetchData(Customer customer) {
		Customer cust = custRepository.findById(customer.getUsername()).get();
		if (cust.getPassword().equals(customer.getPassword()))
			return true;
		else
			return false;
	}

}
