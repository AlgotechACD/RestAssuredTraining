package RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ParsingJSONResponseData {

	
	
	@Test(priority=1)
	void testJsonResponse() 
	{
/*
		given()
	.contentType("ContentType.JSON")
	.when()
	.get("http://localhost:3000/Students")
	.then()
	.statusCode(200)
	.header("Content-Type","application/json; charset=utf-8")
	.header("Content-Encoding","gzip")
	.body("Students[0].name",equalTo("John"));
	*/
    Response res=given()
	.contentType("ContentType.JSON")
	.when()
	.get("http://localhost:3000/Students");
     Assert.assertEquals( res.getStatusCode(),200);
     Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");	
    String StudentName=res.jsonPath().get(".Students[0].name").toString();
    Assert.assertEquals(StudentName,"John");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
