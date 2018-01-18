package com.luv2code.data;

import java.util.List;

import com.luv2code.dto.Customer;

public interface CustomerRepository {
	public Customer get(int id) throws Exception;
	public void addNew(com.luv2code.dto.Customer customer) throws Exception;
	public void update(int id, com.luv2code.dto.Customer customer) throws Exception;
	public void delete(int id) throws Exception;
	public List<Customer> getAll() throws Exception;
}
