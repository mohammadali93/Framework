package com.orangehrm.practice;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class ApiGetDemo {

	@Test
	public void getWeather()
	{
		// get method will give you back response 
		Response response= RestAssured.when().get("http://restapi.demoqa.com/utilities/weather/city/Fairfax");
		
		response.prettyPrint();
		int code= response.getStatusCode();
		System.out.println(code);
	}
	
	@Test
	public void getCity()
	{
		Response response= RestAssured.when().get("http://restcountries.eu/rest/v1/name/Pakistan");
		
		//response.prettyPrint();
		
		//get status code
		int code = response.getStatusCode();
		Assert.assertEquals(200, code );
		
		//retrieve body response as String
		String body= response.asString();
		System.out.println(body);
		
		Assert.assertTrue(body.contains("Islamabad"));
		
		//retrieving the header
		String header=response.getHeader("Date");
		System.out.println(header);
		
	}
	
	
}
