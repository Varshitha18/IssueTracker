package tracker;

import java.util.Arrays;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateRegistration {
	UserDetails u = new UserDetails();
	public boolean checkUserDetails(String email, String password, String confirmPassword) {
		if(validPassword(password, confirmPassword) && validEmail(email)) {
			//System.out.println("ValidateREgistration line 11");
			Map<String, String> Users = u.getUsers();
			if(Users.containsKey(email)) {
				//System.out.println("ValidateREgistration line 14");
				return false;
			}
			Users.put(email,  password);
			//System.out.println(Arrays.asList(Users));
			return true;
		}
		else {
			//System.out.println("ValidateREgistration line 21");
			return false;
		}
		
	}
	private boolean validPassword(String password, String confirmPassword) {
		if(password == " ") {
			//System.out.println(password.length());
			return false;
		}
		if(!(password.equals(confirmPassword))) {
			//System.out.println(password + " "+confirmPassword);
			return false;
		}
		//System.out.println(password.length());
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
		//System.out.println("ValidateREgistration line 43");
		return false;
	}
	
	private boolean validEmail(String email) {
		if(email == " ") {
			//System.out.println("ValidateREgistration line 48");
			return false;
		}
		Pattern p = Pattern.compile("[a-zA-Z0-9_@.]");
		Matcher m = p.matcher(email);
		//System.out.println("ValidateREgistration line 50");
		//System.out.println(m.find());
		return m.find();
		
	}
}