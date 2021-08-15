package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import library.User;

import static io.restassured.RestAssured.*;

public class TC_001_happyPaths {

	public int id = 0;
	
	/*
	@Test
	public void tc_001_validateGetStatusCode() {
		
		RestAssured.baseURI = "https://gorest.co.in";
		
		Response response = given().header("Content-type", "application/json")
		.when().get("/public/v1/users")
		.then().log().all().extract().response();
		
		int actualStatusCode = response.getStatusCode();
		int expectedStatusCode = 200;
		Assert.assertEquals(actualStatusCode, expectedStatusCode);
	}**/
	

		
	
	/*
	@Test
	public void tc_001_validateGetUserStatusCode() {
		
		RestAssured.baseURI = "https://gorest.co.in";
		
		Response response = given().log().all().header("Content-type", "application/json")
				.body(User.newUser("Tajinder Singh", "teji_dhoot@yahoo.com", "male", "active"))
		.when().get("/public/v1/users/"+id)
		.then().log().all().extract().response();
		
		int actualStatusCode = response.getStatusCode();
		int expectedStatusCode = 200;
		Assert.assertEquals(actualStatusCode, expectedStatusCode);
	}
	
	@Test (priority = 1)
	public void tc_001_validatePostStatusCode() {
		
		RestAssured.baseURI = "https://gorest.co.in";
		
		Response response = given().log().all().headers("Content-type", "application/json", 
				"Authorization", "Bearer c7bef3a24387bcb85e3fdf6ce09cc964a8bbad24bcff1521d5eac0a7e4ede9a1")
				.body(User.newUser("Tajinder Singh", "teji3.dhoot@yahoo.com", "male", "active"))
		.when().post("/public/v1/users")
		.then().log().all().extract().response();
		
		int actualStatusCode = response.getStatusCode();
		int expectedStatusCode = 201;
		
		JsonPath js = new JsonPath(response.asString());
		id = js.getInt("data.id");
		System.out.println(id);
		Assert.assertEquals(actualStatusCode, expectedStatusCode);
	}**/

	
	@Test (priority = 2)
	public void tc_001_validateDeleteStatusCode() {
		
		RestAssured.baseURI = "https://gorest.co.in";
		
		Response response = given().header("Content-type", "application/json", 
				"Authorization", "Bearer c7bef3a24387bcb85e3fdf6ce09cc964a8bbad24bcff1521d5eac0a7e4ede9a1")
		.when().delete("/public/v1/users/2316")
		.then().log().all().extract().response();
		
		int actualStatusCode = response.getStatusCode();
		int expectedStatusCode = 204;
		Assert.assertEquals(actualStatusCode, expectedStatusCode);
	}


}
