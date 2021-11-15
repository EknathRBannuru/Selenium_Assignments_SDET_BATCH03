package com.qa.tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.util.HashMap;
import java.util.Map;

public class TC_POST_003 {

	@Test(enabled=false)
	public void test_01() {

		// POST : create a new resource in the server

		//1st way by creating Map

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Kim Smith");
		map.put("job", "QA lead");

		//System.out.println(map);

		JSONObject req = new JSONObject(map);
		//System.out.println(req);
		System.out.println(req.toJSONString());



		/*
		 * given().body(req.toJSONString()).when().post("https://reqres.in/api/users")
		 * .then().statusCode(201).log().all();
		 */
		// 201 is the status code for creating a new record

		given()
		.header("content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(req.toJSONString()).when().post("https://reqres.in/api/users")
		.then().statusCode(201).log().all();


	}

	
	
	@Test
	public void test_02() {

		// POST : create a new resource in the server

		
		JSONObject req = new JSONObject();
		
		req.put("name", "Roger");
		req.put("job", "QA lead");


		/*
		 * given().body(req.toJSONString()).when().post("https://reqres.in/api/users")
		 * .then().statusCode(201).log().all();
		 */
		// 201 is the status code for creating a new record

		given()
		.header("content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(req.toJSONString()).when().post("https://reqres.in/api/users")
		.then().statusCode(201).log().all();


	}
}
