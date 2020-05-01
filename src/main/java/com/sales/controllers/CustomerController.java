package com.sales.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sales.models.Customer;
import com.sales.services.CustomerService;

@Controller
@SessionAttributes("Customer")
public class CustomerController {
	// Autowired service
	@Autowired
	CustomerService cs;
	
	// used to display list of customers
	@RequestMapping(value = "/showCustomers.html")
	  public String getCustomers(Model model) {
		ArrayList<Customer> customers = cs.getAllCustomers();
		model.addAttribute("customers", customers);
		
	    return "showCustomers";
	  }

	// used to add customer to database
		@RequestMapping(value = "/addCustomer.html", method=RequestMethod.GET)
		  public String addCustomer(Model model) {
			Customer c = new Customer();
			model.addAttribute(c);
			
			return "addCustomer";
		  }
	
	// used to add new customer
	@RequestMapping(value="/addCustomer.html", method=RequestMethod.POST)
	  public String addCustomerPOST(@ModelAttribute("customer")Customer c) {
		cs.save(c);
		
		return "redirect:showCustomers.html";
}
}