package RestAssuredTesting.RestAssuredTesting;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class TC005_PostRequest {
	
	@Test
	public void postRequest() {
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
		RequestSpecification req = RestAssured.given();
		/*JSONObject reqBody = new JSONObject();
		reqBody.put("id", 101);
		reqBody.put("employee_name", "abc");
		reqBody.put("employee_salary", 60000);
		reqBody.put("employee_age", 42);
		reqBody.put("profile_image", "");*/
		
		req.headers("content-type","application/json");
		//req.body(reqBody.toJSONString());
		
		Response response = req.request(Method.GET, "/employee/1");
		
		/*System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
		Headers allheaders = response.headers();
		for(Header header:allheaders) {
			System.out.println("header.getName() "+header.getName()+"   header.getValue()   "+header.getValue());
		}*/
		
		HashMap<String, Object> body = response.jsonPath().get("data");
		for(HashMap.Entry<String, Object> map:body.entrySet()) {
			System.out.println(map.getKey());
			System.out.println(map.getValue());
		}
	}

}
