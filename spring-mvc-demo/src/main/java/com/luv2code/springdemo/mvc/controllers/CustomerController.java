package com.luv2code.springdemo.mvc.controllers;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.mvc.beans.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping("/showForm")
	public String showForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer-form";
	}

	@RequestMapping("/processForm")
	public String processForm(
			@Valid @ModelAttribute("customer") Customer customer, 
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println("\nBinding Result Errors: " + bindingResult + "\n");
			return "customer-form";
		}
		System.out.println("Valid: " + customer);
		return "customer-confirmation";
	}
}
