package apiTry;

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
	GET_Or_Read_All_Product_usingObject2forCalling ReadCalling = new GET_Or_Read_All_Product_usingObject2forCalling();
	Put_Or_Update_Product_try updatecalling = new Put_Or_Update_Product_try();
	Del_Or_DElete__Product4 delete_product = new Del_Or_DElete__Product4();
	
 // need to create the soft assert class before the method and then it will
	// execute //soft assert is only avaliable in TestNG

	@Test
	public void Create_A_Products() throws InterruptedException {
		HashMap payload = new HashMap();
		payload.put("name", "Mt. Everest Dell LLAPTOP"); //payload is used to create
		payload.put("description", "Super Fast");
		payload.put("price", "5500");
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
			
		ReadCalling.read_All_Products_Calling("1349");
		updatecalling.Update_A_Products_1("1348");
		ReadCalling.read_All_Products_Calling("1348");
//		Thread.sleep(60000);
		delete_product.Delete_A_Products("1349");
		ReadCalling.read_All_Products_Calling("1349");
		
//		//ReadCalling.read_All_Products_Calling("1344");
//		updatecalling.Update_A_Products_1("ID_update");
//		ReadCalling.read_All_Products_Calling("ID_update");
//		delete_product.Delete_A_Products("delID");
	}
}