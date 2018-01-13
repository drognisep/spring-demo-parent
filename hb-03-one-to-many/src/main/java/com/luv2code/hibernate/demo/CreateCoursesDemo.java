package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Beginning transaction");
			session.beginTransaction();
			
			Instructor instructor = session.get(Instructor.class, 1);
			
			Course[] courses = new Course[] {
					new Course("Air Guitar - The Ultimate Guide, part 2"),
					new Course("The Pinball Masterclass, FULL MASTERY!!!")
			};
			
			if(instructor != null) {
				System.out.println("Retrieved instructor: " + instructor);
				for(Course c : courses) {
					instructor.addCourse(c);
				}
			} else {
				throw new NullPointerException("Instructor is null!");
			}
			
			for(Course c : courses) {
				session.save(c);
			}
			
			session.getTransaction().commit();
			System.out.println("Transaction completed!");
		} catch(Exception e) {
			System.err.println("Exception occurred: " + e.getMessage());
			try {
				session.getTransaction().rollback();
			} catch (Exception e1) {
				System.err.println("Exception occurred during rollback: " + e1.getMessage());
			}
		} finally {
			session.close();
			factory.close();
		}
	}

}
