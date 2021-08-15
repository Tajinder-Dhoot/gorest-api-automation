package library;

public class User {

	public static String newUser(String name, String email, String gender, String status) {
		
		return "{\r\n"
				+ "            \"name\": \""+name+"\",\r\n"
				+ "            \"email\": \""+email+"\",\r\n"
				+ "            \"gender\": \""+gender+"\",\r\n"
				+ "            \"status\": \""+status+"\"\r\n"
				+ "        }";
	}
}
