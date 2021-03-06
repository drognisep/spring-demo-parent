package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			Instructor i = new Instructor("Susan", "Public", "susan.public@saylorsolutions.com");
			InstructorDetail id = new InstructorDetail("http://youtube.com", "Video Games");
			i.setInstructorDetail(id);
			
			System.out.println("Beginning transaction");
			session.beginTransaction();
			
			System.out.println("Saving Instructor and InstructorDetail");
			session.save(i);
			
			session.getTransaction().commit();
			System.out.println("Transaction completed!");
		} catch(Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			session.close();
			factory.close();
		}
	}

}
