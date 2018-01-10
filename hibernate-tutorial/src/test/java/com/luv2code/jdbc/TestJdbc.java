package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class TestJdbc {

	@Test
	public final void testConnect() throws Exception {
		String url = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		try(Connection conn = DriverManager.getConnection(url, user, pass);) {
			System.out.println("Connection successful");
		}
		
	}

}
