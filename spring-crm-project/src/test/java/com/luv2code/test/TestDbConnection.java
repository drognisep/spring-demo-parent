package com.luv2code.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import java.sql.ResultSetMetaData;
import com.saylorsolutions.credutil.DbConfig;

public class TestDbConnection {

	private Connection conn;
	private Statement stmt;
	private ResultSet rset;

	@Test
	public final void testConnect() {
		try {
			Class.forName(DbConfig.driverClass);
			conn = DriverManager.getConnection(DbConfig.url, DbConfig.username, DbConfig.password);
			stmt = conn.createStatement();
			rset = stmt.executeQuery("SELECT * FROM customers");
			ResultSetMetaData rmeta = rset.getMetaData();
			int resultNum = 1;
			String resultFormat = "\t\"%s\": \"%s\",%n";
			while(rset.next()) {
				int columns = rmeta.getColumnCount();
				System.out.print("Result[" + resultNum++ + "]: {\n");
				for(int ii = 1; ii <= columns; ii++) {
					System.out.print(String.format(resultFormat, rmeta.getColumnName(ii), rset.getString(ii)));
				}
				System.out.println("}");
			}
		} catch (ClassNotFoundException cnfx) {
			cnfx.printStackTrace();
			fail(cnfx.getMessage());
		} catch (SQLException sqlx) {
			sqlx.printStackTrace();
			fail(sqlx.getMessage());
		} catch(Exception any) {
			fail("Unexpected exception occurred: " + any.getMessage());
		} finally {
			try {
				rset.close();
			} catch (Exception e) {
				System.err.println("Error closing result set: " + e.getMessage());
			}
			try {
				stmt.close();
			} catch (Exception e) {
				System.err.println("Error closing statement: " + e.getMessage());
			}
			try {
				conn.close();
			} catch (Exception e) {
				System.err.println("Error closing connection: " + e.getMessage());
			}
		}
		
	}

}
