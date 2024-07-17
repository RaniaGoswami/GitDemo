package RestAssuredTesting.RestAssuredTesting;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC006_PostRequest {
	
	@Test
	public void postRequest() {
		RestAssured.baseURI = "http://restapi.adequateshop.com";
		PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
		RestAssured.authentication = auth;
		auth.setUserName("Developer5@gmail.com");
		auth.setPassword("123456");
		RequestSpecification req = RestAssured.given();
		JSONObject reqBody = new JSONObject();
		reqBody.put("$id", 101);
		reqBody.put("Id", 8888);
		reqBody.put("Name", "kHGD");
		reqBody.put("Email", "gdgf@hhjd.com");
		reqBody.put("Token", "564415255");
		req.header("content-type","application/json");
		req.body(reqBody.toJSONString());
		
		Response resp = req.request(Method.POST,"/api/authaccount/login");
		System.out.println(resp.jsonPath().get().toString());
		
	}

}
