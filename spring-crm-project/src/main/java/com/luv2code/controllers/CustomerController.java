package com.luv2code.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
import com.luv2code.entities.Customer;

@RequestMapping("/customers")
@Controller
public class CustomerController {
	@Autowired
	private SessionFactory factory;

	@RequestMapping(path="/list", method=RequestMethod.GET)
	public String getAllCustomersForm(Model model) {
		try (Session session = factory.getCurrentSession();) {
			session.beginTransaction();

			@SuppressWarnings("unchecked")
			List<Customer> customers = session.createQuery("from Customer").getResultList();

			session.getTransaction().commit();

			customers.stream().forEach((c) -> {
				CustomerEncoder.encodeInPlace(c);
			});
			model.addAttribute("customers", customers);
			model.addAttribute("viewName", "customers-list");
		} catch (Exception ex) {
			System.err.println("\nError occurred retrieving Customers: " + ex.getMessage() + "\n");
			return "error";
		}
		return "view-template";
	}
	
	@RequestMapping(path="/add-form", method=RequestMethod.GET)
	public String addCustomerForm(Model model) {
		Customer c = new Customer();
		model.addAttribute("customer", c);
		model.addAttribute("viewName", "add-customer-form");
		return "view-template";
	}
	
	@RequestMapping(path="/add", method=RequestMethod.POST)
	public String addCustomer(@Valid @ModelAttribute Customer customer, BindingResult result) {
		if(result == null || result.hasErrors()) {
			return "add-customer-form";
		}
		
		try (Session session = factory.getCurrentSession();) {
			session.beginTransaction();
			
			session.save(customer);
			
			session.getTransaction().commit();
			return "redirect:list";
		} catch(Exception ex) {
			System.err.println("\nException occurred while saving customer " + customer + ": " + ex.getMessage() + "\n");
			return "error";
		}
	}
	
	@RequestMapping(path="/update-form/{id}", method=RequestMethod.GET)
	public String updateCustomerForm(@PathVariable int id, Model model) {
		try(Session session = factory.getCurrentSession();) {
			session.beginTransaction();
			
			Customer c = session.get(Customer.class, id);
			CustomerEncoder.encodeInPlace(c);
			
			session.getTransaction().commit();
			if(c != null) {
				model.addAttribute("customer", c);
				model.addAttribute("viewName", "update-form");
				return "view-template";
			}
			
			System.err.println("Unable to find customer with id: " + id);
			return "redirect:../list";
		} catch(Exception ex) {
			System.err.println("\nException occurred while attempting to get customer with id " + id + ": " + ex.getMessage());
			return "error";
		}
	}
	
	@RequestMapping(path="/update/{id}", method=RequestMethod.POST)
	public String updateCustomer(@Valid @ModelAttribute Customer customer, BindingResult result, @PathVariable int id) {
		if(result.hasErrors()) {
			return "update-form";
		}
		
		CustomerEncoder.encodeInPlace(customer);
		
		try (Session session = factory.getCurrentSession()) {
			session.beginTransaction();
			
			Customer c = session.get(Customer.class, id);
			if(c != null) {
				c.setEmail(customer.getEmail());
				c.setFirstName(customer.getFirstName());
				c.setLastName(customer.getLastName());
			} else {
				System.out.println("No customer found with id: " + id);
			}
			
			session.getTransaction().commit();
			return "redirect:../list";
		} catch(Exception ex) {
			System.err.println("\nException occurred while updating customer with id " + customer.getId() + ": " + ex.getMessage());
			return "error";
		}
	}
	
	@RequestMapping(path="/delete/{id}", method=RequestMethod.POST)
	public String deleteCustomer(@PathVariable int id) {
		try (Session session = factory.getCurrentSession();) {
			session.beginTransaction();
			
			Customer c = session.get(Customer.class, id);
			if(c != null) {
				System.out.println("Deleting Customer: " + c);
				session.delete(c);
			}
			
			session.getTransaction().commit();
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
