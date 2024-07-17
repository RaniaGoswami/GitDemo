package RestAssuredTesting.RestAssuredTesting;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_PostRequest {
	
	@Test
	public void postRequest() {
		RestAssured.baseURI = "http://restapi.adequateshop.com/api";
		RequestSpecification httpReq = RestAssured.given();
		
		JSONObject reqBody = new JSONObject();
		reqBody.put("tourist_name", "Mike");
		reqBody.put("tourist_email", "tike124@gmail.com");
		reqBody.put("tourist_location", "Paris");
		
		httpReq.header("Content-Type","application/json");
		httpReq.body(reqBody.toJSONString());
		
		Response response = httpReq.request(Method.POST,"/Tourist");
		
		System.out.println(response.body().asString());
	}

}
