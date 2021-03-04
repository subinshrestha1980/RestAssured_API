package restAssured_youtube;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Youtube_restAssrured {

	@Test
	public void testResponde() {

		Response resp = RestAssured
				.get("http://api.openweathermap.org/data/2.5/weather?q=London&appid=a53dee38c9f41a4c5257d2f70ec620fb");
		
		int code=resp.getStatusCode();
		
		System.out.println("Status code is " + code);
		
		Assert.assertEquals(code, 200);
}

	@Test
	public void test2Responde() {

		Response resp = RestAssured
				.get("http://api.openweathermap.org/data/2.5/weather?q=London&appid=a53dee38c9f41a4c5257d2f70ec620fb");

		//String body = resp.asString();
		long time = resp.getTime();
		
		resp.prettyPrint();

		// System.out.println(body);

	}
}
