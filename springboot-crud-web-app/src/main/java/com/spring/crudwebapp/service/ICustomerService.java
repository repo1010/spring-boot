package com.spring.crudwebapp.service;

import java.util.List;

import com.spring.crudwebapp.model.Customer;

public interface ICustomerService {

	public Boolean fetchData(Customer login);

	public void populate(List<Customer> custList);
}
