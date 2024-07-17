package RestAssuredTesting.RestAssuredTesting;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004PostRequest {

	@Test
	public void postRequest() {
	RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
	RequestSpecification request = RestAssured.given();
	
	JSONObject reqBody = new JSONObject();
	reqBody.put("name","test");
	reqBody.put("salary","123");
	reqBody.put("age","23");
	
	request.header("content-type","application/json");
	request.body(reqBody.toJSONString());
	
	Response response = request.request(Method.POST,"/create");
	
	System.out.println(response.body().asString());
	}
}
