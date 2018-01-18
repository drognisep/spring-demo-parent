package com.luv2code.data.util;

import com.luv2code.data.EntityDtoConverter;
import com.luv2code.dto.Customer;
import com.luv2code.entities.CustomerEntity;

public class CustomerConverter implements EntityDtoConverter<CustomerEntity, Customer> {
	public CustomerEntity toEntity(Customer customer) {
		CustomerEntity e = new CustomerEntity();
		e.setId(customer.getId());
		e.setFirstName(customer.getFirstName());
		e.setLastName(customer.getLastName());
		e.setEmail(customer.getEmail());
		return e;
	}
	
	public CustomerEntity toEntityWithoutId(Customer customer) {
		CustomerEntity e = new CustomerEntity();
		e.setFirstName(customer.getFirstName());
		e.setLastName(customer.getLastName());
		e.setEmail(customer.getEmail());
		return e;
	}
	
	public Customer toDto(CustomerEntity entity) {
		Customer dto = new Customer();
		dto.setId(entity.getId());
		dto.setFirstName(entity.getFirstName());
		dto.setLastName(entity.getLastName());
		dto.setEmail(entity.getEmail());
		return dto;
	}
	
	public CustomerEntity copyFields(CustomerEntity entity, Customer customer) {
		entity.setFirstName(customer.getFirstName());
		entity.setLastName(customer.getLastName());
		entity.setEmail(customer.getEmail());
		return entity;
	}
}
