package pojo;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import library.LocalApi;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class MainClass {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "http://localhost:3000";
		given().log().all()
		.body(LocalApi.localServerApi())
		.when().post("/profile")
		.then().log().all().assertThat().statusCode(201);
	}
}
