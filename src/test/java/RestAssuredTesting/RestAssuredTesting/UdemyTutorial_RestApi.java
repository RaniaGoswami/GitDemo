package RestAssuredTesting.RestAssuredTesting;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UdemyTutorial_RestApi {
	
	public static void main(String args[]) {		
		RestAssured.baseURI= "https://rahulshettyacademy.com";
		String address = "29, side layout, cohen 09";
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n" + 
				"\"location\": {\r\n" + 
				"\"lat\": -38.383494,\r\n" + 
				"\"lng\": 33.427362\r\n" + 
				"},\r\n" + 
				"\"accuracy\": 50,\r\n" + 
				"\r\n" + 
				"\"name\": \"Frontline house\",\r\n" + 
				"\"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
				"\"address\": \""+address+"\",\r\n" + 
				"\"types\": [\r\n" + 
				"\"shoe park\",\r\n" + 
				"\"shop\"\r\n" + 
				"],\r\n" + 
				"\"website\": \"https://rahulshettyacademy.com/\",\r\n" + 
				"\"language\": \"English\"\r\n" + 
				"}").when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println("Response  "+response);
		JsonPath jp = new JsonPath(response);
		String place_id = jp.get("place_id");		
		System.out.println("place_id    "+place_id);		
		
		given().log().all().queryParam("key", "qaclick123").queryParam("place_id", place_id)
		.when().get("maps/api/place/get/json").then().log()
		.all().assertThat().statusCode(200).body("address", equalTo(address));
		
		String newAddress = "Summer Walk, Africa";
		String putResponse = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n" + 
				"\"place_id\":\""+place_id+"\",\r\n" + 
				"\"address\":\""+newAddress+"\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}").when().put("maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println("putResponse    "+putResponse);
		JsonPath jpath1 = new JsonPath(putResponse);
		String putMessage = jpath1.get("msg");
		System.out.println(putMessage);
		
		
		
		
		
		
		/*String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -38.383494,\r\n" + 
				"    \"lng\": 33.427362\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"Rahul Shetty Academy\",\r\n" + 
				"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
				"  \"address\": \"29, side layout, cohen 09\",\r\n" + 
				"  \"types\": [\r\n" + 
				"    \"shoe park\",\r\n" + 
				"    \"shop\"\r\n" + 
				"  ],\r\n" + 
				"  \"website\": \"http://rahulshettyacademy.com\",\r\n" + 
				"  \"language\": \"French-IN\"\r\n" + 
				"}\r\n" + 
				"").when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();
		
		System.out.println(response);
		JsonPath js=new JsonPath(response); //for parsing Json
		String placeId=js.getString("place_id");
		
		System.out.println(placeId);
		
		//Update Place
		String newAddress = "Summer Walk, Africa";
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n" + 
				"\"place_id\":\""+placeId+"\",\r\n" + 
				"\"address\":\""+newAddress+"\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}").
		when().put("maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));*/
		
	}

}
