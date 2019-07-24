package com.orangehrm.practice;

import static io.restassured.RestAssured.given;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JsonTask {

	/*Retreive all students and verify that GET response code is 200 
	 * and retrieve first name of a second student
	 * Retrieve all students lastName;
	 */
	
	
	@Test
	public void task()
	{
		RestAssured.baseURI="http://pure-ravine-92491.herokuapp.com/syntax";
	       
        Response resp=
        given().
        when().
        	get("/api/getAllStudentProfiles");
        
        resp.prettyPrint();
        
        JsonPath jPath=resp.jsonPath();
        
       String fName = jPath.getString("firstName");
        System.out.println(fName);
        
        
        Assert.assertEquals(200, resp.getStatusCode());
        
	
        
        System.out.println("-----------------PRINTING FIRST NAME FROM INDEX 2------------");
        String name= jPath.getString("firstName[1]");
        System.out.println(name);
	
	

	System.out.println("-----------------PRINTING LAST NAME FOR ALL STUDENTS------------");
    String lname= jPath.getString("lastName");
 System.out.print(lname);
}
}