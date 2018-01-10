package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			Student s = new Student("Paul", "Wall", "paul@luv2code.com");
			System.out.println("Created Student: " + s);
			session.beginTransaction();
			
			System.out.println("Saving the student");
			session.save(s);
			System.out.println("Done saving");
			
			session.getTransaction().commit();
			System.out.println("Transaction completed!");
		} finally {
			factory.close();
		}
	}

}
