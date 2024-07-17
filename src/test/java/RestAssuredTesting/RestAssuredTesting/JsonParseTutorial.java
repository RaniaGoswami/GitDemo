package RestAssuredTesting.RestAssuredTesting;

import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class JsonParseTutorial {
	
	public static void main(String args[]) {
		
		JsonPath jpath = new JsonPath(Payload.addPayload());
		
		//Print No of courses returned by API
		int totalCourseSize = jpath.getInt("courses.size()");
		System.out.println("totalCourseSize   "+totalCourseSize);
		
		//Print Purchase Amount
		int totalpurchaseAmount = jpath.getInt("dashboard.purchaseAmount");
		System.out.println("totalpurchaseAmount   "+totalpurchaseAmount);
		
		//Print Title of the first course
		String firstCousetitle = jpath.get("courses[0].title");
		System.out.println("firstCousetitle   "+firstCousetitle);
		
		//Print All course titles and their respective Prices		
		for(int i = 0; i<totalCourseSize; i++) {
			System.out.println(jpath.get("courses["+i+"].title"));
			System.out.println(jpath.getInt("courses["+i+"].price"));			
		}	
		
		//Print no of copies sold by RPA Course
		for(int i = 0; i<totalCourseSize; i++) {
			if(jpath.get("courses["+i+"].title").equals("RPA")) {
				int copyofRPA = jpath.getInt("courses["+i+"].copies");
				System.out.println("copyofRPA      "+copyofRPA);
			}
		}
		
		//Verify if Sum of all Course prices matches with Purchase Amount
		int totalSum = 0;
		for(int i = 0; i<totalCourseSize; i++) {
			int price = jpath.getInt("courses["+i+"].price");
			int copy = jpath.getInt("courses["+i+"].copies");
			int sum = price*copy;
			totalSum = totalSum+sum;			
		}
		System.out.println("sum of courses prices  "+totalSum);
		
		Assert.assertEquals(totalpurchaseAmount, totalSum);
	}

}
