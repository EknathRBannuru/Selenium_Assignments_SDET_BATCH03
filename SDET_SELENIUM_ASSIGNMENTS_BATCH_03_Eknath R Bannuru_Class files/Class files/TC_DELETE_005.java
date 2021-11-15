package com.qa.tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class TC_DELETE_005 {
	
	
	@Test
	public void test_01() {
		
		
		when().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();
	}

}
