package tracker;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import issue.Issue;
import issue.IssueFunctions;

public class LoginSignup {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IssueFunctions f = new IssueFunctions();
		String email;
		String password;
		while(true) {
			System.out.println("If you want to login, type 1 ");
			System.out.println("If you want to signup, type 2 ");
			System.out.println("If you want to exit, type 3 ");
			System.out.println("If you want to create issue, type 4 ");
			System.out.println("If you want to delete issue, type 5 ");
			System.out.println("If you want to view by Id, type 6 ");
			System.out.println("If you want to view by priority, type 7 ");
			System.out.println("If you want to view issues assigned by name, type 8");
			System.out.println("If you want to update issue priority, type 9 ");
			System.out.println("If you want to update issue description, type 10 ");
			System.out.println("If you want to update issue assigned to, type 11 ");
			System.out.println("For admin login, type 12");
			int choice = sc.nextInt();
			
		if(choice == 1) {
			String x = sc.nextLine();
			System.out.println("Enter email id ");
			email = sc.nextLine();
			System.out.println("Enter password ");
			password = sc.nextLine();
			
			ValidateUser valid = new ValidateUser();
			if(valid.validate(email, password))
				System.out.println("Sign in successful");
			else
				System.out.println("Sign in unsuccessful");
		}
		
		
		else if(choice == 2) {
			System.out.println("Enter email id :");
			String x = sc.nextLine();
			email = sc.nextLine();
			System.out.println("Password must have a capital letter, a small letter and a number");
			System.out.println("and must have a min length of 8 and max length of 20");
			System.out.println("Set password :");
			password = sc.nextLine();
			System.out.println("Confirm password :");
			String confirmPassword = sc.nextLine();
			
			ValidateRegistration rv = new ValidateRegistration();
			if(rv.checkUserDetails(email, password, confirmPassword)) {
				System.out.println("Signup successful");
			}
			else
				System.out.println("Signup unsuccessful");
		}
		else if(choice == 3)
			break;
		
		else if(choice == 4) {
			System.out.println("Enter priority");
			int priority = sc.nextInt();
			System.out.println("Enter title");
			String x = sc.nextLine();
			String title = sc.nextLine();
			System.out.println("Enter description");
			String description = sc.nextLine();
			System.out.println("Enter assignedTo");
			String assignedTo = sc.nextLine();
			int id = f.createIssue(priority, title, description, assignedTo);
			System.out.print("ID for this issue is");
			System.out.println(id);
		}
		
		else if(choice == 5) {
			System.out.println("Enter id for issue to delete");
			int id = sc.nextInt();
			f.deleteIssue(id);
		}
		else if(choice == 6) {
			System.out.println("Enter id to view issue");
			int id = sc.nextInt();
			Issue vi = f.viewById(id);
			if(vi != null) {
				System.out.println("Id: " + vi.getId());
				System.out.println("Priority: " +vi.getPriority());
				System.out.println("Title: "+vi.getTitle());
				System.out.println("Description: "+vi.getDescription());
				System.out.println("Assigned to: "+vi.getAssignedTo());
			}
		}
		else if(choice == 7) {
			HashMap<Integer, Issue> vl = f.viewByPriority();
			if(vl.isEmpty())
				System.out.println("No issues exist");
			else {
				for (Map.Entry<Integer,Issue> entry : vl.entrySet()) {  
					System.out.println("ID : " + entry.getKey());
					//System.out.println("Id: " + entry.getValue().getId());
					System.out.println("Priority: " +entry.getValue().getPriority());
					System.out.println("Title: "+entry.getValue().getTitle());
					System.out.println("Description: "+entry.getValue().getDescription());
					System.out.println("Assigned to: "+entry.getValue().getAssignedTo());
					System.out.println();
				} 
			}
		}
		else if(choice == 8) {
			String x = sc.nextLine();
			System.out.println("Enter name to display issues assigned");
			String name = sc.nextLine();
			HashMap<Integer, Issue> vl = f.viewByAssignedTo(name);
			if(vl.isEmpty())
				System.out.println("No issues assigned to this name");
			else {
				for (Map.Entry<Integer,Issue> entry : vl.entrySet()) {  
					System.out.println("ID : " + entry.getKey());
					//System.out.println("Id: " + entry.getValue().getId());
					System.out.println("Priority: " +entry.getValue().getPriority());
					System.out.println("Title: "+entry.getValue().getTitle());
					System.out.println("Description: "+entry.getValue().getDescription());
					System.out.println("Assigned to: "+entry.getValue().getAssignedTo());
					System.out.println();
				}
			}
		}
		else if(choice == 9) {
			System.out.println("Enter priority");
			int priority = sc.nextInt();
			System.out.println("Enter id");
			int id = sc.nextInt();
			f.updateIssuePriority(id, priority);
		}
		else if(choice == 10) {
			System.out.println("Enter description");
			String x = sc.nextLine();
			String desc = sc.nextLine();
			System.out.println("Enter id");
			int id = sc.nextInt();
			f.updateIssueDescription(id, desc);
		}
		else if(choice == 11) {
			System.out.println("Enter assigned to");
			String x = sc.nextLine();
			String assigned = sc.nextLine();
			System.out.println("Enter id");
			int id = sc.nextInt();
			f.updateAssignedTo(id, assigned);
		}
		else if(choice == 12) {
			String x = sc.nextLine();
			System.out.println("Enter email id ");
			email = sc.nextLine();
			System.out.println("Enter password ");
			password = sc.nextLine();
			
			ValidateAdmin valid = new ValidateAdmin();
			if(valid.validateAdmincheck(email, password))
				System.out.println("Sign in successful");
			else
				System.out.println("Sign in unsuccessful");
		}
		else
			System.out.println("Please type a number between 1 to 12:");
	}
		sc.close();
}


}
