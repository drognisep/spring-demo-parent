package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			Student s1 = new Student("Mary", "Public", "mary@luv2code.com");
			Student s2 = new Student("John", "Doe", "paul@luv2code.com");
			Student s3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");
			session.beginTransaction();
			
			System.out.println("Saving the student");
			session.save(s1);
			session.save(s2);
			session.save(s3);
			System.out.println("Done saving");
			
			session.getTransaction().commit();
			System.out.println("Transaction completed!");
		} finally {
			factory.close();
		}
	}

}
