package RestAssuredTesting.RestAssuredTesting;

import org.testng.annotations.Test;

import com.restAssured.ReusableMethod;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class UdemyLibraryApiGetReq {
	
	@Test
	public void getReq() {
		RestAssured.baseURI = "http://216.10.245.166";
		String resp = given().when().get("Library/GetBook.php?AuthorName=John foe").
		then().statusCode(200).assertThat().header("Transfer-Encoding", "chunked").extract().response().asString();
		
		JsonPath jpath = ReusableMethod.rawToJson(resp);
		List<Map> body = jpath.get();
		//System.out.println("Size of the body "+body.size());
		
		for(int i = 0; i<body.size(); i++) {
			Map<String,Object> hmap = body.get(i);
			System.out.println(hmap.get("book_name"));
		}		
	}

}
