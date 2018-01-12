package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Beginning transaction");
			session.beginTransaction();
			
			int id = 30;
			InstructorDetail detail = session.get(InstructorDetail.class, id); // Will be null
			
			System.out.println(detail);
			System.out.println("Associated Instructor: " + detail.getInstructor());
			
			session.getTransaction().commit();
			System.out.println("Transaction completed!");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}

}
