package com.sales.controllers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.models.Customer;
import com.sales.models.Order;
import com.sales.models.Product;
import com.sales.repositories.ProductRepository;
import com.sales.services.CustomerService;
import com.sales.services.OrderService;
import com.sales.services.ProductService;

@Controller
public class OrderController {
	// Autowired services
	@Autowired
	OrderService ord;

	@Autowired
	CustomerService cs;

	@Autowired
	ProductService ps;

	// Autowired repository
	@Autowired
	ProductRepository pr;

	// Returns full list of orders
	@RequestMapping(value = "/showOrders.html")
	public String getOrders(Model model) {
		ArrayList<Order> orders = ord.getAllOrders();
		model.addAttribute("orders", orders);

		return "showOrders";
	}

	// Used to add customer to database
	@RequestMapping(value = "/addOrder.html", method = RequestMethod.GET)
	public String addOrder(Model model) {
		ArrayList<Customer> customers = cs.getAllCustomers();
		Map<Long, String> customerList = new LinkedHashMap<Long, String>();

		// populate list of customers
		for (Customer c : customers) {
			customerList.put(c.getcId(), c.getcName());
		}
		model.addAttribute("customerList", customerList);

		ArrayList<Product> products = ps.getAllProducts();
		Map<Long, String> productList = new LinkedHashMap<Long, String>();

		// populate list of products
		for (Product p : products) {
			productList.put(p.getpId(), p.getpDesc());
		}
		model.addAttribute("productList", productList);

		Order o = new Order();
		model.addAttribute(o);

		return "addOrder";
	}

	// used to update order and product values
	@RequestMapping(value = "/addOrder.html", method = RequestMethod.POST)
	public String addOrderPOST(@ModelAttribute("order") Order o) {
		Product p = pr.findOne(o.getProd().getpId());
		// update orders and product if order quantity <= product quantity
		if (o.getQty() <= p.getQtyInStock()) {
			p.setQtyInStock(p.getQtyInStock() - o.getQty());
			ord.save(o);
			ps.save(p);
		}

		return "redirect:showOrders.html";
	}

}
