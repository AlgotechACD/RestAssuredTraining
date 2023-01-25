package RestAssured;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;



public class RestAssuredCookiesHeadersQueryPathParameters {

	/*
	 Rest Assured :
	 1) Path & Query parameters
	 https://reqres.in/api/users?page=2
	 https://reqres.in/api/users?page=2&id=5
	 https://reqres.in ==> domain 
	 ==>  api/users ==> path
	 ==> ?page=2 query parameter
	 ==> page=2&id=5 query parameter
	 */

	//@Test (priority=1)
	void testQueryAndPathParameters() {
		//https://reqres.in/api/users?page=2&id=5
		given()
		.pathParam("mypath", "users") // path parameter
		.queryParam("page", 2) //query parameter
		.queryParam("id", 5) //query parameter
		.when()
		.get("https://reqres.in/api/{mypath}")
		.then()
		.statusCode(200).log().all();
	}

	// Cookies and headers 

	//	@Test(priority=2)
	void testCookies() 
	{
		given()

		.when()
		.get("https://www.google.com/")
		.then()
		.cookie("AEC","ARSKqsIgLm1Ywm9i-hUVzf-ekO5e0v5pguHO6Sq4NxU5-ii33h3uok2yO2o")
		.log().all();
	}

	//@Test(priority=3)
	void getCookiesInfo() 
	{
		Response res =given()

				.when()
				.get("https://www.google.com/");
		// get single cookies info 
		//String cookie_value	 =res.getCookie("AEC");
		//System.out.println("Value of the cookie is ====> "+ cookie_value);

		// get all cookies info
		Map<String,String>cookies_values=res.getCookies();
		//System.out.println(cookies_values.keySet());

		for(String k:cookies_values.keySet()) 
		{
			String cookies_value=res.getCookie(k);
			System.out.println(k + "    "+cookies_value);
		}

	}

	//	@Test(priority=4)
	void testHeaders() 
	{
		given()

		.when()
		.get("https://www.google.com/")
		.then()
		.header("Content-Type","text/html; charset=ISO-8859-1")
		.and()
		.header("Content-Encoding","gzip")
		.and()
		.header("Server","gws")
		.log().all();
	}

	@Test(priority=5)
	void getHeaders() 
	{
		Response res=given()
				.when()
				.get("https://www.google.com/");
		// get single header info
		String headervalue=res.getHeader("Content-Type");
		System.out.println("The value of Content-type header is: "+headervalue );
		// get all headers info
		Headers	myheaders=res.getHeaders();

		for( Header hd:myheaders) 
		{
			System.out.println(hd.getName()+"     "+hd.getValue());
		}

	}


	@Test(priority=5)
	void testLogs() {
		given().when().get("https://www.google.com/")
		.then()
		.log().all()
		.log().body()
		.log().cookies()
		.log().headers();
		
	}




}
