package RestAssuredTesting.RestAssuredTesting;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC008_PUT_Delete {
	
	public static String id;
	public static String employee_name;
	public static String employee_salary;
	public static String employee_age;
	
	@BeforeTest
	public void createEmpData() {
		id = RandomStringUtils.randomNumeric(2);
		employee_name = RandomStringUtils.randomAlphabetic(4);
		employee_salary = RandomStringUtils.randomNumeric(5);
		employee_age = RandomStringUtils.randomNumeric(2);
	}
	
	@Test
	public void putEmpRecord() {
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RequestSpecification req = RestAssured.given();
		/*JSONObject reqBody = new JSONObject();
		reqBody.put("id",1);
		reqBody.put("employee_name",employee_name);
		reqBody.put("employee_salary",employee_salary);
		reqBody.put("employee_age",employee_age);		
		req.header("content-type","application/json");
		req.body(reqBody.toJSONString());
		Response resp = req.request(Method.PUT,"/employees");*/
		Response resp = req.request(Method.GET,"/employees");
		//System.out.println(resp.getBody().asString());
		JsonPath jsonPathObject = resp.jsonPath();
		String empId = jsonPathObject.getString("[2]");
		System.out.println(empId);
		/*resp = req.request(Method.DELETE,"/delete/"+empId);
		System.out.println(resp.getBody().asString());*/
	}

}
