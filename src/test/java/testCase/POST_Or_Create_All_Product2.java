package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class POST_Or_Create_All_Product2 {

	SoftAssert softAssert = new SoftAssert();
 // need to create the soft assert class before the method and then it will
	// execute //soft assert is only avaliable in TestNG

	@Test
	public void Create_A_Products() {
		HashMap payload = new HashMap();
		payload.put("name", "Kathmandu HPP LLAPTOP"); //payload is used to create
		payload.put("description", "Super Fast");
		payload.put("price", "$1100");
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
						.baseUri("https://techfios.com/api-prod/api/product/")
						.header("Content-Type", "application/json; charset=UTF-8")
						.body(payload)
				.when()
						.post("/create.php")
				.then()
						.extract().response();

		int statusCode = response.getStatusCode();
		System.out.println("==================" + response.getHeaders());	
		System.out.println("Status Code: " + statusCode);
		softAssert.assertEquals(statusCode, 201, "statusCode does not match !!"); // Assert.assertEquals(statusCode, 200);
	
// String responseBody = response.getBody().prettyPrint();
// System.out.println(responseBody);
// softAssert.assertEquals(statusCode, 201, "Not Matching"); - Worng one

		String responseBody = response.getBody().asString();
		System.out.println("Response Body " + responseBody);

// Parsing responseBody to Jason:
		JsonPath js = new JsonPath(responseBody); // this will help us to do in a jason format and can also do it
		Assert.assertEquals(js.get("message"), "Product was created.");											// individual.

	}
}