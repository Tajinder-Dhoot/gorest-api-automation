package classes;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class ApiTesting {

	public static void main(String[] args) {
	
	String newEmail = "babbarakaali@yahoo.com";
	RestAssured.baseURI = "https://gorest.co.in";
	
	// get users
	
	String response = given().queryParam("name", "Iqb Singh")
	.when()
	.get("\r\n"
			+ "public/v1/users")
	.then()
	.log().body().assertThat().statusCode(200)
	.extract().response().asString();
	
	JsonPath js = new JsonPath(response);
	int id = js.getInt("data[0].id");
	String originalEmail = js.getString("data[0].email");
	
	
	// create a new user
	/*
	given().headers("Content-Type", "application/json", 
			"Authorization", "Bearer c7bef3a24387bcb85e3fdf6ce09cc964a8bbad24bcff1521d5eac0a7e4ede9a1")
	.body("{\r\n"
			+ "    \"id\": 7777,\r\n"
			+ "    \"name\": \"Iqb Singh\",\r\n"
			+ "    \"email\": \"iqbsingh@gmail.com\",\r\n"
			+ "    \"gender\": \"male\",\r\n"
			+ "    \"status\": \"active\",\r\n"
			+ "    \"phone\": \"1234567890\"\r\n"
			+ "}")
	.when().post("public/v1/users")
	.then().log().all();
	**/
	
	// update user details
	
	String responseUpdate = given().headers("Content-Type", "application/json", 
			"Authorization", "Bearer c7bef3a24387bcb85e3fdf6ce09cc964a8bbad24bcff1521d5eac0a7e4ede9a1")
	.body("{\r\n"
			+ "    \"name\": \"Iqb Singh\",\r\n"
			+ "    \"email\": \""+newEmail+"\",\r\n"
			+ "    \"gender\": \"male\",\r\n"
			+ "    \"status\": \"active\",\r\n"
			+ "    \"phone\": \"1234567890\"\r\n"
			+ "}")
	.when().put("public/v1/users/"+id)
	.then().assertThat().statusCode(200).extract().response().asString();
	
	
	
	// get new user details
	given().headers("Content-Type", "application/json").queryParam("id", id)
	.when().get("public/v1/users")
	.then().log().body().assertThat().statusCode(200);
	
	}
}
