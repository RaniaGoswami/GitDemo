package RestAssuredTesting.RestAssuredTesting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GetRequest {
	
	@Test
	public void getRequest() {
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
		RequestSpecification httpRegquest = RestAssured.given();
		Response response = httpRegquest.request(Method.GET,"/employees");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.header("content-type"));
		HashMap<String, Object> hm = response.jsonPath().get();
		System.out.println("outer Map:= "+hm);
		List<HashMap<String, Object>> list = response.jsonPath().get("data");
		HashMap<String, Object> m;
		for(int i =0;i<list.size();i++) {
			m = list.get(i);
			System.out.println("m.entrySet():= "+m.entrySet());
			for(Map.Entry<String, Object> entry : m.entrySet()) {
				System.out.println("entry.getValue():= "+entry.getValue());
			}
		}
		
	}

}
