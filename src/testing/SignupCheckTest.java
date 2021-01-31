package testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import tracker.UserDetails;
import tracker.ValidateRegistration;

public class SignupCheckTest {
	UserDetails u = new UserDetails();
	ValidateRegistration vr = new ValidateRegistration();
		
	@Test
	public void TestRegistration() {
		assertEquals(true, vr.checkUserDetails("vv@gmail.com", "Asdw1234", "Asdw1234"));
		assertEquals(false, vr.checkUserDetails("vv@gmail.com", "Asd1234", "Asdw1234"));
		assertEquals(false, vr.checkUserDetails("vv@gmail.com", "Asdw1234", "Asd1234"));
		assertEquals(false, vr.checkUserDetails("vv@gmail.com", "Asdw123", "Asdw123"));
		assertEquals(false, vr.checkUserDetails("vv@gmail.com", "Asdw1234570", "Asd1234590"));
	}

	
	}
