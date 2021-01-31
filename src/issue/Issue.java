package issue;

import java.util.concurrent.atomic.AtomicInteger;

public class Issue {
	private Integer id;
	private int priority;
	private String title;
	private String description;
	private String assignedTo;
	private static AtomicInteger ID_GENERATOR = new AtomicInteger(1000);
	
	public Issue(int priority, String title, String description, String assignedTo) {
		this.priority = priority;
		this.title = title;
		this.description = description;
		this.assignedTo = assignedTo;
		id = ID_GENERATOR.getAndIncrement();
	}
	
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
