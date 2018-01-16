package com.luv2code.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.luv2code.entities.Customer;

@Configuration
public class AppConfig {
	@Bean
	public SessionFactory customerSessionFactory() {
		SessionFactory factory = new org.hibernate.cfg.Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Customer.class)
				.buildSessionFactory();
		return factory;
	}
}
