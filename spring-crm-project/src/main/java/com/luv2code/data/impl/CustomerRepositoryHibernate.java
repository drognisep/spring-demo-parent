package com.luv2code.data.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.luv2code.data.CustomerRepository;
import com.luv2code.data.EntityDtoConverter;
import com.luv2code.dto.Customer;
import com.luv2code.entities.CustomerEntity;

@Component
public class CustomerRepositoryHibernate implements CustomerRepository {
	@Autowired
	private SessionFactory factory;
	
	@Autowired
	private EntityDtoConverter<CustomerEntity, Customer> converter;

	@Override
	public Customer get(int id) throws Exception {
		Customer val = null;
		try(Session session = factory.getCurrentSession()) {
			session.beginTransaction();
			CustomerEntity c = session.get(CustomerEntity.class, id);
			if(c == null) {
				System.err.println("Customer with id " + id + " not found");
				session.getTransaction().rollback();
				val = null;
			} else {
				session.getTransaction().commit();
				val = converter.toDto(c);
			}
		} catch(Exception ex) {
			throw new Exception("\nError getting customer with id " + id + ": " + ex.getMessage(), ex);
		}
		return val;
	}

	@Override
	public void addNew(Customer customer) throws Exception {
		if (customer != null) {
			try (Session session = factory.getCurrentSession()) {
				session.beginTransaction();
				CustomerEntity e = converter.toEntityWithoutId(customer);
				session.save(e);
				session.getTransaction().commit();
			} catch(Exception ex) {
				throw new Exception("\nError saving new Customer: " + ex.getMessage() + "\n", ex);
			}
		}
	}

	@Override
	public void update(int id, Customer customer) throws Exception {
		if(id >= 0 && customer != null) {
			try(Session session = factory.getCurrentSession()) {
				session.beginTransaction();
				CustomerEntity e = session.get(CustomerEntity.class, id);
				converter.copyFields(e, customer);
				session.getTransaction().commit();
			} catch(Exception ex) {
				throw new Exception("\nError updating Customer with id " + id + ": " + ex.getMessage() + "\n", ex);
			}
		}
	}

	@Override
	public void delete(int id) throws Exception {
		if(id >= 0) {
			try(Session session = factory.getCurrentSession()) {
				session.beginTransaction();
				CustomerEntity e = session.get(CustomerEntity.class, id);
				if (e != null) {
					session.delete(e);
				}
				session.getTransaction().commit();
			} catch(Exception ex) {
				throw new Exception("\nError deleting Customer with id " + id + ": " + ex.getMessage() + "\n", ex);
			}
		}
	}

	@Override
	public List<Customer> getAll() throws Exception {
		List<Customer> customers = new ArrayList<>();
		try(Session session = factory.getCurrentSession()) {
			session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<CustomerEntity> all = session.createQuery("from CustomerEntity").getResultList();
			for(CustomerEntity e : all) {
				customers.add(converter.toDto(e));
			}
			session.getTransaction().commit();
		} catch(Exception ex) {
			throw new Exception("\nError getting all Customers: " + ex.getMessage() + "\n", ex);
		}
		return customers;
	}
}
