package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 6;
			session.beginTransaction();
			
			System.out.println("Delete from Student where ID is: " + studentId);
			session.createQuery("delete from Student where id = " + studentId).executeUpdate();
			System.out.println("Student deleted");
			
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student s = session.get(Student.class, 1);
			session.delete(s);
			
			session.getTransaction().commit();
			
			System.out.println("Done");
		} finally {
			factory.close();
		}
	}

}
