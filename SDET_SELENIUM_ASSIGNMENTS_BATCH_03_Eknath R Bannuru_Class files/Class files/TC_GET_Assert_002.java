package com.qa.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.Test;

public class TC_GET_Assert_002 {
	
	
	@Test
	public void test_01() {
		
		// Validating the statusCode
		
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200).log().all();
		
		//Multiple assertions --> statusCode, ID value at an index position & list values present in an array...
		
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data.id[1]",equalTo(8))
		.body("data.first_name", hasItems("Michael","Byron")).log().all();
		
		
		
	}


}
