package RestAssuredTesting.RestAssuredTesting;

import org.testng.annotations.Test;

import com.restAssured.ReusableMethod;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.IOException;

public class UdemyJiraAPICookieBasedAuth {
	
	@Test
	public void testJiraAPI() throws IOException {
		RestAssured.baseURI = "http://localhost:8080";
		//login to Jira using SessionFilter cookie
		
		SessionFilter session = new SessionFilter();
		given().log().all().header("Content-Type","application/json").
		body("{ \"username\": \"raniacssgoswami\", \"password\": \"C0gni@31\" }").filter(session)
		.when().post("/rest/auth/1/session").then().log().all().extract().response().asString();
		
		//Create new issue in Jira
		/*String response = given().log().all().header("Content-Type","application/json").body("{\r\n" + 
				"    \"fields\": {\r\n" + 
				"        \"project\": {\r\n" + 
				"            \"key\": \"RSA\"\r\n" + 
				"        },\r\n" + 
				"        \"summary\": \"Create new issue\",\r\n" + 
				"        \"description\": \"Create new issue in Jira\",\r\n" + 
				"        \"issuetype\": {\r\n" + 
				"            \"name\": \"Bug\"\r\n" + 
				"        }\r\n" + 
				"    }\r\n" + 
				"}").filter(session).when().post("/rest/api/2/issue").then().log().all().extract().response().asString();
		JsonPath jpath = new JsonPath(response);
		String id1 = jpath.getString("id");*/
		//System.out.println("id is : "+id);
		
		// Write data to Property File
		//ReusableMethod.writeDataToPropertyFile("id", id1);
		
		//Read data from Property File
		String id = ReusableMethod.readDataFromPropertyFile("id");
		//System.out.println("id is "+id);
		
		//Delete newly created issue in Jira
		/*given().pathParam("id", id).filter(session).when().delete("rest/api/2/issue/{id}").then().log().all().assertThat().
		statusCode(204).extract().response().asString();*/
		
		//Add Comment in Jira API
		
		/*String addCommentResp = given().pathParam("id", id).log().all().header("Content-Type","application/json").body("{\r\n" + 
				"    \r\n" + 
				"    \"body\": \"Added comment in Jira Issue\",\r\n" + 
				"    \"visibility\": {\r\n" + 
				"        \"type\": \"role\",\r\n" + 
				"        \"value\": \"Administrators\"\r\n" + 
				"    }\r\n" + 
				"}").filter(session).when().post("/rest/api/2/issue/{id}/comment").
		then().log().all().assertThat().statusCode(201).extract().response().asString();
		
		System.out.println("add Comment Response  "+addCommentResp);
		
		JsonPath addComm = ReusableMethod.rawToJson(addCommentResp);
		String commentId = addComm.get("id");
		ReusableMethod.writeDataToPropertyFile("commentId", commentId);*/
		String commentId = ReusableMethod.readDataFromPropertyFile("commentId");
		
		//Update comment in Jira API
		
		String updatedComment = "I am now updating comment section for testing";
		
		given().log().all().pathParam("id", id).pathParam("commentId", commentId).header("content-type","application/json")
		.body("\r\n" + 
				"    {\r\n" + 
				"    \"body\": \""+updatedComment+"\",\r\n" + 
				"    \"visibility\": {\r\n" + 
				"        \"type\": \"role\",\r\n" + 
				"        \"value\": \"Administrators\"\r\n" + 
				"    }\r\n" + 
				"}").filter(session).when().put("/rest/api/2/issue/{id}/comment/{commentId}")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		//Add attachment in Jira API
		/*String attachmentResponse = given().log().all().pathParam("id", id).header("X-Atlassian-Token","no-check").filter(session)
		.header("Content-Type","multipart/form-data").multiPart("file",new File(".\\Resources\\JiraAttchment.txt"))
		.when().post("/rest/api/2/issue/{id}/attachments").then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath JpathAttchResp = ReusableMethod.rawToJson(attachmentResponse);
		System.out.println("attachment Response  "+JpathAttchResp.get().toString());*/
		
		//Get issue in Jira API
		
		String getIssueResponse = given().log().all().filter(session).pathParam("id", id).queryParam("fields", "comment")
				.when().get("rest/api/2/issue/{id}").then().log().all()
		.assertThat().statusCode(200).extract().response().asString();
		
		JsonPath jpathGetIssue = ReusableMethod.rawToJson(getIssueResponse);
		int commentFieldSize = jpathGetIssue.getInt("fields.comment.comments.size()");
		String actualCommentBody = null;
		for(int i = 0; i<commentFieldSize;i++) {
			String jiraId = jpathGetIssue.get("fields.comment.comments["+i+"].id").toString();
			System.out.println("jiraId  "+jiraId);
			if(commentId.equalsIgnoreCase(jiraId)) {
			 actualCommentBody = jpathGetIssue.getString("fields.comment.comments["+i+"].body");
			System.out.println("actual Comment Body "+actualCommentBody);
			}
		}
		
		Assert.assertEquals(updatedComment, actualCommentBody);
	}

}
