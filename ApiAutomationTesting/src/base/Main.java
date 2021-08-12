package base;


import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Main {

	public static void main(String[] args) {
		
		SessionFilter session = new SessionFilter();
		
		RestAssured.baseURI = "http://localhost:8080/";
		
		given().header("content-type", "application/json").filter(session).log().all()
		.body("{ \"username\": \"tajinder_singh_dhoot\", \"password\": \"LearnAutomation@1\" }")
		.when().post("rest/auth/1/session")
		.then().log().all();
		
		given().headers("content-type", "application/json")
		.body("{\r\n"
				+ "    \"update\": {\r\n"
				+ "        \"worklog\": [\r\n"
				+ "            {\r\n"
				+ "                \"add\": {\r\n"
				+ "                    \"timeSpent\": \"60m\",\r\n"
				+ "                    \"started\": \"2011-07-05T11:05:00.000+0000\"\r\n"
				+ "                }\r\n"
				+ "            }\r\n"
				+ "        ]\r\n"
				+ "    },\r\n"
				+ "    \"fields\": {\r\n"
				+ "        \"project\": {\r\n"
				+ "            \"id\": \"10000\"\r\n"
				+ "        },\r\n"
				+ "        \"summary\": \"something's wrong\",\r\n"
				+ "        \"issuetype\": {\r\n"
				+ "            \"id\": \"10000\"\r\n"
				+ "        },\r\n"
				+ "        \"assignee\": {\r\n"
				+ "            \"name\": \"homer\"\r\n"
				+ "        },\r\n"
				+ "        \"reporter\": {\r\n"
				+ "            \"name\": \"smithers\"\r\n"
				+ "        },\r\n"
				+ "        \"priority\": {\r\n"
				+ "            \"id\": \"20000\"\r\n"
				+ "        },\r\n"
				+ "        \"labels\": [\r\n"
				+ "            \"bugfix\",\r\n"
				+ "            \"blitz_test\"\r\n"
				+ "        ],\r\n"
				+ "        \"timetracking\": {\r\n"
				+ "            \"originalEstimate\": \"10\",\r\n"
				+ "            \"remainingEstimate\": \"5\"\r\n"
				+ "        },\r\n"
				+ "        \"security\": {\r\n"
				+ "            \"id\": \"10000\"\r\n"
				+ "        },\r\n"
				+ "        \"versions\": [\r\n"
				+ "            {\r\n"
				+ "                \"id\": \"10000\"\r\n"
				+ "            }\r\n"
				+ "        ],\r\n"
				+ "        \"environment\": \"environment\",\r\n"
				+ "        \"description\": \"description\",\r\n"
				+ "        \"duedate\": \"2011-03-11\",\r\n"
				+ "        \"fixVersions\": [\r\n"
				+ "            {\r\n"
				+ "                \"id\": \"10001\"\r\n"
				+ "            }\r\n"
				+ "        ],\r\n"
				+ "        \"components\": [\r\n"
				+ "            {\r\n"
				+ "                \"id\": \"10000\"\r\n"
				+ "            }\r\n"
				+ "        ],\r\n"
				+ "        \"customfield_30000\": [\r\n"
				+ "            \"10000\",\r\n"
				+ "            \"10002\"\r\n"
				+ "        ],\r\n"
				+ "        \"customfield_80000\": {\r\n"
				+ "            \"value\": \"red\"\r\n"
				+ "        },\r\n"
				+ "        \"customfield_20000\": \"06/Jul/11 3:25 PM\",\r\n"
				+ "        \"customfield_40000\": \"this is a text field\",\r\n"
				+ "        \"customfield_70000\": [\r\n"
				+ "            \"jira-administrators\",\r\n"
				+ "            \"jira-software-users\"\r\n"
				+ "        ],\r\n"
				+ "        \"customfield_60000\": \"jira-software-users\",\r\n"
				+ "        \"customfield_50000\": \"this is a text area. big text.\",\r\n"
				+ "        \"customfield_10000\": \"09/Jun/81\"\r\n"
				+ "    }\r\n"
				+ "}").filter(session)
		.when().post("rest/api/2/issue")
		.then().log().all();
		
	}
}
