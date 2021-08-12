package pojo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;


public class Place {

	public static void main(String[] args) {
		
		AddPlace ap = new AddPlace();
		ap.setAccuracy(111);
		ap.setName("Tajinder Singh Dhoot");
		ap.setPhone_number("+1 (123) 456 7890");
		ap.setAddress("House 123, Tobhe Wali Galli, Pind");
		ap.setWebsite("tajinder-dhoot.github.io");
		ap.setLanguage("Panjabi");
		
		List<String> list = new ArrayList<String>();
		list.add("My Home");
		list.add("Residence");
		
		ap.setTypes(list);
		Location loc = new Location();
		loc.setLat(-26.383494);
		loc.setLng(16.427362);
		
		ap.setLocation(loc);
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().queryParam("key", "qaclick123")
		.body(ap)
		.when().post("/maps/api/place/add/json")
		.then().log().all().extract().response().asString();
		
		
		System.out.println(response);
		System.out.println(ap.getName());
		System.out.println(ap.getTypes());
	}
}
