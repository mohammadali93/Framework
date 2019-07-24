package com.orangehrm.practice;

import static io.restassured.RestAssured.given;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiParameters {
	//@Test
	public void queryParameters() {
		
		RestAssured.baseURI="https://reqres.in";
		
		Response resp=
				
				given().
					queryParam("page", "2").
				
				when().
					get("/api/users");
		//JUnit
		Assert.assertEquals(200, resp.getStatusCode());
		
		Assert.assertTrue(resp.asString().contains("Tracey"));
		
	}
	
	@Test
	public void pathParameters() {
		
		RestAssured.baseURI="https://reqres.in";
		
				given().pathParam("id", "3").
				when().get("/api/users/{id}").
				then().statusCode(200);
		
	}
}
