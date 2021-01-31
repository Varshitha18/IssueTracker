package tracker;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ValidateUser {
	public boolean validate(String email, String password) {
		
		UserDetails u = new UserDetails();
		Map<String, String> Users = u.getUsers();
		
		Iterator hmIterator = Users.entrySet().iterator(); 
		while (hmIterator.hasNext()) { 
            Map.Entry mapElement = (Map.Entry)hmIterator.next(); 
            
            if(mapElement.getKey().equals(email)) {
            	if(mapElement.getValue().equals(password))
            		return true;
            	else
            		return false;
            }
	    }
		return false;
	}
}
