package com.spring.crudwebapp.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.crudwebapp.model.Customer;
import com.spring.crudwebapp.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired	
	CustomerService customerService;
	

	@GetMapping("/")
	public String home(Map<String, Object> map) {
		return "home";
	}
	
	@GetMapping("/showlogin")
	public String Customer(ModelMap map) {
		map.addAttribute("customer", new Customer());
		return "login";
	}
	
	@GetMapping("/showregistration")
	public String registration(ModelMap map) {
		map.addAttribute("customer", new Customer());
		return "registration";
	}
	
	@RequestMapping(value = "/processlogin")
	public String processCustomer(HttpServletRequest request ,ModelMap map, @ModelAttribute("customer") Customer Customer, BindingResult bindingResult) {
		Boolean isCustomerSuccess = false;
		System.out.println("1");
		isCustomerSuccess = customerService.fetchData(Customer);
		System.out.println("2" + isCustomerSuccess);
		if(isCustomerSuccess) {
		map.addAttribute("customer", new Customer());
		return "customerportal";
		} else {
			map.addAttribute("customer", new Customer());
			return "login";
		}
	}
}
