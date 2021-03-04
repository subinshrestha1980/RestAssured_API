package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class Del_Or_DElete__Product4 {

	SoftAssert softAssert = new SoftAssert();
	GET_Or_Read_All_Product_usingObject2forCalling calling = new GET_Or_Read_All_Product_usingObject2forCalling();
	
	//GET_Or_Read_All_Product_usingObject2forCalling makingObj2 = new GET_Or_Read_All_Product_usingObject2forCalling();
	
 // need to create the soft assert class before the method and then it will
	// execute //soft assert is only avaliable in TestNG
//https://techfios.com/api-prod/api/product/delete.php
	@Test
	public void Delete_A_Products() {
		HashMap payload = new HashMap();
		payload.put("id", "1305");
//		payload.put("name", "Kathmandu Nepal HPP LLAPTOP"); //payload is used to create
//		payload.put("description", "Super Super Fast");
//		payload.put("price", "$1500");
//		payload.put("category_id", "2");
//		payload.put("category_name", "Electronics");
		
		/*
		 * Base URL/URI, Endpoint/Resource, Headers,  
		 * Http Methods:GET,POST,PUT,DELETE Payload/Body given: all input details (Base URL/URI,
		 * Headers, Payload/Body, QueryParameters) 
		 * when: Submit api requests 
		 * http methods(GET/POST/PUT/DELETE), endpoint/resource) then: validate the
		 * response(statusCode,Headers, Payload/Body, responseTime)
		 */
// https://techfios.com/api-prod/api/product/create.php

		Response response = // creating an object and then storing all the given, when and then in variable
							// response. if you do not want then it is ok not to put as well.
				given()
						.baseUri("https://techfios.com/api-prod/api/product")
						.header("Content-Type", "application/json; charset=UTF-8")
						.body(payload)
				.when()
						.delete("/delete.php")
				.then()
						.extract().response();

		int statusCode = response.getStatusCode();
		System.out.println("==================" + response.getHeaders());	
		System.out.println("Status Code: " + statusCode);
		softAssert.assertEquals(statusCode, 200, "statusCode does not match !!"); // Assert.assertEquals(statusCode, 200);
	
		String responseBody = response.getBody().asString();
		System.out.println("Response Body " + responseBody);

		calling.read_All_Products_Calling("1305");
		
		// Parsing responseBody to Jason:

	}
}

// js.prettyPrint();

// System.out.println(js);

//		long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS);
//		System.out.println("Response Time: " + responseTime);
//		if (responseTime <= 1000) {
//			System.out.println("ResonseTime is with in the Range");
//		} else {
//			System.out.println("Not Acceptable !!");
//		}
