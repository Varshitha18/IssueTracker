package tracker;

import java.util.HashMap;
import java.util.Map;

public class UserDetails {
	private static Map<String, String> Users = new HashMap<String, String>();
	
	public void put(String email, String password) {
		Users.put(email,  password);
	}

	public Map<String, String> getUsers() {
		return Users;
	}

	public void setUsers(Map<String, String> users) {
		Users = users;
	}
	
	
}
