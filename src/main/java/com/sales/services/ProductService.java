package com.sales.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Product;
import com.sales.repositories.ProductRepository;

@Service
public class ProductService {
	// Autowired repository
	@Autowired
	ProductRepository pr;

	// Returns list of all customers
	public ArrayList<Product> getAllProducts() {
		// Casted to ArrayList of customers
		return (ArrayList<Product>) pr.findAll();
	}

	// Saves product to database
	public void save(Product p) {
		pr.save(p);
	}
}
