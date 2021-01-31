package issue;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;


public class IssueList {
	private static Map<Integer, Issue> issues = new HashMap();

	public static Map<Integer, Issue> getIssues() {
		return issues;
	}

	public static void setIssues(Map<Integer, Issue> issues) {
		IssueList.issues = issues;
	}
	
}
