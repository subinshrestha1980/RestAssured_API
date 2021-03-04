package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class Put_Or_Update__Product3 {

	SoftAssert softAssert = new SoftAssert();
	//GET_Or_Read_All_Product_usingObject2forCalling makingObj = new GET_Or_Read_All_Product_usingObject2forCalling();
	
 // need to create the soft assert class before the method and then it will
	// execute //soft assert is only avaliable in TestNG
//https://techfios.com/api-prod/api/product/update.php
	@Test
	public void Update_A_Products(String IDUpdate) {
		HashMap payload = new HashMap();
		payload.put("id", "1330");
		payload.put("name", "Subin Shrestha Dell LLAPTOP"); //payload is used to create
		payload.put("description", "Super Fast");
		payload.put("price", "2900");
		payload.put("category_id", "2");
		payload.put("category_name", "Electronics");
		
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
						.put("/update.php")
				.then()
						.extract().response();

				
	}
}

