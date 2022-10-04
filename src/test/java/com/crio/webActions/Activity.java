package com.crio.webActions;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;



public class Activity {
	// @Test
	public void getRequest() {
		RestAssured.baseURI = "https://crio-qkart-backend-qa.herokuapp.com";

		RestAssured.basePath = "/api/v1/products";

		RequestSpecification http = RestAssured.given();

		Response response = http.get();

		int responseStatusCode = response.getStatusCode();

		if (responseStatusCode == 200) {
			System.out.println("The API call was successful");
		} else {
			System.out.println("The API call Failed");
		}

		String responseString = response.getBody().asString();
		System.out.println(responseString);


		String contentType = response.getHeader("Content-Type");
		System.out.println(contentType);
	}

	// @Test
	public void getRequestWithParams() {
		RestAssured.baseURI = "https://crio-qkart-backend-qa.herokuapp.com";

		RestAssured.basePath = "/api/v1/products/search";

		RequestSpecification http = RestAssured.given().queryParam("value", "book");

		Response response = http.get();

		int responseStatusCode = response.getStatusCode();

		if (responseStatusCode == 200) {
			System.out.println("The API call was successful");
		} else {
			System.out.println("The API call Failed");
		}

		String responseString = response.getBody().asString();
		System.out.println(responseString);
	}

	// @Test
	public void basicAuth() {
		// RequestSpecification httpRequest = RestAssured.given();
		RequestSpecification httpRequest = RestAssured.given().auth().basic("postman", "password");

		Response res = httpRequest.get("https://postman-echo.com/basic-auth");
		String rbdy = res.body().asString();
		System.out.println("Data from the GET API- " + rbdy);

	}

	@Test
	public void bearerToken() {
		String token =
				"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6ImNyaW8tdXNlcnMiLCJpYXQiOjE2NjQ4NjY0MjksImV4cCI6MTY2NDg4ODAyOX0.rYG88yc5uO2auKjHzgrQjdKjphNOU2Jfn_e_pa-Qc9o";

		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("Authorization", "Bearer " + token );

		Response response = httpRequest.get("https://crio-qkart-backend-qa.herokuapp.com/api/v1/user/addresses");

		int responseStatusCode = response.getStatusCode();
		if (responseStatusCode == 200) {
			System.out.println("The API call was successful");
		} else {
			System.out.println("The API call Failed");
		}
		String rbdy = response.body().asString();
		System.out.println("Data from the GET API- " + rbdy);
	}

}
