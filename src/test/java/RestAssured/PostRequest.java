package RestAssured;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class PostRequest {
	// 1) Post request body using Hashmap

	//@Test(priority=1)
	public void testpostusingHashmap() 
	{
		HashMap data = new HashMap<>();
		data.put("name", "Ripou");
		data.put("location", "Algeria");
		data.put("phone", "159753456");
		String courseArr[]= {"C","C++"};
		data.put("courses", courseArr);
		given().contentType("application/json")
		.body(data)
		.when()
		.post("http://localhost:3000/Students")
		.then()
		.statusCode(201)
		.body("name", equalTo("Ripou"))
		.body("location",equalTo("Algeria"))
		.body("phone", equalTo("159753456"))
		.body("courses[0]", equalTo("C"))
		.body("courses[1]", equalTo("C++"))
		.header("content-Type","application/json; charset=utf-8")
		.log().all();	
	}


	//deleting student record
	@Test(priority=2)
	public void testDelete() 
	{

		given()
		.when().delete("http://localhost:3000/Students/8")
		.then().statusCode(200);

	}

// Post request body using org.json library
//	@Test(priority=1)
	public void testpostusingJsonLibrary() 
	{
		JSONObject data = new JSONObject();
		data.put("name", "Kamal");
		data.put("location", "Algeria");
		data.put("phone", "159758888");
		String courseArr[]= {"C","php"};
		data.put("courses", courseArr);
		
		
		given().contentType("application/json")
		.body(data.toString())
		.when()
		.post("http://localhost:3000/Students")
		.then()
		.statusCode(201)
		.body("name", equalTo("Kamal"))
		.body("location",equalTo("Algeria"))
		.body("phone", equalTo("159758888"))
		.body("courses[0]", equalTo("C"))
		.body("courses[1]", equalTo("php"))
		.header("content-Type","application/json; charset=utf-8")
		.log().all();	
	}


	// Post request body using POJO library
//	@Test(priority=1)
	public void testpostusingPOJO() 
	{
		POJO_PostRequest data = new POJO_PostRequest();
		data.setName("Kamal");
		data.setLocation("Algeria");
		data.setPhone("8887779999");
		String courseArr[]= {"C","php"};
		data.setCourses(courseArr);
		given().contentType("application/json")
		.body(data)
		.when()
		.post("http://localhost:3000/Students")
		.then()
		.statusCode(201)
		.body("name", equalTo("Kamal"))
		.body("location",equalTo("Algeria"))
		.body("phone", equalTo("8887779999"))
		.body("courses[0]", equalTo("C"))
		.body("courses[1]", equalTo("php"))
		.header("content-Type","application/json; charset=utf-8")
		.log().all();	
	}

// Post request body using POJO library
	@Test(priority=1)
	public void testpostusingExternalJsonFile() throws FileNotFoundException 
	{
		File f= new File(".\\body.json");
	    FileReader fr= new FileReader(f);
	    JSONTokener jt= new JSONTokener(fr);
	    JSONObject data = new JSONObject(jt);
	
		given().contentType("application/json")
		.body(data.toString())
		.when()
		.post("http://localhost:3000/Students")
		.then()
		.statusCode(201)
		.body("name", equalTo("Rashida"))
		.body("location",equalTo("London"))
		.body("phone", equalTo("8882228888"))
		.body("courses[0]", equalTo("java"))
		.body("courses[1]", equalTo("love"))
		.header("content-Type","application/json; charset=utf-8")
		.log().all();	
	}








}
