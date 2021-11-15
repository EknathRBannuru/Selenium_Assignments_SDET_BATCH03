package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TC_GET_001 {
	
	@Test
	public void test_01() {
		
		//Response res = RestAssured.get("https://reqres.in/api/users?page=100");
		
		Response res = get("https://reqres.in/api/users?page=2");
			
		System.out.println(res.asString());		
		
		ResponseBody body = res.getBody();
		System.out.println(body.asString());
		
		
		int statusCode = res.statusCode();
		System.out.println(statusCode);
		
		
		System.out.println(res.getHeader("content-type"));
		
		System.out.println(res.getStatusLine());
		
		long time = res.getTime();
		System.out.println(time);
		
		Assert.assertEquals(statusCode, 200);
		
		
	}
	
	
	
}
