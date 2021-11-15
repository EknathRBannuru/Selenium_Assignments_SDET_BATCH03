package com.qa.tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;


public class TC_PUT_004 {

	@Test
	public void test_01(){
		JSONObject req = new JSONObject();

		req.put("name", "Roger");
		req.put("job", "QA lead");
		
		
		/*
		 * given() .body(req.toJSONString()).when()
		 * .put("https://reqres.in/api/users/2").then().statusCode(200).log().all();
		 */
		given()
		.body(req.toJSONString()).when()
		.patch("https://reqres.in/api/users/2").then().statusCode(200).log().all();
		
	}

}
