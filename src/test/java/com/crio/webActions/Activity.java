package com.crio.webActions;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;



public class Activity {
	@Test
	public void getRequest() {

	}

	// @Test
	public void getRequestWithParams() {
		
	}

	// @Test
	public void basicAuth() {
		RequestSpecification httpRequest = RestAssured.given();

		Response res = httpRequest.get("https://postman-echo.com/basic-auth");
		String rbdy = res.body().asString();
		System.out.println("Data from the GET API- " + rbdy);

	}

	// @Test
	public void bearerToken() {
	
	}

}
