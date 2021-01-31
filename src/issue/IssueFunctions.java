package issue;
import java.util.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class IssueFunctions {
	Map<Integer, Issue> issues = IssueList.getIssues();
	
	public int createIssue(int priority, String title, String description, String assignedTo) {
		Issue i = new Issue(priority, title, description, assignedTo);
		issues.put(i.getId(), i);
		return i.getId();		
	}
	
	public void deleteIssue(int id) {
		if(issues.get(id) != null)
			issues.remove(id);
		else
			System.out.println("Issue with this id does not exist");
	}
	
	public Issue viewById(int id) {
		if(issues.get(id) != null)
			return issues.get(id);
		else
			System.out.println("Issue does not exist");
			return issues.get(id);
	}
	
	public HashMap<Integer, Issue> viewByPriority() {
		//return sorted list of issues by priority
		List<Map.Entry<Integer, Issue>> list = new LinkedList<Map.Entry<Integer, Issue> >(issues.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<Integer, Issue> >() { 
            public int compare(Map.Entry<Integer, Issue> o1,  Map.Entry<Integer, Issue> o2) { 
                Issue a1 = o1.getValue();
                Issue a2 = o2.getValue();
                return (a1.getPriority()).compareTo(a2.getPriority()); 
            } 
        });
		
		HashMap<Integer, Issue> temp = new LinkedHashMap<Integer, Issue>(); 
        for (Map.Entry<Integer, Issue> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
        return temp; 
    }
	
	public HashMap<Integer, Issue> viewByAssignedTo(String name) {
		HashMap<Integer, Issue> myList = new HashMap<Integer, Issue>();
		for (Map.Entry<Integer,Issue> entry : issues.entrySet()) {
			if((entry.getValue().getAssignedTo()).equals(name)) {
				myList.put(entry.getValue().getId(), entry.getValue());
			}
		}
		return myList;
	}
	
	public void updateIssuePriority(Integer id, int priority) {
		Issue i = issues.get(id);
		if(i != null)
			i.setPriority(priority);
		else
			System.out.println("No issue with such Id");
	}
	
	public void updateIssueDescription(Integer id, String desc) {
		Issue i = issues.get(id);
		if(i != null)
			i.setDescription(desc);
		else
			System.out.println("No issue with such Id");
	}
	
	public void updateAssignedTo(Integer id, String assignedTo) {
		Issue i = issues.get(id);
		if(i != null)
			i.setAssignedTo(assignedTo);
		else
			System.out.println("No issue with such Id");
	}
}
