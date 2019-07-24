package com.orangehrm.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class JdbcDemo {

	String dbUrl = "jdbc:oracle:thin:@syntaxdatabase.cdjflmucstpo.us-east-1.rds.amazonaws.com:1521:orcl";

	String dbUsername = "Syntax";

	String dbPassword = "syntax123";

	//@Test
	public void dbConnection() throws SQLException {
		// creating connection
		Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

		// create a statement
		Statement statement = connection.createStatement();

		// execute Query and store results from database in ResultSet object
		ResultSet resultSet = statement.executeQuery("Select * from Countries");

		// get values from resultSet
		resultSet.next();
		String columData = resultSet.getString("Country_Name");
		System.out.println(columData);

		resultSet.next();
		columData = resultSet.getString("Country_Name");
		System.out.println(columData);

		System.out.println("---Printing values using loop-");
		while (resultSet.next()) {
			columData = resultSet.getString("Country_Name");
			System.out.println(columData);
		}

		// close all db connections
		resultSet.close();
		statement.close();
		connection.close();

	}

	@Test
	 public void printRowData() throws SQLException {
		 
		Connection conn=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		
		Statement statement=conn.createStatement();
		
		ResultSet rs=statement.executeQuery("SELECT DEPARTMENT_ID, DEPARTMENT_NAME FROM DEPARTMENTS");
		
		while(rs.next()) {
			int dep_id=rs.getInt("DEPARTMENT_ID");
			String dep_name=rs.getString("DEPARTMENT_NAME");
			
			System.out.println(dep_id+"   "+dep_name);
		}
		
		rs.close();
		statement.close();
		conn.close();
	 }
}