package tracker;

import java.util.Arrays;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateRegistration {
	UserDetails u = new UserDetails();
	public boolean checkUserDetails(String email, String password, String confirmPassword) {
		if(validPassword(password, confirmPassword) && validEmail(email)) {
			Map<String, String> Users = u.getUsers();
			if(Users.containsKey(email)) {
				System.out.println("You are already registered with this email");
				return false;
			}
			Users.put(email,  password);
			return true;
		}
		else {
			return false;
		}
		
	}
	private boolean validPassword(String password, String confirmPassword) {
		if(password == " ") {
			System.out.println("Password field is empty");
			return false;
		}
		if(!(password.equals(confirmPassword))) {
			System.out.println("Password and confirm password do not match");
			return false;
		}
		if(password.length() >= 8 && password.length() <= 20) {
			Pattern sl = Pattern.compile("[a-z]");
			Pattern cl = Pattern.compile("[A-Z]");
			Pattern n = Pattern.compile("[0-9]");
			
			Matcher msl = sl.matcher(password);
			Matcher mcl = cl.matcher(password);
			Matcher mn = n.matcher(password);
			
			if(msl.find() && mcl.find() && mn.find())
				return true;
		}
		System.out.println("Password does not match the rules");
		return false;
	}
	
	private boolean validEmail(String email) {
		if(email == " ") {
			System.out.println("Email field is empty");
			return false;
		}
		Pattern p = Pattern.compile("[a-zA-Z0-9_@.]");
		Matcher m = p.matcher(email);
		return m.find();
		
	}
}