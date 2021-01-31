package testing;

import tracker.UserDetails;
import tracker.ValidateUser;
import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

public class LoginCheckTest {
	ValidateUser valid = new ValidateUser();
	
	UserDetails u = new UserDetails();
	Map<String, String> Users = u.getUsers();
	
	
	@Test
	public void testValidation() {
		Users.put("v@gmail.com", "Qwerty18");
		assertEquals(true, valid.validate("v@gmail.com", "Qwerty18"));
		assertEquals(false, valid.validate("v@gmail.com", "Qwerty1"));
	}
}
