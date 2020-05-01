package com.sales.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Order;
import com.sales.repositories.OrderRepository;

@Service
public class OrderService {
	// Autowired repository
	@Autowired
	OrderRepository ord;

	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private Date date = new Date();

	// Returns list of all orders
	public ArrayList<Order> getAllOrders() {
		// Casted to ArrayList of orders
		return (ArrayList<Order>) ord.findAll();
	}

	// Saves order to database
	public void save(Order o) {
		o.setOrderDate(dateFormat.format(date));

		ord.save(o);
	}
}