package apiTry;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*; // we need to create it by ourself.  * means it will call all the Maven Dependency in RestRessure.

import java.util.concurrent.TimeUnit;

public class GET_Or_Read_All_Product_usingObject2forCalling {

	SoftAssert softAssert = new SoftAssert(); // need to create the soft assert class before the method and then it will
												// execute //soft assert is only avaliable in TestNG

	@Test
	public void read_All_Products_Calling(String IDcalling) {
		//String QueryId= "1305";
		/*
		 * Base URL/URI, Endpoint/Resource, Headers, QueryParameters Http Methods:
		 * GET,POST,PUT,DELETE Payload/Body given: all input details (Base URL/URI,
		 * Headers, Payload/Body, QueryParameters) when: Submit api requests (http
		 * methods(GET/POST/PUT/DELETE), endpoint/resource) then: validate the
		 * response(statusCode,Headers, Payload/Body, responseTime)
		 */
		// https://techfios.com/api-prod/api/product/read.php

		Response response = // creating an object and then storing all the given, when and then in variable
							// response. if you do not want then it is ok not to put as well.
				given()

						.baseUri("https://techfios.com/api-prod/api/product/")
						.header("Content-Type", "application/json; charset=UTF-8").queryParam("id", IDcalling)
				.when()
						.get("/read_one.php")
				.then()
						.header("Keep-Alive", "timeout=5, max=75").extract().response();

		int statusCode = response.getStatusCode();
		System.out.println("Status Code: " + statusCode);
		// Assert.assertEquals(statusCode, 200);
		softAssert.assertEquals(statusCode, 201, statusCode);
		 String responseBody = response.getBody().prettyPrint(); //preety print will print
		 //System.out.println(responseBody);
		 softAssert.assertEquals(statusCode, 201, "Not Matching"); //- Worng one
//
//		String responseBody = response.getBody().asString();
//		System.out.println("Response Body " + responseBody);

		String responseHeader = response.header("Content-Type");
		System.out.println(responseHeader);
		softAssert.assertEquals(responseHeader, "application/json");
		softAssert.assertEquals(responseHeader, "application/json", "Header Mismatch =====");

		// Parsing responseBody to Jason:
		JsonPath js = new JsonPath(responseBody); // this will help us to do in a jason format and can also do it
													// individual.

		String productId = js.getString("id");
		String productname = js.getString("name");
		String productDescription = js.getString("description");
//
//		// Assert.assertEquals(productId,"1209");
//		// Assert.assertEquals(productname,"HP Laptop Elite Pro"); // neeed to work here
//		// Assert.assertEquals(productDescription,"Super fast laptop"); // neeed to work
//		// here
//
//		softAssert.assertEquals(productId, "1209"); // No need to put the resonseHeader becasue it is the assert of
//													// body.
//		softAssert.assertEquals(productname, "HP Laptop Elite Proo", "Product Name mismatch ======"); //
//		softAssert.assertEquals(productDescription, "Super fast laptop", "productDescription Missmatch !!!!!!!!");
//		softAssert.assertAll(); // if you want your assert fail then you have to put this line in other code at
//								// the button.
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
