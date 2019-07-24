package com.orangehrm.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class MetaDataDemo {

	String dbUrl = "jdbc:oracle:thin:@syntaxdatabase.cdjflmucstpo.us-east-1.rds.amazonaws.com:1521:orcl";

	String dbUsername = "Syntax";

	String dbPassword = "syntax123";

	@Test
	public void getMetaData() throws SQLException {

		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

		DatabaseMetaData dbMetaData = conn.getMetaData();
		// print database name
		String dbName = dbMetaData.getDatabaseProductName();
		System.out.println(dbName);
		// print database version
		String dbVersion = dbMetaData.getDatabaseProductVersion();
		System.out.println(dbVersion);
		// ------------------------------------------------------

		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM EMPLOYEES WHERE JOB_ID='IT_PROG'");

		ResultSetMetaData rsMetaData = rs.getMetaData();
		//get total # or cols
		int colNum = rsMetaData.getColumnCount();
		System.out.println(colNum);

		//get name of specified column
		String colName=rsMetaData.getColumnName(2);
		System.out.println(colName);
		
		//print all column names
		System.out.println("----Printing all column names using loop-----");
		for (int i=1; i<=colNum; i++ ) {
			colName=rsMetaData.getColumnName(i);
			System.out.println(colName);
		}
		
		rs.close();
		st.close();
		conn.close();
	}
}
