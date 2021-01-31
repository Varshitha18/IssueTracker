package testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import issue.IssueFunctions;

public class IssueFunctionTest {
	IssueFunctions fi = new IssueFunctions();
	
	@Test
	public void checkDescriptionUpdate() {
		fi.createIssue(3, "Update Problem", "Update function not working", "Veda");
		fi.updateIssueDescription(1000, "Parts of update not working");
		assertEquals("Parts of update not working", fi.viewById(1000).getDescription());
	}

	@Test
	public void checkPriorityUpdate() {
		fi.createIssue(3, "Update Problems", "Update function not working properly", "Veda");
		fi.updateIssuePriority(1000, 5);
		assertEquals(5, fi.viewById(1000).getPriority(), 0.0001);
	}
	
	@Test
	public void checkAssignedToUpdate() {
		fi.createIssue(3, "Update Problemed", "Update function not working at all", "Veda");
		fi.updateAssignedTo(1000, "ABC");
		assertEquals("ABC", fi.viewById(1000).getAssignedTo());
	}
}
