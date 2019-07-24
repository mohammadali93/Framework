package com.orangehrm.practice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JsonPathTest {

	@Test
	public void hmp()
	{
		RestAssured.baseURI="http://pure-ravine-92491.herokuapp.com/syntax";
		
		Response rsp1=
				given().pathParam("studentId", "123").
		
				when().
					get("/api/getStudentProfile/{studentId}");
				
				rsp1.then().
					assertThat().statusCode(200).
				and().
					body("firstName", equalTo("Vladimir"));
				//System.out.println(rsp1.prettyPrint());
				
				JsonPath jPath= rsp1.jsonPath();
				
				String firstName= jPath.getString("firstName");
				System.out.println(firstName);
				
			String lastName= jPath.getString("lastName");
			System.out.println(lastName);
				
	}
	@Test
	public void getALlStudents() {
		
		RestAssured.baseURI="http://pure-ravine-92491.herokuapp.com/syntax";
	       
        Response resp=
        given().
        when().
        	get("/api/getAllStudentProfiles");
        
        resp.prettyPrint();
        
        JsonPath jPath=resp.jsonPath();
		//get value of last name in 3 object 
       String name= jPath.get("lastName[2]");
       System.out.println(name);
       
       List<String> fName = jPath.get("firstName");
       
       for(String name1: fName) {
    	   System.out.println(name1);
       }
       
	}
}
