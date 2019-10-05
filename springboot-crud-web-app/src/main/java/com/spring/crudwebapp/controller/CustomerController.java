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
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.spring.crudwebapp.model.Customer;
import com.spring.crudwebapp.service.ICustomerService;
import com.spring.crudwebapp.service.ProductService;

@Controller
public class CustomerController {

	@Autowired
	ICustomerService customerService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	RestTemplate restTemplate;

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

	@RequestMapping(value = "/productportal")
	public String processCustomer(HttpServletRequest request, ModelMap map,
			@ModelAttribute("products") Customer customer, BindingResult bindingResult) {
		Boolean isCustomerSuccess = false;
		isCustomerSuccess = customerService.fetchData(customer);
			
		
		if(!isCustomerSuccess) 
			map.addAttribute("customer", new Customer());
		else
			request.getSession().setAttribute("username", customer.getUsername().toUpperCase());

		return isCustomerSuccess ? "redirect:/products" : "login";
	}
}
