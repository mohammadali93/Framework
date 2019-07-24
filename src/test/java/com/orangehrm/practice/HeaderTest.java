package com.orangehrm.practice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HeaderTest {
	
	/*
	 * When I send GET resuest to the "/api/getAllStudentProfiles"
	 * Then response status code is 200
	 * And response header "Content-Type" contains "application/json";
	 */
	@Test
	public void task() {
		RestAssured.baseURI = "http://pure-ravine-92491.herokuapp.com/syntax";

		Response resp = 
				given().
				when().
					get("/api/getAllStudentProfiles");
		
		resp.then().assertThat().statusCode(200).
		and().header("Content-Type", equalTo("application/json;charset=UTF-8"));
		
	}
}
