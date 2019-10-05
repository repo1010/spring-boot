package com.spring.crudwebapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.crudwebapp.model.Product;
import com.spring.crudwebapp.service.IProductService;

@Controller
@RequestMapping("/")
public class ProductController {

	@Autowired
	IProductService productService;

	@GetMapping(value = "/products")
	public String getAllProducts(HttpServletRequest request, ModelMap model, @ModelAttribute("product") Product product,  
			BindingResult bindingResult) {
		
		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		

		return "shoppingportal";
	}
	
	@GetMapping(value = "/sowproduct")
	public String showAddProduct(HttpServletRequest request, ModelMap model, @ModelAttribute("product") Product product,
			BindingResult bindingResult) {

		model.addAttribute("products", new Product());

		return "addproduct";
	}

	@PostMapping(value = "/addproduct")
	public String addProduct(HttpServletRequest request, ModelMap model, @ModelAttribute("product") Product product,
			BindingResult bindingResult) {

		 productService.save(product);
		
		return "redirect:/products";
	}

	@GetMapping(value = "/showedit/{productid}")
	public String showUpdateProduct(ModelMap model, @ModelAttribute("product") Product product,
			@PathVariable int productid, BindingResult bindingResult) {

		Product fetchedProd = productService.getProductById(productid);
		model.addAttribute("product", fetchedProd);

		return "editproduct";
	}

	@GetMapping(value = "/deleteproduct/{productid}")
	public String removeProduct(ModelMap model, @ModelAttribute("product") Product product,
			@PathVariable int productid, BindingResult bindingResult) {

		 productService.deleteProduct(productid);
		
		return "redirect:/products";
	}
	
	
	@PostMapping(value = "/multidelete")
	public String removeProduct(HttpServletRequest request ,ModelMap model, @ModelAttribute("product") String productid,
			 BindingResult bindingResult) {
		String[] checkedIds = request.getParameterValues("id");
		 productService.bulkDelete(checkedIds);
		
		return "redirect:/products";
	}
	
}
