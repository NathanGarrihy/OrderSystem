package com.sales.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.models.Product;
import com.sales.services.ProductService;

@Controller
public class ProductController {
	// Autowired service
	@Autowired
	ProductService ps;

	// returns full list of products
	@RequestMapping(value = "/showProducts.html")
	public String getProducts(Model model) {
		ArrayList<Product> products = ps.getAllProducts();
		model.addAttribute("products", products);

		return "showProducts";
	}

	// Used to add customer to database
	@RequestMapping(value = "/addProduct.html", method = RequestMethod.GET)
	public String addCustomer(Model model) {
		Product p = new Product();
		model.addAttribute(p);

		return "addProduct";
	}

	// used to add a new product
	@RequestMapping(value = "/addProduct.html", method = RequestMethod.POST)
	public String addProductPOST(@ModelAttribute("product") Product p) {
		ps.save(p);

		return "redirect:showProducts.html";
	}

} // end of ProductController