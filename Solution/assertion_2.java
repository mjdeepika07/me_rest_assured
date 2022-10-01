import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;


public class assertion_2 {

@Test

public void verify(){

    RestAssured.baseURI = "https://crio-qkart-backend-qa.herokuapp.com/api/v1/products/34sLtEcMpzabRyfx";


    RequestSpecification http = RestAssured.given();
    Response response = http.request(Method.GET);

    response.then().body("name", equalTo("Thinking, Fast and Slow"));


    }
}
