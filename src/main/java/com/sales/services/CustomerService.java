package com.sales.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Customer;
import com.sales.repositories.CustomerRepository;

@Service
public class CustomerService {
	// Autowired repository
	@Autowired
	CustomerRepository cr;

	// Returns list of all customers
	public ArrayList<Customer> getAllCustomers() {
		// Casted to ArrayList of customers
		return (ArrayList<Customer>) cr.findAll();
	}

	// saves customer to database
	public void save(Customer c) {
		cr.save(c);
	}
}
