package RestAssuredTesting.RestAssuredTesting;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GetRequest {
	
	@Test
	public void getRequest() {		
		RestAssured.baseURI="http://restapi.adequateshop.com/api";
		RequestSpecification httpReq = RestAssured.given();
		Response response = httpReq.request(Method.GET,"/Tourist?page=2");
		
		/*System.out.println("reponse.getStatusCode "+response.getStatusCode());
		System.out.println("reponse.getStatusLine "+response.getStatusLine());
		System.out.println("header : "+response.getHeaders().toString());
		System.out.println("body : "+response.body().asString());*/
		
		//int totalrecord = response.jsonPath().get("totalrecord");
		//System.out.println("totalrecord : "+totalrecord);
		
		List<Map<String, Object>> list = response.jsonPath().get("data");
		//System.out.println("size : "+list);
		for(Map<String, Object> map : list) {	
			Integer id = (Integer)map.get("id");
			//System.out.println("id : "+id);
			System.out.println(map);
		}
	}

}
