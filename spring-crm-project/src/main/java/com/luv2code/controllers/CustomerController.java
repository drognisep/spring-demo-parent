package com.luv2code.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luv2code.controllers.util.CustomerEncoder;
import com.luv2code.controllers.util.ViewTemplate;
import com.luv2code.data.CustomerRepository;
import com.luv2code.dto.Customer;

@RequestMapping("/customers")
@Controller
public class CustomerController {
	@Autowired
	private CustomerRepository repo;

	@RequestMapping(path="/list", method=RequestMethod.GET)
	public String getAllCustomersForm(Model model) {
		List<Customer> customers;
		try {
			customers = repo.getAll();
		} catch (Exception ex) {
			System.err.println("Exception occurred while getting customers: " + ex.getMessage());
			return "error";
		}

		customers.stream().forEach((c) -> {
			CustomerEncoder.encodeInPlace(c);
		});
		model.addAttribute("customers", customers);
		model.addAttribute("viewName", "customers-list");
		return "view-template";
	}
	
	@RequestMapping(path="/add", method=RequestMethod.GET)
	public String addCustomerForm(Model model) {
		Customer c = new Customer();
		model.addAttribute("customer", c);
		return ViewTemplate.sendViewTemplate(model, "add-customer-form", "Add Customer");
	}
	
	@RequestMapping(path="/add", method=RequestMethod.POST)
	public String addCustomer(@Valid @ModelAttribute Customer customer, BindingResult result, Model model) {
		if(result == null || result.hasErrors()) {
			return ViewTemplate.sendViewTemplate(model, "add-customer-form", "Add Customer");
		}
		
		try {
			repo.update(customer.getId(), customer);
			return "redirect:list";
		} catch(Exception ex) {
			System.err.println("\nException occurred while saving customer " + customer + ": " + ex.getMessage() + "\n");
			return "error";
		}
	}
	
	@RequestMapping(path="/update/{id}", method=RequestMethod.GET)
	public String updateCustomerForm(@PathVariable int id, Model model) {
		try {
			Customer c = repo.get(id);
			CustomerEncoder.encodeInPlace(c);
			if(c != null) {
				model.addAttribute("customer", c);
				return ViewTemplate.sendViewTemplate(model, "update-form", "Update Customer");
			}
			
			System.err.println("Unable to find customer with id: " + id);
			return "error";
		} catch(Exception ex) {
			System.err.println("\nException occurred while attempting to get customer with id " + id + ": " + ex.getMessage());
			return "error";
		}
	}

	@RequestMapping(path="/update/{id}", method=RequestMethod.POST)
	public String updateCustomer(@Valid @ModelAttribute Customer customer, BindingResult result, @PathVariable int id, Model model) {
		if(result.hasErrors()) {
			return ViewTemplate.sendViewTemplate(model, "update-form", "Update Customer");
		}
		
		CustomerEncoder.encodeInPlace(customer);
		
		try {
			Customer c = repo.get(id);
			if(c != null) {
				c.setEmail(customer.getEmail());
				c.setFirstName(customer.getFirstName());
				c.setLastName(customer.getLastName());
			} else {
				System.out.println("No customer found with id: " + id);
			}
			
			return "redirect:../list";
		} catch(Exception ex) {
			System.err.println("\nException occurred while updating customer with id " + customer.getId() + ": " + ex.getMessage());
			return "error";
		}
	}
	
	@RequestMapping(path="/delete/{id}", method=RequestMethod.POST)
	public String deleteCustomer(@PathVariable int id) {
		try {
			Customer c = repo.get(id);
			if(c != null) {
				System.out.println("Deleting Customer: " + c);
				repo.delete(id);
			}
			return "redirect:../list";
		} catch(Exception ex) {
			System.err.println("\nError occurred while deleting customer with id " + id + ": " + ex.getMessage() + "\n");
			return "error";
		}
	}
	
	@ExceptionHandler
	public String errorHandler(Exception ex, HttpServletRequest req, HttpServletResponse res) {
		System.err.println("Exception caught in errorHandler: " + ex.getMessage());
		return "error";
	}
}
