package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GET_Or_Read_All_Product_Individual {

	@Test
	public void read_All_Products() {
		
		/*Base URL/URI
		Endpoint/Resource
		Headers
		QueryParameters
		Http Methods: GET,POST,PUT,DELETE
		Payload/Body = the one we see in the body 

		given: all input details (Base URL/URI, Headers, Payload/Body, QueryParameters)
		when: Submit api requests (http methods(GET/POST/PUT/DELETE), endpoint/resource)
		then: validate the response(statusCode,Headers, Payload/Body, responseTime)
*/
		//https://techfios.com/api-prod/api/product/read_one.php?id=1209
		
		Response response =  //creating an object and then storing all the given, when and then in variable response. if you do not want then it is ok not to put as well. 
		given()
			//.log().all()
			.log().uri()
			.baseUri("https://techfios.com/api-prod/api/product/")
			.header("Content-Type","application/json; charset=UTF-8")
			.queryParam("id", "1299")
		.when()
			//.log().all()
			.get("/read_one.php")
		.then()
			//.log().all()
			//.log().status()
			.extract().response();
		
		int statusCode = response.getStatusCode();
		System.out.println("Status Code: " + statusCode);
		Assert.assertEquals(statusCode, 200);
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body " + responseBody);
		
}
}