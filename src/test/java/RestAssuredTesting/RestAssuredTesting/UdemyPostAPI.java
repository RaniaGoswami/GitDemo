package RestAssuredTesting.RestAssuredTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.restAssured.ReusableMethod;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;


public class UdemyPostAPI {	
	@Test(dataProvider = "getData")
	public void postApi(String isbn, String aisle) {
		
		RestAssured.baseURI = "http://216.10.245.166/";
		String resp = given().header("Content-Type","application/json").
				body(Payload.addBook(isbn,aisle)).when().post("Library/Addbook.php").
				then().statusCode(200).extract().response().asString();
	/*	JsonPath jpath = ReusableMethod.rawToJson(resp);
		//System.out.println(jpath.get("msg"));
		System.out.println(jpath.toString());*/
		System.out.println(resp);
	}
	
	@DataProvider
	public Object[][] getData(){
		return new Object[][]{{"rert","845"},{"tqf","8787"},{"bzcvbz","212"}};
		
	}
}
