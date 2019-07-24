package com.orangehrm.practice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HamcrestTest {

	/*
	 * Retrieve quote of specific character (varys) and verify that response code is 200 
	 * and response contains "Do you lie awake at night fearing my gash?"
	 */
	
	@Test
	public void verifyResponse() {
		
		RestAssured.baseURI="https://got-quotes.herokuapp.com";
		
		//1 way using JUnit assertions
		Response rsp=
		given().
			queryParam("char", "varys").
		when().
			get("/quotes");
		
		int code=rsp.getStatusCode();
		Assert.assertEquals(200, code);
		
		String responseBody=rsp.asString();
		Assert.assertTrue(responseBody.contains("Varys"));
		
		//2 way to complete request * assertion
		given().
			queryParam("char", "varys").
		when().
			get("/quotes").
		then().
			assertThat().statusCode(200).
		and().
			assertThat().body("character", equalTo("Varys"));	
		
		//3 way
		Response rsp1=
		given().
			queryParam("char", "varys").
		when().
			get("/quotes");
		
		rsp1.then().
			assertThat().statusCode(200).
		and().
			body("character", equalTo("Varys"));
	}
	//retrieve student with id 123 & verify that response status code is 200 
	//and first name of a student is Vladimir
	
}