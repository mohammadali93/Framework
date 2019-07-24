package com.orangehrm.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class ProcessResulSet {
	String dbUrl = "jdbc:oracle:thin:@syntaxdatabase.cdjflmucstpo.us-east-1.rds.amazonaws.com:1521:orcl";
	String dbUsername = "Syntax";
	String dbPassword = "syntax123";

	//@Test
	public void getResultSetData() throws SQLException {

		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT FIRST_NAME, LAST_NAME FROM EMPLOYEES WHERE JOB_ID='IT_PROG'");

		List<Map<String, String>> rsList = new ArrayList<>();

		while (rs.next()) {
			Map<String, String> rsMap = new HashMap<>();
			rsMap.put("FIRST_NAME", rs.getString("FIRST_NAME"));
			rsMap.put("Last_name", rs.getString("Last_name"));
			rsList.add(rsMap);
		}

		System.out.println(rsList);

		rs.close();
		st.close(); 
		conn.close();
	}
	//process query that will give result of street address, city and country name
	//and store results inside the list
	
	//@Test
	public void review() {
		
		Map<String, String> map=new HashMap<String, String>();
		map.put("first_name", "Alexander");
		map.put("last_name", "Bruce");
		map.put("middle_name", "David");
		
		System.out.println(map.size());
		System.out.println(map);
	}
	
	//@Test
	public void getResultSetData1() throws SQLException {

		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = conn.createStatement();
		
		String query="SELECT STREET_ADDRESS, CITY, COUNTRY_NAME FROM LOCATIONS L JOIN COUNTRIES C ON L.COUNTRY_ID=C.COUNTRY_ID";
		ResultSet rs = st.executeQuery(query);

		List<Map<String, String>> rsList = new ArrayList<>();

		while (rs.next()) {
			Map<String, String> rsMap = new HashMap<>();
			rsMap.put("STREET_ADDRESS", rs.getString("STREET_ADDRESS"));
			rsMap.put("CITY", rs.getString("CITY"));
			rsMap.put("COUNTRY_NAME", rs.getString("COUNTRY_NAME"));
			rsList.add(rsMap);
		}

		System.out.println(rsList);

		rs.close();
		st.close(); 
		conn.close();
	}
	
	@Test
	public void getResultSetData2() throws SQLException {

		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = conn.createStatement();
		
		String query="SELECT * FROM JOBS";
		ResultSet rs = st.executeQuery(query);
		ResultSetMetaData rsMetaData = rs.getMetaData();

		List<Map<String, String>> rsList = new ArrayList<>();

		while (rs.next()) {
			
			Map<String, String> rsMap = new HashMap<>();
			
			for (int i=1; i<= rsMetaData.getColumnCount(); i++) {
				
				rsMap.put(rsMetaData.getColumnName(i), rs.getObject(i).toString());
				
			}
		
			rsList.add(rsMap);
		}

		System.out.println(rsList);

		rs.close();
		st.close(); 
		conn.close();
	}
}
