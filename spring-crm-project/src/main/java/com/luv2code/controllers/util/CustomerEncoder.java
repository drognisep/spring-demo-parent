package com.luv2code.controllers.util;

import org.owasp.encoder.Encode;

import com.luv2code.entities.Customer;

public class CustomerEncoder {
	public static Customer encode(Customer customer) {
		Customer cleanCustomer = new Customer();
		
		cleanCustomer.setEmail(Encode.forHtml(customer.getEmail()));
		cleanCustomer.setFirstName(Encode.forHtml(customer.getFirstName()));
		cleanCustomer.setLastName(Encode.forHtml(customer.getLastName()));
		
		return customer;
	}
	
	public static void encodeInPlace(Customer customer) {
		if(customer == null) return;
		
		customer.setEmail(Encode.forHtml(customer.getEmail()));
		customer.setFirstName(Encode.forHtml(customer.getFirstName()));
		customer.setLastName(Encode.forHtml(customer.getLastName()));
	}
}
