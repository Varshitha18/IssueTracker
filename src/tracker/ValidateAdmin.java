package tracker;

public class ValidateAdmin {
	public boolean validateAdmincheck(String email, String password) {
		if(email.equals("admin@gmail.com")) {
			if(password.equals("Admin123")) {
				return true;
			}
		}
		return false;
	}
}
