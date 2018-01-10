package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Student.class)
			.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			Student s = new Student("Daffy", "Duck", "daffy@luv2code.com");
			System.out.println("Created Student: " + s);
			session.beginTransaction();
			
			System.out.println("Saving the student");
			session.save(s);
			System.out.println("Done saving");
			
			session.getTransaction().commit();
			System.out.println("Save completed!");
			
			System.out.println("Assigned ID: " + s.getId());
			
			// Read it out again, need to get a new session for each transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("\nGet Student with id: " + s.getId());
			Student readStudent = session.get(Student.class, s.getId());
			
			System.out.println("Retrieved student: " + readStudent);
			
			session.getTransaction().commit();
			System.out.println("Done reading");
		} finally {
			factory.close();
		}
	}

}
