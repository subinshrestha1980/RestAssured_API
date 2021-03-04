package testCase;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GET_Or_Read_All_Product {

	@Test
	public void read_All_Products() {
		
		/*Base URL/URI
		Endpoint/Resource
		Headers
		QueryParameters
		Http Methods: GET,POST,PUT,DELETE
		Payload/Body

		given: all input details (Base URL/URI, Headers, Payload/Body, QueryParameters)
		when: Submit api requests (http methods(GET/POST/PUT/DELETE), endpoint/resource)
		then: validate the response(statusCode,Headers, Payload/Body, responseTime)
*/
		//https://techfios.com/api-prod/api/product/read.php
		
		Response respose =  //creating an object and then storing all the given, when and then in variable response. if you do not want then it is ok not to put as well. 
		given()
			//.log().all()
			.log().uri()
			.baseUri("https://techfios.com/api-prod/api/product/")
			.header("Content-Type","application/json; charset=UTF-8")
		.when()
			//.log().all()
			.get("/read.php")
		.then()
			//.log().all()
			.log().status()
			.statusCode(200)
			.header("Content-Type","application/json; charset=UTF-8")
			.header("Keep-Alive","timeout=5, max=75")
			.extract().response();
}
}