package RestAssured;

import org.testng.annotations.Test;

import groovy.util.logging.Log;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
public class FileUploadAndDownload {

	
	@Test
	void singlefileupload() 
	{
	File myfile= new File("File location");
	given()
	.multiPart("file",myfile)
	.contentType("multipart/form-data")
	.when()
	.post("http://Localhost:8080/uploadFile")
	.then()
	.statusCode(200)
	.body("fileName", equalTo("Test1.txt"))
	.log().all();
	}
	
	@Test
	void fileDownload() 
	{
	given()
	.when()
	.get("http://Localhost:8080/downloadFile/Test1.txt")
	.then()
	.statusCode(200)
	.log().body();
	}
	
	
	
	
}
