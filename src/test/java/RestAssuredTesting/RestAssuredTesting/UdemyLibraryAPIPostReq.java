package RestAssuredTesting.RestAssuredTesting;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class UdemyLibraryAPIPostReq {
	
	@Test
	public void postRequest() {
		RestAssured.baseURI = "http://216.10.245.166";
		String response = given().log().all().header("Content-Type","application/json").
		body(Payload.addBook()).when().post("/Library/Addbook.php").
		then().log().all().statusCode(200).extract().response().asString();
		
		JsonPath jpath = new JsonPath(response);
		String isbn = jpath.get("isbn");
		System.out.println(isbn);
	}

}
