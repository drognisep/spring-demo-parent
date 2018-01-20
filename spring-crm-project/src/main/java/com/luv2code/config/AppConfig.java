package com.luv2code.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.luv2code.data.CustomerRepository;
import com.luv2code.data.EntityDtoConverter;
import com.luv2code.data.impl.CustomerRepositoryHibernate;
import com.luv2code.data.util.CustomerConverter;
import com.luv2code.dto.Customer;
import com.luv2code.entities.CustomerEntity;

@Configuration
public class AppConfig {
	@Bean
	public SessionFactory customerSessionFactory() {
		SessionFactory factory = new org.hibernate.cfg.Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(CustomerEntity.class)
				.buildSessionFactory();
		return factory;
	}
	
	@Bean
	public EntityDtoConverter<CustomerEntity, Customer> customerConverter() {
		return new CustomerConverter();
	}
	
	@Bean
	public CustomerRepository customerRepository() {
		return new CustomerRepositoryHibernate();
	}
}
